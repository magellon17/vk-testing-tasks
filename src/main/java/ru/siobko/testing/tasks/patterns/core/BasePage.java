package ru.siobko.testing.tasks.patterns.core;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;

public abstract class BasePage {
    protected static final By QUERY_FIELD = byName("st.query");
    protected static final By ECOSYSTEM_BUTTON = byXpath(".//div[@data-module='VkEcosystem']");

    protected BasePage() {
        checkPage();
    }

    protected abstract boolean checkPage();
}
