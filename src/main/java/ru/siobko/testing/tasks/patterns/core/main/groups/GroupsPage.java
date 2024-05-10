package ru.siobko.testing.tasks.patterns.core.main.groups;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.group.MyGroupMainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class GroupsPage {
    private static final Logger LOG = LoggerFactory.getLogger(GroupsPage.class);

    protected static final By GROUP_SEARCH_FIELD = byXpath(".//group-search-input[@data-bundle-name='search_group-search-input']");
    protected static final By OFFICIAL_GROUPS_BUTTON = byXpath(".//a[@aria-label='Официальные']");

    private static final By CREATE_GROUP_BUTTON = byText("Создать группу");
    //Элементы для создания группы.
    private static final By GROUP_BY_INTEREST_BUTTON = byXpath(".//a[@data-l='t,INTEREST']");
    private static final By GROUP_NAME_FIELD = byId("field_name");
    private static final By THEMATICS_LIST = byXpath(".//div[@class='it js-multi-select_visual-input']");
    private static final By AUTO_THEMATIC_BUTTON = byText("Автомобили");
    private static final By CREATE_BUTTON = byXpath(".//input[@data-l='t,confirm']");


    public GroupsPage() {
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

    public GroupsPage clickCreateGroup() {
        LOG.info("Кликаем на кнопку создания группы.");
        $(CREATE_GROUP_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка создания группы.")
        ).click();
        return this;
    }

    public GroupsPage clickGroupByInterest() {
        LOG.info("Выбираем группу по интересам.");
        $(GROUP_BY_INTEREST_BUTTON).shouldBe(
                visible.because("Нет варианта создать группу по интересам.")
        ).click();
        return this;
    }

    public GroupsPage enterGroupName(String Name) {
        LOG.info("Выбираем название группы.");
        $(GROUP_NAME_FIELD).shouldBe(
                visible.because("Не отобразилось поле ввода названия группы.")
        ).setValue(Name);
        return this;
    }

    public GroupsPage expandThematicsList() {
        LOG.info("Раскрываем список групповых тематик.");
        $(THEMATICS_LIST).shouldBe(
                visible.because("Не отобразился список групповых тематик.")
        ).click();
        return this;
    }

    public GroupsPage clickAutoThematic() {
        LOG.info("Выбираем автомобильную тематику.");
        $(AUTO_THEMATIC_BUTTON).shouldBe(
                visible.because("Автомобильной тематики нет в списке.")
        ).click();
        return this;
    }

    public MyGroupMainPage clickCreate() {
        LOG.info("Подтверждаем создание группы.");
        $(CREATE_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка создания группы.")
        ).click();
        return new MyGroupMainPage();
    }
}
