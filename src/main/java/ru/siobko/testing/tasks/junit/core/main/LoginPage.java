package ru.siobko.testing.tasks.junit.core.main;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private static final By emailField = byName("st.email");
    private static final By passwordField = byName("st.password");
    private static final By submitButton = byValue("Log in to OK");

    public LoginPage() {
        checkPage();
    }

    public static boolean checkPage() {
        $(emailField).shouldBe(exist);
        $(passwordField).shouldBe(exist);
        $(submitButton).shouldBe(exist);
        return true;
    }

    public FeedPage login(String email, String password) {
        $(emailField).setValue(email);
        $(passwordField).setValue(password);
        $(submitButton).click();
        return new FeedPage();
    }
}
