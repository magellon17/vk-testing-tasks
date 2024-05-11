package ru.siobko.testing.tasks.patterns.core.main.elements.myUserCard;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.elements.UIComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Раскрывающееся меню пользователя
 */
public class MyUserCardToolBar implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(MyUserCardToolBar.class);

    private static final SelenideElement toolbar = $(byId("user-dropdown-menu"));

    private static final By LOGOUT_BUTTON = byXpath(".//a[@data-l='t,logout']");

    public MyUserCardToolBar() {
        isLoaded();
    }

    @Override
    public boolean isLoaded() {
        toolbar.$(LOGOUT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка выхода из аккаунта"));
        log.info("Загрузилось меню карточки текущего пользователя");
        return false;
    }

    public LogoutDialogLayer clickOnLogout() {
        log.info("Кликаем на выход");
        toolbar.$(LOGOUT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка выхода из аккаунта")
        ).click();
        return new LogoutDialogLayer();
    }
}
