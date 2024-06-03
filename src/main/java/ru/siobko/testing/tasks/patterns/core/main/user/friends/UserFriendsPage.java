package ru.siobko.testing.tasks.patterns.core.main.user.friends;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class UserFriendsPage {

    private static final Logger log = LoggerFactory.getLogger(UserFriendsPage.class);

    private static final By FRIENDS_MENU = byClassName("friends-menu");

    public UserFriendsPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(FRIENDS_MENU).shouldBe(
                visible.because("Не отобразилось меню друзей"));
        log.info("Перешли на страницу друзей профиля.");
        return true;
    }
}
