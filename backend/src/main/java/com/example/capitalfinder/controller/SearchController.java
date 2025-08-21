package com.example.capitalfinder.controller;

import com.example.capitalfinder.model.Country;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SearchController {

    private static final List<Country> COUNTRIES = Arrays.asList(
        new Country("Australia", Arrays.asList("Canberra"), Arrays.asList("Melbourne"), "Seat moved from Melbourne 1927"),
        new Country("Brazil", Arrays.asList("Brasília"), Arrays.asList("Rio de Janeiro"), "Capital moved in 1960"),
        new Country("Germany", Arrays.asList("Berlin"), Arrays.asList("Bonn"), "Bonn was capital of West Germany"),
        new Country("South Africa", Arrays.asList("Pretoria (executive)", "Cape Town (legislative)", "Bloemfontein (judicial)"), Collections.emptyList(), "Three-capital system"),
        new Country("Turkey", Arrays.asList("Ankara"), Arrays.asList("Istanbul"), "Changed in 1923"),
        new Country("United States", Arrays.asList("Washington, D.C."), Arrays.asList("Philadelphia","New York City"), "Temporary capitals before 1800")
    );

    @GetMapping("/search")
    public List<Country> search(@RequestParam String query) {
        String q = query.toLowerCase();
        List<Country> results = new ArrayList<>();
        for (Country c : COUNTRIES) {
            if (c.getName().toLowerCase().contains(q) ||
                c.getCapitals().stream().anyMatch(cap -> cap.toLowerCase().contains(q)) ||
                c.getFormerCapitals().stream().anyMatch(fc -> fc.toLowerCase().contains(q))) {
                results.add(c);
            }
        }
        return results;
    }
}
