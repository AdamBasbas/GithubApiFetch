package com.example.githubapifetch;

import java.util.ArrayList;

public class items {
    private String name;
    private String description;
    private String stargazers_count;
    private ArrayList<owner> owner;

    public items(String name, String description, String stargazers_count, ArrayList<com.example.githubapifetch.owner> owner) {
        this.name = name;
        this.description = description;
        this.stargazers_count = stargazers_count;
        this.owner = owner;
    }

    String getName() {
        return name;
    }

    String getDescription() {
        return description;
    }

    String getStargazers_count() {
        return stargazers_count;
    }

    ArrayList<com.example.githubapifetch.owner> getOwner() {
        return owner;
    }
}

