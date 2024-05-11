package ru.siobko.testing.tasks.patterns.core.main.user.photos;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MyUserPhotosPage extends UserPhotosPage {

    private static final Logger log = LoggerFactory.getLogger(MyUserPhotosPage.class);

    private static final By CREATE_ALBUM_BUTTON = byText("Создать альбом");

    public MyUserPhotosPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(CREATE_ALBUM_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка создания альбома"));
        log.info("Перешли на страницу фотографий моего профиля.");
        return true;
    }
}
