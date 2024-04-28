package ru.siobko.testing.tasks.junit.core.main.group;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GroupPhotosPage extends BaseGroupPage {
    private static final By GROUP_PHOTO_FILTER_HEADER = byXpath(".//div[@id='hook_Block_GroupPhotoFilterHeader']");
    private static final By GROUP_ALBUMS_QUERY = byXpath(".//input[@id='groupAlbumsQuery']");
    private static final By GROUP_ALBUMS_BUTTON = byXpath(".//a[@aria-label='Альбомы']");
    private static final By GROUP_PHOTOS_BUTTON = byXpath(".//a[@aria-label='Все фото']");

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
        return true;
    }
}
