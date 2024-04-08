package ru.siobko.testing.tasks.junit.pages.main;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final By emailField = byName("st.email");
    private final By passwordField = byName("st.password");
    private final By submitButton = byValue("Log in to OK");

    public LoginPage() {
        checkPage();
    }

    private void checkPage() {
        $(emailField).shouldBe(visible);
        $(passwordField).shouldBe(visible);
        $(submitButton).shouldBe(visible);
    }

    public FeedPage login(String email, String password) {
        $(emailField).setValue(email);
        $(passwordField).setValue(password);
        $(submitButton).click();
        return new FeedPage();
    }
}
