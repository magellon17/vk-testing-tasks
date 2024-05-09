package ru.siobko.testing.tasks.patterns.core.main.groups.myGroup;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GroupFeedPage extends BaseGroupPage {
    private static final Logger LOG = LoggerFactory.getLogger(GroupFeedPage.class);

    private static final By ABOUT_GROUP_PANEL = byXpath(".//div[@data-module='GroupInfoPanel']");
    private static final By GROUP_NAME = byClassName("group-name_h");
    private static final By GROUP_FEED = byXpath(".//div[@data-l='fL,group']");
    private static final By MORE_ACTIONS_BUTTON = byXpath(".//li[@class='u-menu_li expand-action-item']");

    //Удаление группы
    private static final By DELETE_BUTTON = byText("Удалить");
    private static final By CONFIRM_DELETION_BUTTON = byXpath(".//*[@data-l='t,confirm']");

    public GroupFeedPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(ABOUT_GROUP_PANEL).shouldBe(
                visible.because("Не отобразилась панель 'О группе'.")
        );
        $(GROUP_FEED).shouldBe(
                visible.because("Не отобразилась лента группы.")
        );
        LOG.info("Перешли на страницу ленты группы");
        return true;
    }

    public GroupFeedPage clickMoreActions() {
        LOG.info("Кликаем на кнопку дополнитльных действий с группой ('Еще').");
        $(MORE_ACTIONS_BUTTON).shouldBe(
                visible.because("Кнопка 'Ещё' должны быть видимой на странице ленты группы.")
        ).click();
        return this;
    }

    public GroupFeedPage clickDelete() {
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
