package com.example.githubapifetch;

public class owner {
    private String login;
    private String avatar_url;

    public owner(String login, String avatar_url) {
        this.login = login;
        this.avatar_url = avatar_url;
    }

    String getLogin() {
        return login;
    }

    String getAvatar_url() {
        return avatar_url;
    }
}

