package ru.siobko.testing.tasks.patterns.core.main.groups.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.groups.GroupsMainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GroupsNavigationMenu {
    private static final Logger log = LoggerFactory.getLogger(GroupsMainPage.class);
    private static final By OFFICIAL_GROUPS_BUTTON = byXpath(".//a[@aria-label='Официальные']");

    public void clickOnOfficialGroups() {
        log.info("Открываем страницу с официальными группами.");
        $(OFFICIAL_GROUPS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка для перехода к официальным группам.")
        ).click();
    }
}
