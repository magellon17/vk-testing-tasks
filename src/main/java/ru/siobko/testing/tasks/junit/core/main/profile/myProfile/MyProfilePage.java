package ru.siobko.testing.tasks.junit.core.main.profile.myProfile;

import org.openqa.selenium.By;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.siobko.testing.tasks.junit.core.main.BaseMainPage;
import ru.siobko.testing.tasks.junit.core.settings.SettingsGeneralPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MyProfilePage extends BaseMainPage {
    private static final Logger LOG = LoggerFactory.getLogger(MyProfilePage.class);

    private static final By SETTINGS_BUTTON = byXpath(".//li[@data-l='outlandertarget,settings,t,settings']");

    // Элементы для горизонатльной навигации
    private static final By FRIENDS_BUTTON = byXpath(".//a[@data-l='t,userFriend']");
    private static final By PHOTOS_BUTTON = byXpath(".//a[@data-l='t,userPhotos']");
    private static final By PROFILE_FEED = byXpath(".//div[@data-block='UserFeed']");

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
}
