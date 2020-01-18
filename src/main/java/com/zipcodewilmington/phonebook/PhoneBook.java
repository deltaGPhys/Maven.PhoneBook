package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private TreeMap<String, ArrayList<String>> map;

    public PhoneBook(TreeMap<String, ArrayList<String>> map) {
        if (map != null) {
            this.map = map;
        } else {
            this.map = new TreeMap<String, ArrayList<String>>();
        }
    }

    public PhoneBook() {
        this.map = new TreeMap<String, ArrayList<String>>();
    }

    public void add(String name, String phoneNumber) {
        ArrayList<String> currentNums = this.map.getOrDefault(name, new ArrayList<String>());
        currentNums.add(phoneNumber);
        this.map.put(name, currentNums);
    }

    public void addAll(String name, String... phoneNumbers) {
        ArrayList<String> currentNums = this.map.getOrDefault(name, new ArrayList<String>());
        currentNums.addAll(new ArrayList<String>(Arrays.asList(phoneNumbers)));
        this.map.put(name, currentNums);
    }

    public void remove(String name) {
        this.map.remove(name);
    }

    public Boolean hasEntry(String name) {
        return this.map.containsKey(name);
    }

    public List<String> lookup(String name) {
        return this.map.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        ArrayList<String> numbers;
        for (String key : this.map.keySet()) {
            numbers = this.map.get(key);
            if (numbers.contains(phoneNumber)) {
                return key;
            }
        }
        return null;
    }

    public ArrayList<String> getAllContactNames() {
        return new ArrayList<>(this.map.keySet());
    }

    public TreeMap<String, ArrayList<String>> getMap() {
        return this.map;
    }
}
