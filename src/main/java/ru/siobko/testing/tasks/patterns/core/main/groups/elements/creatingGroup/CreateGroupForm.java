package ru.siobko.testing.tasks.patterns.core.main.groups.elements.creatingGroup;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.group.MyGroupMainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CreateGroupForm {
    private static final Logger LOG = LoggerFactory.getLogger(CreateGroupForm.class);
    private static final By GROUP_NAME_QUERY = byName("st.layer.name");
    private static final By EXPAND_CATEGORIES_LIST = byXpath(".//*[@class='it js-multi-select_visual-input']");
    private static final By CREATE_BUTTON = byXpath(".//input[@data-l='t,confirm']");

    public CreateGroupForm() {
        check();
    }

    public boolean check(){
        $(GROUP_NAME_QUERY).shouldBe(
                visible.because(""));
        $(CREATE_BUTTON).shouldBe(
                visible.because(""));
        return true;
    }

    public CreateGroupForm enterGroupName(String name) {
        LOG.info("Выбираем название группы.");
        $(GROUP_NAME_QUERY).shouldBe(
                visible.because("Не отобразилось поле ввода названия группы.")
        ).setValue(name);
        return this;
    }

    public CategoriesList expandCategoriesList() {
        LOG.info("Раскрываем список групповых тематик.");
        $(EXPAND_CATEGORIES_LIST).shouldBe(
                visible.because("Не отобразился список групповых тематик.")
        ).click();
        return new CategoriesList();
    }

    public MyGroupMainPage clickCreate() {
        LOG.info("Подтверждаем создание группы.");
        $(CREATE_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка создания группы.")
        ).click();
        return new MyGroupMainPage();
    }
}
