package ru.siobko.testing.tasks.junit.core.main;

import org.openqa.selenium.By;
import ru.siobko.testing.tasks.junit.core.BasePage;
import ru.siobko.testing.tasks.junit.core.main.groups.GroupsPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public abstract class BaseMainPage extends BasePage {
    protected static final By GROUPS_BUTTON = byXpath(".//a[@data-l='t,userAltGroup']");
    protected static final By MY_PROFILE_BUTTON = byXpath(".//a[@data-l='t,userPage']");
    protected static final By NAVIGATION_MENU = byXpath(".//div[@data-l='t,navigation']");
    protected static final By PAYMENTS_MENU = byXpath(".//ul[@data-l='t,secondTierLeftMenu']");
    protected static final By PUBLISH_BUTTON = byXpath(".//button[@data-testid='ddm-button']");
    protected static final By PUBLISH_POST_BUTTON = byXpath(".//*[@class='item-container__7e56q']");
    protected static final By USER_CARD_TOOLBAR_DROPDOWN = byXpath(".//button[@aria-label='Настройки профиля']");
    protected static final By USER_CARD_TOOLBAR_LOGOUT_BUTTON = byXpath(".//a[@data-l='t,logout']");
    protected static final By CONFIRM_LOGOUT_BUTTON = byXpath(".//input[@data-l='t,logout']");
    protected static final By DELETE_BUTTON = byXpath(".//a[@class='u-menu_a ']");

    //Поля окон, которые появляются в процессе создания текстового поста.
    protected static final By POST_TEXT_BOX = byXpath(".//div[@data-module='postingForm/mediaText']");
    protected static final By SUBMIT_BUTTON = byXpath(".//button[@data-l='t,button.submit']");

    protected BaseMainPage() {
        checkPage();
    }

    @Override
    protected boolean checkPage() {
        $(PAYMENTS_MENU).shouldBe(
                visible.because("Payments menu should be exist on all main pages.")
        );
        $(NAVIGATION_MENU).shouldBe(
                visible.because("Navigation menu should be visible on all main pages.")
        );
        $(PUBLISH_BUTTON).shouldBe(
                visible.because("Button 'Опубликовать' should be visible on all main pages.")
        );
        return true;
    }

    public GroupsPage openGroupsPage() {
        $(GROUPS_BUTTON).shouldBe(
                visible.because("Button 'Группы' should be visible on all main pages.")
        ).click();
        return new GroupsPage();
    }

    public MyProfilePage openMyProfilePage() {
        $(MY_PROFILE_BUTTON).shouldBe(
                visible.because("My profile button should be visible on all main pages.")
        ).click();
        return new MyProfilePage();
    }

    public BaseMainPage clickPublish() {
        $(PUBLISH_BUTTON).shouldBe(
                visible.because("Button 'Опубликовать' should be visible on all main pages.")
        ).click();
        return this;
    }

    public BaseMainPage clickPublishPost() {
        $(PUBLISH_POST_BUTTON).shouldBe(
                visible.because("Button 'Запись' should be visible after clicking button 'Опубликоать'.")
        ).click();
        return this;
    }

    public BaseMainPage enterPostText(String postText) {
        $(POST_TEXT_BOX).shouldBe(
                visible.because("Post textbox should be visible while creating post.")
        ).setValue(postText);
        return this;
    }

    public BaseMainPage clickSubmit() {
        $(SUBMIT_BUTTON).shouldBe(
                visible.because("Button 'Поделиться' should be visible while creating post.")
        ).click();
        return this;
    }

    public BaseMainPage expandUserCardToolbar() {
        $(USER_CARD_TOOLBAR_DROPDOWN).shouldBe(
                visible.because("User card toolbar dropdown should be visible  on all main pages.")
        ).click();
        return this;
    }

    public BaseMainPage logout() {
        $(USER_CARD_TOOLBAR_LOGOUT_BUTTON).shouldBe(
                visible.because("Button 'Выйти' should be visible after open user card toolbar.")
        ).click();
        return this;
    }

    public void confirmLogout() {
        $(CONFIRM_LOGOUT_BUTTON).shouldBe(
                visible.because("Confirm Button 'Выйти' should be visible after clicking user card toolbar button 'Выйти''.")
        ).click();
    }
}
