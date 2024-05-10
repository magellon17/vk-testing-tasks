package ru.siobko.testing.tasks.patterns.core.main.groups;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.group.MyGroupMainPage;
import ru.siobko.testing.tasks.patterns.core.main.groups.elements.ChooseGroupTypeDialog;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class GroupsMainPage {
    private static final Logger LOG = LoggerFactory.getLogger(GroupsMainPage.class);
    private static final By GROUP_SEARCH_FIELD = byXpath(".//group-search-input[@data-bundle-name='search_group-search-input']");
    private static final By OFFICIAL_GROUPS_BUTTON = byXpath(".//a[@aria-label='Официальные']");
    private static final By CREATE_GROUP_BUTTON = byText("Создать группу");


    public GroupsMainPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(GROUP_SEARCH_FIELD).shouldBe(
                visible.because("Не отобразился поисковик по группам.")
        );
        return true;
    }

    public OfficialGroupsPage openOfficialGroupsCatalog() {
        LOG.info("Открываем страницу с официальными группами.");
        $(OFFICIAL_GROUPS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка для перехода к официальным группам.")
        ).click();
        return new OfficialGroupsPage();
    }

    public ChooseGroupTypeDialog clickCreateGroup() {
        LOG.info("Кликаем на кнопку создания группы.");
        $(CREATE_GROUP_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка создания группы.")
        ).click();
        return new ChooseGroupTypeDialog();
    }
}
