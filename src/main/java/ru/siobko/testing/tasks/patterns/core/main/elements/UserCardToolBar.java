package ru.siobko.testing.tasks.patterns.core.main.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class UserCardToolBar {
    private static final Logger LOG = LoggerFactory.getLogger(UserCardToolBar.class);
    private static final By LOGOUT_BUTTON = byXpath(".//a[@data-l='t,logout']");

    public UserCardToolBar() {
    }

    public LogoutDialogLayer clickOnLogout() {
        LOG.info("Кликаем на выход");
        $(LOGOUT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка выхода из аккаунта.")
        ).click();
        return new LogoutDialogLayer();
    }


}
