package ru.siobko.testing.tasks.patterns.core.main.group;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.group.members.GroupMembersPage;
import ru.siobko.testing.tasks.patterns.core.main.group.members.MyGroupMembersPage;
import ru.siobko.testing.tasks.patterns.core.main.group.photos.GroupPhotosPage;
import ru.siobko.testing.tasks.patterns.core.main.group.photos.MyGroupPhotosPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MyGroupMainPage extends GroupMainPage {
    private static final Logger LOG = LoggerFactory.getLogger(MyGroupMainPage.class);

    private static final By ABOUT_GROUP_PANEL = byXpath(".//div[@data-module='GroupInfoPanel']");
    private static final By GROUP_NAME = byClassName("group-name_h");
    private static final By GROUP_FEED = byXpath(".//div[@data-l='fL,group']");
    private static final By MORE_ACTIONS_BUTTON = byXpath(".//li[@class='u-menu_li expand-action-item']");

    //Удаление группы
    private static final By DELETE_BUTTON = byText("Удалить");
    private static final By CONFIRM_DELETION_BUTTON = byXpath(".//*[@data-l='t,confirm']");

    public MyGroupMainPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(ABOUT_GROUP_PANEL).shouldBe(
                visible.because("Не отобразилась панель 'О группе'."));
        $(GROUP_FEED).shouldBe(
                visible.because("Не отобразилась лента группы."));
        LOG.info("Перешли на страницу ленты группы");
        return true;
    }

    @Override
    public GroupMembersPage openGroupMembersPage() {
        LOG.info("Открываем страницу участников группы");
        groupNavigation.clickOnMembers();
        return new MyGroupMembersPage();
    }

    @Override
    public GroupPhotosPage openGroupPhotosPage() {
        LOG.info("Открываем страницу фоток группы");
        groupNavigation.clickOnMembers();
        return new MyGroupPhotosPage();
    }

    public MyGroupMainPage clickMoreActions() {
        LOG.info("Кликаем на кнопку дополнитльных действий с группой ('Еще').");
        $(MORE_ACTIONS_BUTTON).shouldBe(
                visible.because("Кнопка 'Ещё' должны быть видимой на странице ленты группы.")
        ).click();
        return this;
    }

    public MyGroupMainPage clickDelete() {
        LOG.info("Кликаем на кнопку 'Удалить' для удаления группы.");
        $(DELETE_BUTTON).shouldBe(
                visible.because("Не появилась кнопка 'Удалить'.")
        ).click();
        return this;
    }

    public void confirmDeletion() {
        LOG.info("Подтверждаем удаление группы.");
        $(CONFIRM_DELETION_BUTTON).shouldBe(
                visible.because("Не появилась кнопка пожтверждения удаления.")
        ).click();
    }

    public String getGroupName() {
        return $(GROUP_NAME).shouldBe(
                visible.because("Не отобразилось название группы.")
        ).getText();
    }
}
