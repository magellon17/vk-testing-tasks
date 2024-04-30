package ru.siobko.testing.tasks.junit.core.main.profile.myProfile;

import org.openqa.selenium.By;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.siobko.testing.tasks.junit.core.main.BaseMainPage;
import ru.siobko.testing.tasks.junit.core.settings.SettingsGeneralPage;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MyProfilePage extends BaseMainPage {
    private static final Logger LOG = LoggerFactory.getLogger(MyProfilePage.class);

    private static final By SETTINGS_BUTTON = byXpath(".//li[@data-l='outlandertarget,settings,t,settings']");
    private static final By AVATAR = byId("viewImageLinkId");

    // Элементы для горизонатльной навигации
    private static final By FRIENDS_BUTTON = byXpath(".//a[@data-l='t,userFriend']");
    private static final By PHOTOS_BUTTON = byXpath(".//a[@data-l='t,userPhotos']");
    private static final By PROFILE_FEED = byXpath(".//div[@data-block='UserFeed']");

    // Элементы для удаления последнего поста
    private static final By LAST_FEED_POST_ACTIONS_MENU = byXpath(".//div[@data-l='t,feed-actions-menu']");
    private static final By DELETE_NOTE_BUTTON = byXpath(".//*[text()='Удалить заметку']");
    private static final By CONFIRM_DELETION_BUTTON = byXpath(".//a[text()='Удалить заметку']");

    // Элементы для добавления фото на аватар
    private static final By ADD_AVATAR_BUTTON = byXpath(".//div[text()='Добавить фото']");
    private static final By LOAD_PHOTO_BUTTON = byXpath(".//input[@accept='.jpg,.jpeg,.png,.gif,.heic,.mov,video/mp4,video/x-m4v,video/*']");
    private static final By CONFIRM_PHOTO_BUTTON = byXpath(".//span[text()='Установить']");

    public MyProfilePage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        $(PROFILE_FEED).shouldBe(
                visible.because("Не отобразилась кнопка 'Лента' для перехода на ленту профиля.")
        );
        $(SETTINGS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка 'Настройки' для перехода к настройкам профиля.")
        );
        LOG.info("Перешли на страницу профиля");
        return true;
    }

    public SettingsGeneralPage openProfileSettings() {
        LOG.info("Открываем настройки профиля.");
        $(SETTINGS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка настроек.")
        ).click();
        return new SettingsGeneralPage();
    }

    public MyProfileFriendsPage openMyProfileFriends() {
        LOG.info("Открываем друзей моего профиля.");
        $(FRIENDS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка друзей.")
        ).click();
        return new MyProfileFriendsPage();
    }

    public MyProfilePhotosPage openMyProfilePhotos() {
        LOG.info("Открываем фотки моего профиля.");
        $(PHOTOS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка фоток.")
        ).click();
        return new MyProfilePhotosPage();
    }

    public MyProfilePage hoverLastFeedPostActionsMenu() {
        LOG.info("Наводим курсор на меню действий текстового поста.");
        $(LAST_FEED_POST_ACTIONS_MENU).shouldBe(
                        visible.because("Не отобразилось меню действий текстового поста.")
                ).scrollIntoView("{block: \"center\"}")
                .hover();
        return this;
    }

    public MyProfilePage clickDeleteNote() {
        LOG.info("Удаляем заметку.");
        $(DELETE_NOTE_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка для удаления заметки.")
        ).click();
        return this;
    }

    public void confirmDeletion() {
        LOG.info("Подтверждаем удаление заметки.");
        $(CONFIRM_DELETION_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка подтверждения удаления.")
        ).click();
    }

    public MyProfilePage addAvatar() {
        LOG.info("Открываем панель загрузки аватарки.");
        $(ADD_AVATAR_BUTTON).shouldBe(
                visible.because("Нет кнопки 'Добавить фото'.")
        ).click();
        return this;
    }

    public MyProfilePage loadPhoto(String filename) {
        LOG.info("Загружаем фото.");
        $(LOAD_PHOTO_BUTTON).shouldBe(
                visible.because("Нет кнопки 'Добавить фото'.")
        ).uploadFile(new File(filename));
        ;
        return this;
    }

    public MyProfilePage confirmLoadPhoto() {
        LOG.info("Подтверждаем загрузку фото.");
        $(CONFIRM_PHOTO_BUTTON).shouldBe(
                visible.because("Нет кнопки 'Добавить фото'.")
        ).click();
        return this;
    }

    public boolean checkAvatarAdded() {
        return $(AVATAR).isDisplayed();
    }
}
