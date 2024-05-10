package ru.siobko.testing.tasks.patterns.core.login;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.BasePage;
import ru.siobko.testing.tasks.patterns.core.main.user.feed.MyProfileMainPage;
import ru.siobko.testing.tasks.patterns.models.TestBot;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private static final Logger LOG = LoggerFactory.getLogger(LoginPage.class);
    private static final By LOGIN_FIELD = byName("st.email");
    private static final By PASSWORD_FIELD = byName("st.password");
    private static final By SUBMIT_BUTTON = byValue("Log in to OK");

    public LoginPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(LOGIN_FIELD).shouldBe(
                exist.because("Не отобразилось поле логина.")
        );
        $(PASSWORD_FIELD).shouldBe(
                exist.because("Не отобразилось поле пароля.")
        );
        $(SUBMIT_BUTTON).shouldBe(
                exist.because("Не отобразилась кнопка входа.")
        );
        LOG.info("Перешли на страницу входа.");
        return true;
    }

    public LoginPage enterLogin(String login) {
        LOG.info("Вводим логин.");
        $(LOGIN_FIELD).shouldBe(
                visible.because("Не отобразилось поле логина.")
        ).setValue(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        LOG.info("Вводим пароль.");
        $(PASSWORD_FIELD).shouldBe(
                visible.because("Не отобразилось поле пароля.")
        ).setValue(password);
        return this;
    }

    public MyProfileMainPage clickSubmit() {
        LOG.info("Кликаем на кнопку входа.");
        $(SUBMIT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка входа.")
        ).click();
        return new MyProfileMainPage();
    }

    public MyProfileMainPage login(TestBot bot) {
        LOG.info("Выполняем вход в аккаунт.");
        return enterLogin(bot.getLogin())
                .enterPassword(bot.getPassword())
                .clickSubmit();
    }

    public String getLoginFieldText() {
        return $(LOGIN_FIELD).shouldBe(
                visible.because("Не отобразилось поле логина.")
        ).getValue();
    }

    public String getPasswordFieldText() {
        return $(PASSWORD_FIELD).shouldBe(
                visible.because("Не отобразилось поле пароля.")
        ).getValue();
    }
}
