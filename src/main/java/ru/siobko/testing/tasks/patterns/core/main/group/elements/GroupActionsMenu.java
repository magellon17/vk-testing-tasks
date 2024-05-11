package ru.siobko.testing.tasks.patterns.core.main.group.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GroupActionsMenu {
    private static final Logger LOG = LoggerFactory.getLogger(GroupActionsMenu.class);
    private static final By DELETE_BUTTON = byText("Удалить");

    public GroupActionsMenu(){
        check();
    }

    public boolean check(){
        $(DELETE_BUTTON).shouldBe(
                visible.because("Не появилась кнопка 'Удалить'.")
        );
        return true;
    }

    public RemoveGroupForm clickOnDelete() {
        LOG.info("Кликаем на кнопку 'Удалить' для удаления группы.");
        $(DELETE_BUTTON).shouldBe(
                visible.because("Не появилась кнопка 'Удалить'.")
        ).click();
        return new RemoveGroupForm();
    }
}
