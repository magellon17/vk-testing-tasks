package ru.siobko.testing.tasks.patterns.core.media.photo;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.elements.UIComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PhotoLayerMoreActionsMenu extends PhotoLayer implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(PhotoLayerMoreActionsMenu.class);

    private static final By DELETE_PHOTO_BUTTON = byXpath(".//span[text()='Удалить фотографию']");

    public PhotoLayerMoreActionsMenu(){
        isLoaded();
    }

    @Override
    public boolean isLoaded() {
        $(DELETE_PHOTO_BUTTON).shouldBe(
                visible.because("Не появилась кнопка для удаления фото."));
        return true;
    }

    public PhotoLayer deletePhoto() {
        log.info("Удаляем фото.");
        $(DELETE_PHOTO_BUTTON).shouldBe(
                visible.because("Не появилась кнопка для удаления фото.")
        ).click();
        return this;
    }
}
