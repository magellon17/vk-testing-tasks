package ru.siobko.testing.tasks.junit.core.main;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.junit.core.BasePage;
import ru.siobko.testing.tasks.junit.core.main.groups.GroupsPage;
import ru.siobko.testing.tasks.junit.core.main.profile.myProfile.MyProfilePage;
import ru.siobko.testing.tasks.junit.core.media.PhotoPage;
import ru.siobko.testing.tasks.junit.core.media.StatusPage;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;

public abstract class BaseMainPage extends BasePage {
    private static final Logger LOG = LoggerFactory.getLogger(BaseMainPage.class);

    // Боковая навигация
    protected static final By GROUPS_BUTTON = byXpath(".//a[@data-l='t,userAltGroup']");
    protected static final By MY_PROFILE_BUTTON = byXpath(".//a[@data-l='t,userPage']");
    protected static final By NAVIGATION_MENU = byXpath(".//div[@data-l='t,navigation']");
    protected static final By PAYMENTS_MENU = byXpath(".//ul[@data-l='t,secondTierLeftMenu']");

    // Публикация
    protected static final By PUBLISH_BUTTON = byXpath(".//button[@data-testid='ddm-button']");
    protected static final By PUBLISH_POST_BUTTON = byXpath(".//*[@class='item-container__7e56q']");
    protected static final By PUBLISH_PHOTO_BUTTON = byXpath(".//input[@accept='image/*, video/*, .heic,']");

    // Тулбар настройки профиля
    protected static final By USER_CARD_TOOLBAR_DROPDOWN = byXpath(".//button[@aria-label='Настройки профиля']");
    protected static final By USER_CARD_TOOLBAR_LOGOUT_BUTTON = byXpath(".//a[@data-l='t,logout']");
    protected static final By CONFIRM_LOGOUT_BUTTON = byXpath(".//input[@data-l='t,logout']");

    //Страница статуса
    protected static final By OPEN_PUBLISHED_STATUS_BUTTON = byXpath(".//a[@class='js-tip-block-url al']");

    //Страница фото
    protected static final By OPEN_PUBLISHED_PHOTO_BUTTON = byXpath(".//up-photo-midget[@data-l='t,view-photo']");

    //Страница фотографии
    protected static final By VIEW_PUBLISHED_PHOTO_BUTTON = byXpath(".//up-photo-midget[@data-l='t,view-photo']");
    protected static final By MORE_ACTIONS_PUBLISHED_PHOTO_BUTTON = byName("ico_more_vertical_16");
    protected static final By DELETE_PUBLISHED_PHOTO_BUTTON = byXpath(".//span[text()='Удалить фотографию']");
    protected static final By CLOSE_PUBLISHED_PHOTO_BUTTON = byXpath(".//button[@class='panel_close__ugpyu close__ugpyu']");

    //Создание статуса
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
        LOG.info("Переходим на страницу с группами.");
        $(GROUPS_BUTTON).shouldBe(
                visible.because("Нет кнопки для перехода к группам.")
        ).click();
        return new GroupsPage();
    }

    public MyProfilePage openMyProfilePage() {
        LOG.info("Переходим на страницу профиля.");
        $(MY_PROFILE_BUTTON).shouldBe(
                visible.because("Нет кнопки для перехода в профиль.")
        ).click();
        return new MyProfilePage();
    }

    public BaseMainPage clickPublish() {
        LOG.info("Кликаем на кнопку 'Опубликовать'.");
        $(PUBLISH_BUTTON).shouldBe(
                visible.because("Нет кнопки 'Опубликовать'.")
        ).click();
        return this;
    }

    public BaseMainPage clickPublishPhoto(String file) {
        LOG.info("Публикуем фотку.");
        $(PUBLISH_PHOTO_BUTTON).uploadFile(new File(file));
        return this;
    }

    public BaseMainPage clickPublishStatus() {
        LOG.info("Кликаем на кнопку публикации поста.");
        $(PUBLISH_POST_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка публикации поста.")
        ).click();
        return this;
    }

    public BaseMainPage enterPostText(String postText) {
        LOG.info("Вводим текст поста.");
        $(POST_TEXT_BOX).shouldBe(
                visible.because("Не отобразилось поле ввода текста поста.")
        ).setValue(postText);
        return this;
    }

    public BaseMainPage clickSubmit() {
        LOG.info("Публикуем пост.");
        $(SUBMIT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка подтвержденря публикации поста.")
        ).click();
        return this;
    }

    public BaseMainPage expandUserCardToolbar() {
        LOG.info("Открываем карточку пользователя.");
        $(USER_CARD_TOOLBAR_DROPDOWN).shouldBe(
                visible.because("Нет карточки пользователя на странице.")
        ).click();
        return this;
    }

    public BaseMainPage logout() {
        LOG.info("Выходим из аккаунта.");
        $(USER_CARD_TOOLBAR_LOGOUT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка выхода из аккаунта.")
        ).click();
        return this;
    }

    public void confirmLogout() {
        LOG.info("Подтвеждаем выход из аккаунта.");
        $(CONFIRM_LOGOUT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка подтверждения выхода из аккаунта.")
        ).click();
    }

    public StatusPage openStatus() {
        $(OPEN_PUBLISHED_STATUS_BUTTON).click();
        return new StatusPage();
    }

    public PhotoPage openPhoto() {
        $(OPEN_PUBLISHED_PHOTO_BUTTON).click();
        return new PhotoPage();
    }
}
