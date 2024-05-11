package ru.siobko.testing.tasks.patterns.core.main.user.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class UserNavigationMenu {

    private static final Logger log = LoggerFactory.getLogger(UserNavigationMenu.class);

    protected final SelenideElement navi = $(byXpath(".//*[@data-l='t,horizontalNavigation']"));

    protected static final By FRIENDS_BUTTON = byText("Друзья");
    protected static final By PHOTOS_BUTTON = byText("Фото");

    public void clickOnFriends() {
        log.info("Кликаем на друзей");
        navi.$(FRIENDS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка друзей")
        ).click();
    }

    public void clickOnPhotos() {
        log.info("Кликаем на фото");
        navi.$(PHOTOS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка фоток")
        ).click();
    }
}
