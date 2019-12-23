package com.example.githubapifetch;

import java.util.ArrayList;

public class Repo {
    private ArrayList<items> items;

    public Repo(ArrayList<com.example.githubapifetch.items> items) {
        this.items = items;
    }

    ArrayList<com.example.githubapifetch.items> getItems() {
        return items;
    }

}


