package ru.siobko.testing.tasks.patterns.core.main.user.photos;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class UserPhotosPage {
    private static final Logger log = LoggerFactory.getLogger(UserPhotosPage.class);
    private static final By ALBUMS_SEARCH = byText("Поиск по альбомам");

    public UserPhotosPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(ALBUMS_SEARCH).shouldBe(
                visible.because("Не отобразился поисковик по альбомам"));
        log.info("Перешли на страницу фотографий моего профиля.");
        return true;
    }
}
