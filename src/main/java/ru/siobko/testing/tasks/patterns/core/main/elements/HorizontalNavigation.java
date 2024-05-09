package ru.siobko.testing.tasks.patterns.core.main.elements;


import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HorizontalNavigation {
    private static final Logger LOG = LoggerFactory.getLogger(HorizontalNavigation.class);

    private static final By FRIENDS_BUTTON = byXpath(".//a[@data-l='t,userFriend']");
    private static final By PHOTOS_BUTTON = byXpath(".//a[@data-l='t,userPhotos']");
    private static final By PROFILE_FEED = byXpath(".//div[@data-block='UserFeed']");

    public HorizontalNavigation() {
    }

    public void clickOnFriends() {
        LOG.info("Кликаем на друзей");
        $(FRIENDS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка друзей")
        ).click();
    }

    public void clickOnPhotos() {
        LOG.info("Кликаем на фото");
        $(PHOTOS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка фоток")
        ).click();
    }
}
