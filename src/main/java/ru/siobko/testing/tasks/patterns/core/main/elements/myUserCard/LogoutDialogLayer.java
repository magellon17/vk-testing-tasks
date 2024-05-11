package ru.siobko.testing.tasks.patterns.core.main.elements.myUserCard;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.login.LoginPage;
import ru.siobko.testing.tasks.patterns.core.main.elements.UIComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LogoutDialogLayer implements UIComponent {
    private static final Logger log = LoggerFactory.getLogger(LogoutDialogLayer.class);
    private static final By CONFIRM_LOGOUT_BUTTON = byXpath(".//input[@data-l='t,logout']");

    public LogoutDialogLayer() {
        isLoaded();
    }

    @Override
    public boolean isLoaded() {
        $(CONFIRM_LOGOUT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка подтверждения выхода"));
        return true;
    }

    public LoginPage confirmLogout() {
        log.info("Подтвеждаем выход");
        $(CONFIRM_LOGOUT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка подтверждения выхода")
        ).click();
        return new LoginPage();
    }
}
