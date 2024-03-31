package ru.siobko.testing.tasks.selenide.pages.main;

import com.codeborne.selenide.SelenideElement;
import ru.siobko.testing.tasks.selenide.pages.BasePage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public abstract class BaseMainPage extends BasePage {
    protected final SelenideElement groupsButton = $(byXpath(".//a[@data-l='t,userAltGroup']"));
    protected final SelenideElement myProfileButton = $(byXpath(".//a[@data-l='t,userPage']"));
    protected final SelenideElement publishButton = $(byXpath(".//button[@data-testid='ddm-button']"));
    protected final SelenideElement navigationMenu = $(byXpath(".//div[@data-l='t,navigation']"));
    protected final SelenideElement paymentsMenu = $(byXpath(".//ul[@data-l='t,secondTierLeftMenu']"));

    protected BaseMainPage() {
        checkPage();
    }

    private void checkPage() {
        paymentsMenu.shouldBe(exist);
        navigationMenu.shouldBe(visible);
        publishButton.shouldBe(visible);
    }

    public String getMyProfileName() {
        return myProfileButton.getText();
    }

    public GroupsPage openGroupsPage() {
        groupsButton.click();
        return new GroupsPage();
    }
}
