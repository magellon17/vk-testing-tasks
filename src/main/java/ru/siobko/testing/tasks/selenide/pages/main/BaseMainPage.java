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
    private static final By deleteButton = byXpath(".//a[@class='u-menu_a ']");

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

    public GroupsPage openGroupsPage() {
        $(groupsButton).shouldBe(
                visible.because("Button 'Группы' should be visible on all main pages.")
        ).click();
        return new GroupsPage();
    }

    public MyProfilePage openMyProfilePage() {
        $(myProfileButton).shouldBe(
                visible.because("My profile button should be visible on all main pages.")
        ).click();
        return new MyProfilePage();
    }

    public BaseMainPage clickPublish() {
        $(publishButton).shouldBe(
                visible.because("Button 'Опубликовать' should be visible on all main pages.")
        ).click();
        return this;
    }

    public BaseMainPage clickPublishPost() {
        $(publishPostButton).shouldBe(
                visible.because("Button 'Запись' should be visible after clicking button 'Опубликоать'.")
        ).click();
        return this;
    }

    public BaseMainPage enterPostText(String postText) {
        $(postTextBox).shouldBe(
                visible.because("Post textbox should be visible while creating post.")
        ).setValue(postText);
        return this;
    }

    public BaseMainPage clickSubmit() {
        $(submitButton).shouldBe(
                visible.because("Button 'Поделиться' should be visible while creating post.")
        ).click();
        return this;
    }

    public BaseMainPage clickDeleteNote() {
        $(deleteButton).shouldBe(
                visible.because("Button 'Удалить' should be visible on post actions menu.")
        ).click();
        return this;
    }
}
