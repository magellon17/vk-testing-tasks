package ru.siobko.testing.tasks.patterns.core.main.groups.elements.creatingGroup;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.elements.UIComponent;
import ru.siobko.testing.tasks.patterns.core.main.group.MyGroupMainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CreateGroupForm implements UIComponent {
    private static final Logger log = LoggerFactory.getLogger(CreateGroupForm.class);
    private static final By GROUP_NAME_FIELD = byName("st.layer.name");
    private static final By EXPAND_CATEGORIES_LIST = byXpath(".//*[@class='it js-multi-select_visual-input']");
    private static final By CREATE_BUTTON = byXpath(".//input[@data-l='t,confirm']");

    public CreateGroupForm() {
        isLoaded();
    }

    @Override
    public boolean isLoaded() {
        $(GROUP_NAME_FIELD).shouldBe(
                visible.because("Не отобразилось поле ввода названия группы"));
        $(CREATE_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка создания группы"));
        log.info("Загрузилась форма для создания группы");
        return true;
    }

    public CreateGroupForm enterGroupName(String name) {
        log.info("Выбираем название группы.");
        $(GROUP_NAME_FIELD).shouldBe(
                visible.because("Не отобразилось поле ввода названия группы")
        ).setValue(name);
        return this;
    }

    public CategoriesList expandCategoriesList() {
        log.info("Раскрываем список групповых тематик");
        $(EXPAND_CATEGORIES_LIST).shouldBe(
                visible.because("Не отобразился язычек для раскрытия списка тематик")
        ).click();
        return new CategoriesList();
    }

    public MyGroupMainPage clickCreate() {
        log.info("Подтверждаем создание группы.");
        $(CREATE_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка создания группы")
        ).click();
        return new MyGroupMainPage();
    }


}
