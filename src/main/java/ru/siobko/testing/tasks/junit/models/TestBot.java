package ru.siobko.testing.tasks.junit.models;

public class TestBot {
    private final String email;
    private final String password;

    public TestBot(String login, String password) {
        this.email = login;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
