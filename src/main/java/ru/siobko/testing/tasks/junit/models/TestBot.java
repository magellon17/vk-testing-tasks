package ru.siobko.testing.tasks.junit.models;

public class TestBot {
    private final String login;
    private final String password;

    public TestBot(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
