package ru.siobko.testing.tasks.patterns.core.media.photo;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class PhotoLayer {

    private static final Logger log = LoggerFactory.getLogger(PhotoLayer.class);

    private static final By IMAGE_CONTAINER = byXpath(".//div[@data-l='t,main']");
    private static final By IMAGE = byTagName("img");
    private static final By CLOSE_PHOTO_PAGE = byXpath(".//button[@class='panel_close__ugpyu close__ugpyu']");
    private static final By EXPAND_MORE_ACTIONS_MENU = byXpath(".//button[@class='button-clean__0wfyv action-button-container__czsac']");

    public PhotoLayer() {
        checkPage();
    }

    public boolean checkPage() {
        $(IMAGE_CONTAINER).shouldBe(
                visible.because("Не отобразилось область под фото.")
        );
        log.info("Перешли на страницу фото");
        return true;
    }

    /**
     * Проверяет наличие изображения на леере
     */
    public boolean checkImage() {
        log.info("Делаем проверку на наличие изображения.");
        return $(IMAGE).shouldBe(
                visible.because("Не появилось фото.")
        ).isImage();
    }

    public PhotoLayerMoreActionsMenu expandActionsMenu() {
        log.info("Раскрываем меню дополнитльеных действий");
        $(EXPAND_MORE_ACTIONS_MENU).shouldBe(
                visible.because("Не отобразились 3 точки меню дополнитлельных действий.")
        ).click();
        return new PhotoLayerMoreActionsMenu();
    }

    /**
     * Закрывает фотолеер
     */
    public void closeLayer() {
        log.info("Закрываем станицу с фото.");
        $(CLOSE_PHOTO_PAGE).shouldBe(
                visible.because("Не отобразился крестик для закрытия страницы с фото.")
        ).click();
    }
}
