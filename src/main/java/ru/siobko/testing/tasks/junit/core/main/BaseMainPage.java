package ru.siobko.testing.tasks.junit.core.main;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.junit.core.BasePage;
import ru.siobko.testing.tasks.junit.core.main.groups.GroupsPage;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public abstract class BaseMainPage extends BasePage {
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseMainPage.class);
    protected static final By GROUPS_BUTTON = byXpath(".//a[@data-l='t,userAltGroup']");
    protected static final By MY_PROFILE_BUTTON = byXpath(".//a[@data-l='t,userPage']");
    protected static final By NAVIGATION_MENU = byXpath(".//div[@data-l='t,navigation']");
    protected static final By PAYMENTS_MENU = byXpath(".//ul[@data-l='t,secondTierLeftMenu']");
    protected static final By PUBLISH_BUTTON = byXpath(".//button[@data-testid='ddm-button']");
    protected static final By PUBLISH_POST_BUTTON = byXpath(".//*[@class='item-container__7e56q']");
    protected static final By PUBLISH_PHOTO_BUTTON = byXpath(".//input[@accept='image/*, video/*, .heic,']");
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
                visible.because("Не отобразилось бизнес меню.")
        );
        $(NAVIGATION_MENU).shouldBe(
                visible.because("Не отобразилось меню навигации.")
        );
        $(PUBLISH_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка публикации.")
        );
        return true;
    }

    public GroupsPage openGroupsPage() {
        LOGGER.info("Переходим на страницу с группами.");
        $(GROUPS_BUTTON).shouldBe(
                visible.because("Нет кнопки для перехода к группам.")
        ).click();
        return new GroupsPage();
    }

    public MyProfilePage openMyProfilePage() {
        LOGGER.info("Переходим на страницу профиля.");
        $(MY_PROFILE_BUTTON).shouldBe(
                visible.because("Нет кнопки для перехода в профиль.")
        ).click();
        return new MyProfilePage();
    }

    public BaseMainPage clickPublish() {
        LOGGER.info("Кликаем на кнопку 'Опубликовать'.");
        $(PUBLISH_BUTTON).shouldBe(
                visible.because("Нет кнопки 'Опубликовать'.")
        ).click();
        return this;
    }

    public BaseMainPage clickPublishPhoto(String file) {
        LOGGER.info("Публикуем фотку.");
        $(PUBLISH_PHOTO_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка публикации фотки.")
        ).uploadFile(new File(file));
        return this;
    }

    public BaseMainPage clickPublishPost() {
        LOGGER.info("Кликаем на кнопку публикации поста.");
        $(PUBLISH_POST_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка публикации поста.")
        ).click();
        return this;
    }

    public BaseMainPage enterPostText(String postText) {
        LOGGER.info("Вводим текст поста.");
        $(POST_TEXT_BOX).shouldBe(
                visible.because("Не отобразилось поле ввода текста поста.")
        ).setValue(postText);
        return this;
    }

    public BaseMainPage clickSubmit() {
        LOGGER.info("Публикуем пост.");
        $(SUBMIT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка подтвержденря публикации поста.")
        ).click();
        return this;
    }

    public BaseMainPage expandUserCardToolbar() {
        LOGGER.info("Открываем карточку пользователя.");
        $(USER_CARD_TOOLBAR_DROPDOWN).shouldBe(
                visible.because("Нет карточки пользователя на странице.")
        ).click();
        return this;
    }

    public BaseMainPage logout() {
        LOGGER.info("Выходим из аккаунта.");
        $(USER_CARD_TOOLBAR_LOGOUT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка выхода из аккаунта.")
        ).click();
        return this;
    }

    public void confirmLogout() {
        LOGGER.info("Подтвеждаем выход из аккаунта.");
        $(CONFIRM_LOGOUT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка подтверждения выхода из аккаунта.")
        ).click();
    }
}
