package ru.siobko.testing.tasks.patterns.core.main.group.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.elements.HorizontalNavigation;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;

public class GroupNavigation extends HorizontalNavigation {
    private static final Logger LOG = LoggerFactory.getLogger(GroupNavigation.class);
    protected static final By MEMBERS_BUTTON = byText("Участники");

    public GroupNavigation() {
        check();
    }

    public boolean check() {
        return true;
    }

    public void clickOnMembers() {
        LOG.info("Кликаем на участников");
        navi.$(MEMBERS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка участников")
        ).click();
    }
}
