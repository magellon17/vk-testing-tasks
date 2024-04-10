package ru.siobko.testing.tasks.junit.core.main;

import org.openqa.selenium.By;
import ru.siobko.testing.tasks.junit.core.BasePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public abstract class BaseMainPage extends BasePage {
    protected static final By groupsButton = byXpath(".//a[@data-l='t,userAltGroup']");
    protected static final By myProfileButton = byXpath(".//a[@data-l='t,userPage']");
    protected static final By publishButton = byXpath(".//button[@data-testid='ddm-button']");
    protected static final By navigationMenu = byXpath(".//div[@data-l='t,navigation']");
    protected static final By paymentsMenu = byXpath(".//ul[@data-l='t,secondTierLeftMenu']");

    protected BaseMainPage() {
        checkPage();
    }

    private void checkPage() {
        $(paymentsMenu).shouldBe(
                visible.because("Payments menu should be exist on all main pages.")
        );
        $(navigationMenu).shouldBe(
                visible.because("Navigation menu should be visible on all main pages.")
        );
        $(publishButton).shouldBe(
                visible.because("Publish button should be visible on all main pages.")
        );
    }

    public void openGroupsPage() {
        $(groupsButton).click();
    }
}
