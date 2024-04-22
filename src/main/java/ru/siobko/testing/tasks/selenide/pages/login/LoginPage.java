package ru.siobko.testing.tasks.selenide.pages.login;

import org.openqa.selenium.By;
import ru.siobko.testing.tasks.selenide.pages.BasePage;
import ru.siobko.testing.tasks.selenide.pages.main.FeedPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private static final By emailField = byName("st.email");
    private static final By passwordField = byName("st.password");
    private static final By submitButton = byValue("Log in to OK");

    public LoginPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(emailField).shouldBe(
                exist.because("Email field should be exist on login page.")
        );
        $(passwordField).shouldBe(
                exist.because("Password field should be exist on login page.")
        );
        $(submitButton).shouldBe(
                exist.because("Submit button should be exist on login page.")
        );
        return true;
    }

    public LoginPage enterEmail(String email) {
        $(emailField).shouldBe(
                visible.because("Email field should be exist on login page.")
        ).setValue(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        $(passwordField).shouldBe(
                visible.because("Password field should be exist on login page.")
        ).setValue(password);
        return this;
    }

    public FeedPage clickSubmit() {
        $(submitButton).shouldBe(
                visible.because("Submit button should be exist on login page.")
        ).click();
        return new FeedPage();
    }
}
