package ru.siobko.testing.tasks.patterns.core.main.elements;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public abstract class HorizontalNavigation {
    private static final Logger LOG = LoggerFactory.getLogger(HorizontalNavigation.class);
    protected final SelenideElement item = $(byXpath(".//*[@data-l='t,horizontalNavigation']"));

    private static final By PROFILE_FEED = byText("Лента");
    protected static final By PHOTOS_BUTTON = byText("Фото");
    protected static final By VIDEO_BUTTON = byText("Видео");
    private static final By ADVERTS_BUTTON = byText("Товары");


    public void clickOnPhotos() {
        LOG.info("Кликаем на фото");
        item.$(PHOTOS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка фоток")
        ).click();
    }

    public void clickOnAdverts() {
        LOG.info("Кликаем на Товары");
        item.$(ADVERTS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка Товары")
        ).click();
    }

    public void clickOnVideo() {
        LOG.info("Кликаем на Видео");
        item.$(VIDEO_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка Видео")
        ).click();
    }


}
