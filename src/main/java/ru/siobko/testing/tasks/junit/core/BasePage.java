package ru.siobko.testing.tasks.junit.core;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    protected static final By TOOLBAR_OK_LOGO = byXpath(".//a[@data-l='t,logo']");
    protected static final By QUERY_FIELD = byName("st.query");
    protected static final By ECOSYSTEM_BUTTON = byXpath(".//div[@data-module='VkEcosystem']");

    protected BasePage() {
        checkPage();
    }

    protected boolean checkPage() {
        $(QUERY_FIELD).shouldBe(
                visible.because("Query Filed should be visible on all pages.")
        );
        $(ECOSYSTEM_BUTTON).shouldBe(
                visible.because("Ecosystem button should be visible on all pages.")
        );
        return true;
    }
}
