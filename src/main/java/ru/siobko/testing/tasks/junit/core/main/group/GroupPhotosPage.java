package ru.siobko.testing.tasks.junit.core.main.group;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GroupPhotosPage extends BaseGroupPage {
    private static final Logger LOG = LoggerFactory.getLogger(GroupPhotosPage.class);
    private static final By GROUP_ALBUMS_QUERY = byXpath(".//input[@id='groupAlbumsQuery']");
    private static final By CREATE_ALBUM_BUTTON = byXpath(".//a[text()='Создать альбом']");

    public GroupPhotosPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(GROUP_ALBUMS_QUERY).shouldBe(
                visible.because("Не отобразился поисковик по альбомам группы.")
        );
        $(CREATE_ALBUM_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка для создания альбома группы.")
        );
        LOG.info("Перешли на страницу фотографий группы");
        return true;
    }
}
