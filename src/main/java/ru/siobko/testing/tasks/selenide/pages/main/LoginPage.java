package ru.siobko.testing.tasks.selenide.pages.main;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement emailField = $(By.name("st.email"));
    private final SelenideElement passwordField = $(By.name("st.password"));
    private final SelenideElement submitButton = $(byValue("Log in to OK"));

    public LoginPage() {
        checkPage();
    }

    private void checkPage() {
        emailField.shouldBe(visible);
        passwordField.shouldBe(visible);
        submitButton.shouldBe(visible);
    }

    public FeedPage login(String email, String password) {
        emailField.setValue(email);
        passwordField.setValue(password);
        submitButton.click();
        return new FeedPage();
    }
}
