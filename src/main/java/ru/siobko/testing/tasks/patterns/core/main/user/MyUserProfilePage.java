package ru.siobko.testing.tasks.patterns.core.main.user;

import org.openqa.selenium.By;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.siobko.testing.tasks.patterns.core.main.user.elements.UserNavigation;
import ru.siobko.testing.tasks.patterns.core.main.user.friends.MyUserFriendsPage;
import ru.siobko.testing.tasks.patterns.core.main.user.photos.MyUserPhotosPage;
import ru.siobko.testing.tasks.patterns.core.settings.SettingsGeneralPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MyUserProfilePage {
    private static final Logger LOG = LoggerFactory.getLogger(MyUserProfilePage.class);
    private final UserNavigation horizontalNavigation = new UserNavigation();
    private static final By SETTINGS_BUTTON = byXpath(".//li[@data-l='outlandertarget,settings,t,settings']");

    public MyUserProfilePage() {
        checkPage();
    }

    public boolean checkPage() {
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

    public MyUserFriendsPage openMyProfileFriends() {
        LOG.info("Открываем друзей моего профиля.");
        horizontalNavigation.clickOnFriends();
        return new MyUserFriendsPage();
    }

    public MyUserPhotosPage openMyProfilePhotos() {
        LOG.info("Открываем фотки моего профиля.");
        horizontalNavigation.clickOnPhotos();
        return new MyUserPhotosPage();
    }
}
