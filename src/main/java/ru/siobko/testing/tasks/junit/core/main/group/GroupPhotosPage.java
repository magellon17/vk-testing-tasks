package ru.siobko.testing.tasks.junit.core.main.group;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GroupPhotosPage extends BaseGroupPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupPhotosPage.class);

    private static final By GROUP_PHOTO_FILTER_HEADER = byXpath(".//div[@id='hook_Block_GroupPhotoFilterHeader']");
    private static final By GROUP_ALBUMS_QUERY = byXpath(".//input[@id='groupAlbumsQuery']");
    private static final By GROUP_ALBUMS_BUTTON = byXpath(".//a[@aria-label='Альбомы']");

    public GroupPhotosPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(GROUP_PHOTO_FILTER_HEADER).shouldBe(
                visible.because("Query Filed should be visible on all pages.")
        );
        $(GROUP_ALBUMS_QUERY).shouldBe(
                visible.because("Ecosystem button should be visible on all pages.")
        );
        $(GROUP_ALBUMS_BUTTON).shouldBe(
                visible.because("Ecosystem button should be visible on all pages.")
        );
        LOGGER.info("Перешли на страницу фотографий группы");
        return true;
    }
}
