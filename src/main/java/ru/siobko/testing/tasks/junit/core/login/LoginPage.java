package ru.siobko.testing.tasks.junit.core.login;

import org.openqa.selenium.By;
import ru.siobko.testing.tasks.junit.core.BasePage;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;

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

    public static boolean checkPage() {
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

    public void enterEmail(String email) {
        $(emailField).shouldBe(
                visible.because("Email field should be exist on login page.")
        ).setValue(email);
    }

    public void enterPassword(String password) {
        $(passwordField).shouldBe(
                visible.because("Password field should be exist on login page.")
        ).setValue(password);
    }

    public FeedPage clickSubmit() {
        $(submitButton).shouldBe(
                visible.because("Submit button should be exist on login page.")
        ).click();
        return new FeedPage();
    }

    public FeedPage login(String email, String password) {
        $(emailField).shouldBe(
                visible.because("Email field should be visible on login page.")
        ).setValue(email);
        $(passwordField).shouldBe(
                visible.because("Password field should be visible on login page.")
        ).setValue(password);
        $(submitButton).shouldBe(
                visible.because("Submit button should be visible on login page.")
        ).click();
        return new FeedPage();
    }
}
