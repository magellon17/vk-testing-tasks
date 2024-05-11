package ru.siobko.testing.tasks.patterns.core.main.group.photos;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.group.GroupMainPage;
import ru.siobko.testing.tasks.patterns.core.main.group.elements.GroupNavigationMenu;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GroupPhotosPage {

    private static final Logger log = LoggerFactory.getLogger(GroupPhotosPage.class);

    protected final GroupNavigationMenu groupNavigation = new GroupNavigationMenu();

    protected static final By GROUP_PHOTO_FILTER_BLOCK = byXpath(".//*[@id='hook_Block_GroupAlbumsPagingHeader']");

    public GroupPhotosPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(GROUP_PHOTO_FILTER_BLOCK).shouldBe(
                visible.because("Не отобразилась панель с филтрами фотографий группы"));
        log.info("Перешли на страницу фотографий группы");
        return true;
    }

    public GroupMainPage openGroupMainPage() {
        log.info("Открываем страницу фоток группы");
        groupNavigation.clickOnFeed();
        return new GroupMainPage();
    }
}
