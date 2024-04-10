package ru.siobko.testing.tasks.junit.core;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    protected static final By navigationToolBar = byXpath(".//div[@data-l='t,navigationToolbar']");
    protected static final By queryField = byName("st.query");
    protected static final By ecosystemButton = byXpath(".//div[@data-module='VkEcosystem']");

    private static final String NAVIGATION_TOOLBAR_LOG_INFO = "Navigation toolbar should be visible on all pages.";
    private static final String QUERY_FIELD_LOG_INFO = "Query Filed should be visible on all pages.";
    private static final String ECOSYSTEM_BUTTON_LOG_INFO = "Ecosystem button should be visible on all pages.";

    protected BasePage() {
        checkPage();
    }

    private void checkPage() {
        $(navigationToolBar).shouldBe(
                visible.because(NAVIGATION_TOOLBAR_LOG_INFO)
        );
        $(queryField).shouldBe(
                visible.because(QUERY_FIELD_LOG_INFO)
        );
        $(ecosystemButton).shouldBe(
                visible.because(ECOSYSTEM_BUTTON_LOG_INFO)
        );
    }
}
