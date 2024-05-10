package ru.siobko.testing.tasks.patterns.core.main.group;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.group.elements.GroupNavigation;
import ru.siobko.testing.tasks.patterns.core.main.group.members.GroupMembersPage;
import ru.siobko.testing.tasks.patterns.core.main.group.photos.GroupPhotosPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GroupMainPage {
    private static final Logger LOG = LoggerFactory.getLogger(GroupMainPage.class);
    protected final GroupNavigation groupNavigation = new GroupNavigation();
    protected static final By GROUP_MEMBERS_BUTTON = byXpath(".//a[@data-l='outlandermenu,altGroupMembers']");
    protected static final By GROUP_PHOTOS_BUTTON = byXpath(".//a[@data-l='outlandermenu,altGroupAlbums']");

    protected GroupMainPage() {
        checkPage();
    }

    protected boolean checkPage() {
        $(GROUP_MEMBERS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка участников группы."));
        $(GROUP_PHOTOS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка фотографий группы."));
        return true;
    }

    public GroupMembersPage openGroupMembersPage() {
        LOG.info("Открываем страницу участников группы");
        groupNavigation.clickOnMembers();
        return new GroupMembersPage();
    }

    public GroupPhotosPage openGroupPhotosPage() {
        LOG.info("Открываем страницу фоток группы");
        groupNavigation.clickOnMembers();
        return new GroupPhotosPage();
    }
}
