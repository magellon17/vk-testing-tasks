package ru.siobko.testing.tasks.junit.core.main.groups;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class OfficialGroupsPage extends BaseGroupsPage {
    private static final By PORTLET_TITLE = byClassName("portlet_h_title");

    public OfficialGroupsPage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        $(PORTLET_TITLE).shouldBe(
                visible.because("Group search field should be visible on page 'Группы'.")
        );
        return true;
    }
}
