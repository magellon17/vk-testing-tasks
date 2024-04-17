package ru.siobko.testing.tasks.junit.core.main;

import org.openqa.selenium.By;
import ru.siobko.testing.tasks.junit.core.BasePage;

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

    protected static final String PAYMENTS_MENU_LOG_INFO = "Payments menu should be exist on all main pages.";
    protected static final String NAVIGATION_MENU_LOG_INFO = "Navigation menu should be visible on all main pages.";
    protected static final String PUBLISH_BUTTON_LOG_INFO = "Button 'Опубликовать' should be visible on all main pages.";
    protected static final String GROUPS_BUTTON_LOG_INFO = "Button 'Группы' should be visible on all main pages.";
    protected static final String MY_PROFILE_BUTTON_LOG_INFO = "My profile button should be visible on all main pages.";
    protected static final String USER_CARD_TOOLBAR_DROPDOWN_LOG_INFO = "User card toolbar dropdown should be visible  on all main pages.";
    protected static final String USER_CARD_TOOLBAR_LOGOUT_BUTTON_LOG_INFO = "Button 'Выйти' should be visible after open user card toolbar.";
    protected static final String CONFIRM_LOGOUT_BUTTON_LOG_INFO = "Confirm Button 'Выйти' should be visible after clicking user card toolbar button 'Выйти''.";

    protected BaseMainPage() {
        checkPage();
    }

    private void checkPage() {
        $(paymentsMenu).shouldBe(
                visible.because(PAYMENTS_MENU_LOG_INFO)
        );
        $(navigationMenu).shouldBe(
                visible.because(NAVIGATION_MENU_LOG_INFO)
        );
        $(publishButton).shouldBe(
                visible.because(PUBLISH_BUTTON_LOG_INFO)
        );
    }

    public void openGroupsPage() {
        $(groupsButton).shouldBe(
                visible.because(GROUPS_BUTTON_LOG_INFO)
        ).click();
    }

    public BaseMainPage openUserCardToolbar() {
        $(userCardToolbarDropdown).shouldBe(
                visible.because(USER_CARD_TOOLBAR_DROPDOWN_LOG_INFO)
        ).click();
        return this;
    }

    public BaseMainPage logout() {
        $(userCardToolbarLogoutButton).shouldBe(
                visible.because(USER_CARD_TOOLBAR_LOGOUT_BUTTON_LOG_INFO)
        ).click();
        return this;
    }

    public void confirmLogout() {
        $(confirmLogoutButton).shouldBe(
                visible.because(CONFIRM_LOGOUT_BUTTON_LOG_INFO)
        ).click();
    }
}
