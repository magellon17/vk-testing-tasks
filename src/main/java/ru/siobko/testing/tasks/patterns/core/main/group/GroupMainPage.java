package ru.siobko.testing.tasks.patterns.core.main.group;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.group.elements.GroupActionsMenu;
import ru.siobko.testing.tasks.patterns.core.main.group.elements.GroupNavigationMenu;
import ru.siobko.testing.tasks.patterns.core.main.group.members.GroupMembersPage;
import ru.siobko.testing.tasks.patterns.core.main.group.photos.GroupPhotosPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GroupMainPage {

    private static final Logger log = LoggerFactory.getLogger(GroupMainPage.class);

    protected final GroupNavigationMenu groupNavigation = new GroupNavigationMenu();

    protected static final By GROUP_NAME = byClassName("group-name_h");
    protected static final By GROUP_TOPIC = byClassName("group-name_info");
    protected static final By GROUP_MEMBERS_BUTTON = byXpath(".//a[@data-l='outlandermenu,altGroupMembers']");
    protected static final By GROUP_PHOTOS_BUTTON = byXpath(".//a[@data-l='outlandermenu,altGroupAlbums']");
    protected static final By DROPDOWN_ACTIONS_MENU = byXpath(".//li[@class='u-menu_li expand-action-item']");

    public GroupMainPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(GROUP_MEMBERS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка участников группы."));
        $(GROUP_PHOTOS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка фотографий группы."));
        return true;
    }

    public GroupMembersPage openGroupMembersPage() {
        log.info("Открываем страницу участников группы");
        groupNavigation.clickOnMembers();
        return new GroupMembersPage();
    }

    public GroupPhotosPage openGroupPhotosPage() {
        log.info("Открываем страницу фоток группы");
        groupNavigation.clickOnMembers();
        return new GroupPhotosPage();
    }

    public GroupActionsMenu dropdownActionsMenu() {
        log.info("Кликаем на кнопку дополнитльных действий с группой ('Еще').");
        $(DROPDOWN_ACTIONS_MENU).shouldBe(
                visible.because("Кнопка 'Ещё' должны быть видимой на странице ленты группы.")
        ).click();
        return new GroupActionsMenu();
    }
}
