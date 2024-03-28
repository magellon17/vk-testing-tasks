package ru.siobko.testing.tasks.selenide.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public final SelenideElement emailField = $(By.name("st.email"));
    public final SelenideElement passwordField = $(By.name("st.password"));
    public final SelenideElement submitButton = $(byValue("Log in to OK"));

    public LoginPage open() {
        Selenide.open("/");
        return this;
    }
    public FeedPage login(String email, String password) {
        emailField.setValue(email);
        passwordField.setValue(password);
        submitButton.click();
        return new FeedPage();
    }
}
