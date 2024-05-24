package ru.siobko.testing.tasks.junit.core.main.groups;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.junit.core.main.group.GroupFeedPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class GroupsPage extends BaseGroupsPage {
    private static final Logger LOG = LoggerFactory.getLogger(GroupsPage.class);

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

    @Override
    public boolean checkPage() {
        $(CREATE_GROUP_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка создания группы.")
        );
        LOG.info("Перешли на страницу актуальных групп.");
        return true;
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

    public GroupFeedPage clickCreate() {
        LOG.info("Подтверждаем создание группы.");
        $(CREATE_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка создания группы.")
        ).click();
        return new GroupFeedPage();
    }
}
