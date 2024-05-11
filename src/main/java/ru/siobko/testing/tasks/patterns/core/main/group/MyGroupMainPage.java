package ru.siobko.testing.tasks.patterns.core.main.group;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.group.members.GroupMembersPage;
import ru.siobko.testing.tasks.patterns.core.main.group.members.MyGroupMembersPage;
import ru.siobko.testing.tasks.patterns.core.main.group.photos.GroupPhotosPage;
import ru.siobko.testing.tasks.patterns.core.main.group.photos.MyGroupPhotosPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MyGroupMainPage extends GroupMainPage {

    private static final Logger log = LoggerFactory.getLogger(MyGroupMainPage.class);

    private static final By PROMOTE_BUTTON = byText("Продвинуть");

    public MyGroupMainPage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        $(PROMOTE_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка 'Продвинуть'."));
        log.info("Перешли на страницу ленты группы");
        return true;
    }

    @Override
    public GroupMembersPage openGroupMembersPage() {
        log.info("Открываем страницу участников группы");
        groupNavigation.clickOnMembers();
        return new MyGroupMembersPage();
    }

    @Override
    public GroupPhotosPage openGroupPhotosPage() {
        log.info("Открываем страницу фотографий группы");
        groupNavigation.clickOnPhotos();
        return new MyGroupPhotosPage();
    }

    public String getGroupName() {
        return $(GROUP_NAME).shouldBe(
                visible.because("Не отобразилось название группы.")
        ).getText();
    }

    public String getGroupTopic() {
        return $(GROUP_TOPIC).shouldBe(
                visible.because("Не отобразилась категория группы")
        ).getText();
    }
}
