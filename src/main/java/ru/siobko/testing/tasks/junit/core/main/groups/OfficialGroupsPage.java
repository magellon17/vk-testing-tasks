package ru.siobko.testing.tasks.junit.core.main.groups;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class OfficialGroupsPage extends BaseGroupsPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(OfficialGroupsPage.class);
    private static final By PORTLET_TITLE = byClassName("portlet_h_title");

    public OfficialGroupsPage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        $(PORTLET_TITLE).shouldBe(
                visible.because("Не отобразился заголовок 'Официальные'.")
        );
        LOGGER.info("Перешли на страницу официальных групп.");
        return true;
    }
}
