package ru.siobko.testing.tasks.patterns.core.main.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class UserCardToolBar {
    private static final Logger LOG = LoggerFactory.getLogger(UserCardToolBar.class);

    private static final By DROPDOWN = byXpath(".//button[@aria-label='Настройки профиля']");
    private static final By LOGOUT_BUTTON = byXpath(".//a[@data-l='t,logout']");
    private static final By CONFIRM_LOGOUT_BUTTON = byXpath(".//input[@data-l='t,logout']");

    public UserCardToolBar() {
    }

    public UserCardToolBar expand() {
        LOG.info("Открываем карточку пользователя.");
        $(DROPDOWN).shouldBe(
                visible.because("Нет карточки пользователя на странице.")
        ).click();
        return this;
    }

    public UserCardToolBar clickOnLogout() {
        LOG.info("Кликаем на выход");
        $(LOGOUT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка выхода из аккаунта.")
        ).click();
        return this;
    }

    public void confirmLogout() {
        LOG.info("Подтвеждаем выход");
        $(CONFIRM_LOGOUT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка подтверждения выхода")
        ).click();
    }
}
