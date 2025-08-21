package com.example.capitalfinder.model;

import java.util.List;

public class Country {
    private String name;
    private List<String> capitals;
    private List<String> formerCapitals;
    private String notes;

    public Country(String name, List<String> capitals, List<String> formerCapitals, String notes) {
        this.name = name;
        this.capitals = capitals;
        this.formerCapitals = formerCapitals;
        this.notes = notes;
    }

    public String getName() { return name; }
    public List<String> getCapitals() { return capitals; }
    public List<String> getFormerCapitals() { return formerCapitals; }
    public String getNotes() { return notes; }
}
