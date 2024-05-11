package ru.siobko.testing.tasks.patterns.core.main.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.login.LoginPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LogoutDialogLayer {
    private static final Logger LOG = LoggerFactory.getLogger(SideNavigationBlock.class);
    private static final By CONFIRM_LOGOUT_BUTTON = byXpath(".//input[@data-l='t,logout']");

    public LogoutDialogLayer() {
        check();
    }

    public boolean check() {
        $(CONFIRM_LOGOUT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка подтверждения выхода"));
        return true;
    }

    public LoginPage confirmLogout() {
        LOG.info("Подтвеждаем выход");
        $(CONFIRM_LOGOUT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка подтверждения выхода")
        ).click();
        return new LoginPage();
    }
}
