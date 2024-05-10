package ru.siobko.testing.tasks.patterns.core.main.group;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.BaseMainPage;
import ru.siobko.testing.tasks.patterns.core.main.group.members.MyGroupMembersPage;
import ru.siobko.testing.tasks.patterns.core.main.group.photos.GroupPhotosPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public abstract class BaseGroupPage extends BaseMainPage {
    private static final Logger LOG = LoggerFactory.getLogger(BaseGroupPage.class);

    protected static final By GROUP_MEMBERS_BUTTON = byXpath(".//a[@data-l='outlandermenu,altGroupMembers']");
    protected static final By GROUP_PHOTOS_BUTTON = byXpath(".//a[@data-l='outlandermenu,altGroupAlbums']");
    protected static final By GROUP_FEED_BUTTON = byXpath(".//a[@data-l='outlandermenu,altGroupMain']");

    protected BaseGroupPage() {
        checkPage();
    }

    @Override
    protected boolean checkPage() {
        $(GROUP_MEMBERS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка участников группы.")
        );
        $(GROUP_PHOTOS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка фотографий группы.")
        );
        $(GROUP_FEED_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка ленты группы.")
        );
        return true;
    }

    public MyGroupMembersPage openGroupMembersPage() {
        LOG.info("Открываем страницу участников группы");
        $(GROUP_MEMBERS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка участников группы.")
        ).click();
        return new MyGroupMembersPage();
    }

    public GroupPhotosPage openGroupPhotosPage() {
        LOG.info("Открываем страницу фоток группы");
        $(GROUP_PHOTOS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка фотографий группы.")
        ).click();
        return new GroupPhotosPage();
    }
}
