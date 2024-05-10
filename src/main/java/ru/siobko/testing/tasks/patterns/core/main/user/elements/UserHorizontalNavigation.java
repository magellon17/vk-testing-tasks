package ru.siobko.testing.tasks.patterns.core.main.user.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.elements.HorizontalNavigation;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;

public class UserHorizontalNavigation extends HorizontalNavigation {
    private static final Logger LOG = LoggerFactory.getLogger(HorizontalNavigation.class);

    protected static final By STATUSES_BUTTON = byText("Заметки");
    protected static final By FRIENDS_BUTTON = byText("Друзья");
    protected static final By GAMES_BUTTON = byText("Игры");
    protected static final By GROUPS_BUTTON = byText("Группы");
    protected static final By GIFTS_BUTTON = byText("Подарки");

    public void clickOnFriends() {
        LOG.info("Кликаем на друзей");
        item.$(FRIENDS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка друзей")
        ).click();
    }

    public void clickOnGroups() {
        LOG.info("Кликаем на Группы");
        item.$(GROUPS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка Группы")
        ).click();
    }

    public void clickOnGames() {
        LOG.info("Кликаем на Игры");
        item.$(GAMES_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка Игры")
        ).click();
    }

    public void clickOnStatuses() {
        LOG.info("Кликаем на Заметки");
        item.$(STATUSES_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка Заметки")
        ).click();
    }

    public void clickOnGifts() {
        LOG.info("Кликаем на Подарки");
        item.$(GIFTS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка Подарки")
        ).click();
    }

}
