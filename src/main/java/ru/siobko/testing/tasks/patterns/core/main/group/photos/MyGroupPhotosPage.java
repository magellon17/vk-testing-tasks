package ru.siobko.testing.tasks.patterns.core.main.group.photos;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MyGroupPhotosPage extends GroupPhotosPage {
    private static final Logger LOG = LoggerFactory.getLogger(MyGroupPhotosPage.class);
    private static final By CREATE_ALBUM_BUTTON = byText("Создать альбом");

    public MyGroupPhotosPage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        $(CREATE_ALBUM_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка для создания альбома группы.")
        );
        LOG.info("Перешли на страницу фотографий группы.");
        return true;
    }
}
