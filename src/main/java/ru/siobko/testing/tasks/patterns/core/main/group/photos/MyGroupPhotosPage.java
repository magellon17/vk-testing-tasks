package ru.siobko.testing.tasks.patterns.core.main.group.photos;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.group.GroupMainPage;
import ru.siobko.testing.tasks.patterns.core.main.group.MyGroupMainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MyGroupPhotosPage extends GroupPhotosPage {

    private static final Logger log = LoggerFactory.getLogger(MyGroupPhotosPage.class);

    private static final By CREATE_ALBUM_BUTTON = byText("Создать альбом");

    public MyGroupPhotosPage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        $(CREATE_ALBUM_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка для создания альбома группы"));
        log.info("Перешли на страницу фотографий собственной группы");
        return true;
    }

    @Override
    public GroupMainPage openGroupMainPage() {
        log.info("Открываем страницу фоток группы");
        groupNavigation.clickOnFeed();
        return new MyGroupMainPage();
    }
}
