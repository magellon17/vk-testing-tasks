package ru.siobko.testing.tasks.selenide.pages.main;

import org.openqa.selenium.By;
import ru.siobko.testing.tasks.selenide.pages.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public abstract class BaseMainPage extends BasePage {
    protected static final By groupsButton = byXpath(".//a[@data-l='t,userAltGroup']");
    protected static final By myProfileButton = byXpath(".//a[@data-l='t,userPage']");
    protected static final By navigationMenu = byXpath(".//div[@data-l='t,navigation']");
    protected static final By paymentsMenu = byXpath(".//ul[@data-l='t,secondTierLeftMenu']");
    protected static final By publishButton = byXpath(".//button[@data-testid='ddm-button']");
    protected static final By publishPostButton = byXpath(".//*[@class='item-container__7e56q']");
    private static final By userCardToolbarDropdown = byXpath(".//button[@aria-label='Настройки профиля']");
    private static final By userCardToolbarLogoutButton = byXpath(".//a[@data-l='t,logout']");
    private static final By confirmLogoutButton = byXpath(".//input[@data-l='t,logout']");

    //Поля окон, которые появляются в процессе создания текстового поста.
    protected static final By postTextBox = byXpath(".//div[@data-module='postingForm/mediaText']");
    protected static final By submitButton = byXpath(".//button[@data-l='t,button.submit']");

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
                visible.because("Button 'Опубликовать' should be visible on all main pages.")
        );
    }

    public void openGroupsPage() {
        $(groupsButton).shouldBe(
                visible.because("Button 'Группы' should be visible on all main pages.")
        ).click();
    }

    public BaseMainPage openUserCardToolbar() {
        $(userCardToolbarDropdown).shouldBe(
                visible.because("User card toolbar dropdown should be visible  on all main pages.")
        ).click();
        return this;
    }

    public BaseMainPage logout() {
        $(userCardToolbarLogoutButton).shouldBe(
                visible.because("Button 'Выйти' should be visible after open user card toolbar.")
        ).click();
        return this;
    }

    public void confirmLogout() {
        $(confirmLogoutButton).shouldBe(
                visible.because("Confirm Button 'Выйти' should be visible after clicking user card toolbar button 'Выйти''.")
        ).click();
    }
}
