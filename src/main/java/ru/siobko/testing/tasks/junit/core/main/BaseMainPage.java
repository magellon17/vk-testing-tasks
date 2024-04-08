package ru.siobko.testing.tasks.junit.core.main;

import org.openqa.selenium.By;
import ru.siobko.testing.tasks.junit.core.BasePage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public abstract class BaseMainPage extends BasePage {
    protected final By groupsButton = byXpath(".//a[@data-l='t,userAltGroup']");
    protected final By myProfileButton = byXpath(".//a[@data-l='t,userPage']");
    protected final By publishButton = byXpath(".//button[@data-testid='ddm-button']");
    protected final By navigationMenu = byXpath(".//div[@data-l='t,navigation']");
    protected final By paymentsMenu = byXpath(".//ul[@data-l='t,secondTierLeftMenu']");

    protected BaseMainPage() {
        checkPage();
    }

    private void checkPage() {
        $(paymentsMenu).shouldBe(exist);
        $(navigationMenu).shouldBe(visible);
        $(publishButton).shouldBe(visible);
    }

    public void openGroupsPage() {
        $(groupsButton).click();
    }
}
