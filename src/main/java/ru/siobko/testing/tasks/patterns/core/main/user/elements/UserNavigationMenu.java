package ru.siobko.testing.tasks.patterns.core.main.user.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.elements.GroupsAndProfilesNavigationMenu;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;

public class UserNavigationMenu extends GroupsAndProfilesNavigationMenu {
    private static final Logger LOG = LoggerFactory.getLogger(UserNavigationMenu.class);
    protected static final By FRIENDS_BUTTON = byText("Друзья");

    public void clickOnFriends() {
        LOG.info("Кликаем на друзей");
        navi.$(FRIENDS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка друзей")
        ).click();
    }
}
