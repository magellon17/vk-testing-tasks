package ru.siobko.testing.tasks.junit.core.media;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class PhotoPage {
    private static final Logger LOG = LoggerFactory.getLogger(PhotoPage.class);

    private static final By IMAGE_CONTAINER = byXpath(".//div[@data-l='t,main']");
    private static final By IMAGE = byTagName("img");
    private static final By MORE_ACTIONS_MENU = byXpath(".//button[@class='button-clean__0wfyv action-button-container__czsac']");
    private static final By DELETE_PHOTO_BUTTON = byXpath(".//span[text()='Удалить фотографию']");
    private static final By CLOSE_PHOTO_PAGE = byXpath(".//button[@class='panel_close__ugpyu close__ugpyu']");

    public PhotoPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(IMAGE_CONTAINER).shouldBe(
                visible.because("Не отобразилось область под фото.")
        );
        LOG.info("Перешли на страницу фото");
        return true;
    }

    public boolean checkImage() {
        return $(IMAGE).shouldBe(
                visible.because("Не появилось фото.")
        ).isImage();
    }

    public PhotoPage deletePhoto() {
        LOG.info("Удаляем фото.");
        $(MORE_ACTIONS_MENU).shouldBe(
                visible.because("Не отобразилось меню дополнитлеьных действий с фото (3 точки).")
        ).click();
        $(DELETE_PHOTO_BUTTON).shouldBe(
                visible.because("Не появилась для удаления фото.")
        ).click();
        return this;
    }

    public void closePhoto() {
        LOG.info("Закрываем станицу с фото.");
        $(CLOSE_PHOTO_PAGE).click();
    }
}
