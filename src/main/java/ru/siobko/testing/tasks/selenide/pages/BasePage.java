package ru.siobko.testing.tasks.selenide.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    protected final SelenideElement navigationToolBar = $(byXpath(".//div[@data-l='t,navigationToolbar']"));
    protected final SelenideElement queryField = $(byName("st.query"));
    protected final SelenideElement ecosystemButton = $(byXpath(".//div[@data-module='VkEcosystem']"));

    protected BasePage() {
        checkPage();
    }

    void checkPage() {
        navigationToolBar.shouldBe(visible);
        queryField.shouldBe(visible);
        ecosystemButton.shouldBe(visible);
    }

}
