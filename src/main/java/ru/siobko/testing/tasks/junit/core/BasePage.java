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

    protected BasePage() {
        checkPage();
    }

    private void checkPage() {
        $(navigationToolBar).shouldBe(visible);
        $(queryField).shouldBe(visible);
        $(ecosystemButton).shouldBe(visible);
    }

}