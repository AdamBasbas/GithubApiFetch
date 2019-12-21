package com.example.githubapifetch;

public class Repo {
    private String name;
    private String description;
    private Integer stargazers_count;
    private String login;
    private String avatar_url;

    public Repo(String name, String description, Integer stargazers_count, String login, String avatar_url) {
        this.name = name;
        this.description = description;
        this.stargazers_count = stargazers_count;
        this.login = login;
        this.avatar_url = avatar_url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStargazers_count() {
        return stargazers_count;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }
}
