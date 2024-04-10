package ru.siobko.testing.tasks.junit.core.main;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private static final By emailField = byName("st.email");
    private static final By passwordField = byName("st.password");
    private static final By submitButton = byValue("Log in to OK");

    private static final String EMAIL_FIELD_LOG_INFO = "Email field should be exist on login page.";
    private static final String PASSWORD_FIELD_LOG_INFO = "Password field should be exist on login page.";
    private static final String SUBMIT_BUTTON_LOG_INFO = "Submit button should be exist on login page.";

    public LoginPage() {
        checkPage();
    }

    public static boolean checkPage() {
        $(emailField).shouldBe(
                exist.because(EMAIL_FIELD_LOG_INFO)
        );
        $(passwordField).shouldBe(
                exist.because(PASSWORD_FIELD_LOG_INFO)
        );
        $(submitButton).shouldBe(
                exist.because(SUBMIT_BUTTON_LOG_INFO)
        );
        return true;
    }

    public FeedPage login(String email, String password) {
        $(emailField).shouldBe(
                visible.because(EMAIL_FIELD_LOG_INFO)
        ).setValue(email);
        $(passwordField).shouldBe(
                visible.because(PASSWORD_FIELD_LOG_INFO)
        ).setValue(password);
        $(submitButton).shouldBe(
                visible.because(SUBMIT_BUTTON_LOG_INFO)
        ).click();
        return new FeedPage();
    }
}
