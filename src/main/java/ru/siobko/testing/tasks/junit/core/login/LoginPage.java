package ru.siobko.testing.tasks.junit.core.login;

import org.openqa.selenium.By;
import ru.siobko.testing.tasks.junit.core.BasePage;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;
import ru.siobko.testing.tasks.junit.models.TestBot;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private static final By EMAIL_FIELD = byName("st.email");
    private static final By PASSWORD_FIELD = byName("st.password");
    private static final By SUBMIT_BUTTON = byValue("Log in to OK");

    public LoginPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(EMAIL_FIELD).shouldBe(
                exist.because("Email field should be exist on login page.")
        );
        $(PASSWORD_FIELD).shouldBe(
                exist.because("Password field should be exist on login page.")
        );
        $(SUBMIT_BUTTON).shouldBe(
                exist.because("Submit button should be exist on login page.")
        );
        return true;
    }

    public LoginPage enterEmail(String email) {
        $(EMAIL_FIELD).shouldBe(
                visible.because("Email field should be exist on login page.")
        ).setValue(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        $(PASSWORD_FIELD).shouldBe(
                visible.because("Password field should be exist on login page.")
        ).setValue(password);
        return this;
    }

    public FeedPage clickSubmit() {
        $(SUBMIT_BUTTON).shouldBe(
                visible.because("Submit button should be exist on login page.")
        ).click();
        return new FeedPage();
    }

    public FeedPage login(TestBot bot) {
        $(EMAIL_FIELD).shouldBe(
                visible.because("Email field should be exist on login page.")
        ).setValue(bot.getEmail());

        $(PASSWORD_FIELD).shouldBe(
                visible.because("Password field should be exist on login page.")
        ).setValue(bot.getPassword());

        $(SUBMIT_BUTTON).shouldBe(
                visible.because("Submit button should be exist on login page.")
        ).click();
        return new FeedPage();
    }

    public String getEmailFieldText() {
        return $(EMAIL_FIELD).shouldBe(
                visible.because("Email field should be visible on login page.")
        ).getValue();
    }

    public String getPasswordFieldText() {
        return $(PASSWORD_FIELD).shouldBe(
                visible.because("Password field should be visible on login page.")
        ).getValue();
    }
}
