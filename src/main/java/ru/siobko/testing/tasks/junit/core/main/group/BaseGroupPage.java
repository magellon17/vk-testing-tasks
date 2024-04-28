package ru.siobko.testing.tasks.junit.core.main.group;

import org.openqa.selenium.By;
import ru.siobko.testing.tasks.selenide.pages.main.BaseMainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BaseGroupPage extends BaseMainPage {
    protected static final By GROUP_MEMBERS_BUTTON = byXpath(".//a[@data-l='outlandermenu,altGroupMembers']");
    protected static final By GROUP_PHOTOS_BUTTON = byXpath(".//a[@data-l='outlandermenu,altGroupAlbums']");
    protected static final By GROUP_FEED_BUTTON = byXpath(".//a[@data-l='outlandermenu,altGroupMain']");
    protected static final By GROUP_PRODUCTS_BUTTON = byXpath(".//a[@data-l='outlandermenu,altGroupAdvertsPage']");
    protected static final By GROUP_MUSIC_BUTTON = byXpath(".//a[@data-l='outlandermenu,altGroupMusic']");

    public BaseGroupPage() {
        checkPage();
    }

    private void checkPage() {
        $(GROUP_MEMBERS_BUTTON).shouldBe(
                visible.because("Button 'Участники' should be visible on group page.")
        );
        $(GROUP_PHOTOS_BUTTON).shouldBe(
                visible.because("Navigation menu should be visible on all main pages.")
        );
        $(GROUP_FEED_BUTTON).shouldBe(
                visible.because("Button 'Опубликовать' should be visible on all main pages.")
        );
    }

    public GroupMembersPage openGroupMembersPage() {
        $(GROUP_MEMBERS_BUTTON).shouldBe(
                visible.because("Button 'Участники' should be visible on group page.")
        ).click();
        return new GroupMembersPage();
    }

    public GroupPhotosPage openGroupPhotosPage() {
        $(GROUP_PHOTOS_BUTTON).shouldBe(
                visible.because("Button 'Участники' should be visible on group page.")
        ).click();
        return new GroupPhotosPage();
    }
}
