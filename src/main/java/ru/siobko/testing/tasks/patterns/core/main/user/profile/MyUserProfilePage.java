package ru.siobko.testing.tasks.patterns.core.main.user.profile;

import org.openqa.selenium.By;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.siobko.testing.tasks.patterns.core.main.user.friends.MyUserFriendsPage;
import ru.siobko.testing.tasks.patterns.core.main.user.friends.UserFriendsPage;
import ru.siobko.testing.tasks.patterns.core.main.user.photos.MyUserPhotosPage;
import ru.siobko.testing.tasks.patterns.core.main.user.photos.UserPhotosPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MyUserProfilePage extends UserProfilePage {

    private static final Logger log = LoggerFactory.getLogger(MyUserProfilePage.class);

    private static final By SETTINGS_BUTTON = byXpath(".//*[@data-l='outlandertarget,settings,t,settings']");

    public MyUserProfilePage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        $(SETTINGS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка настроек"));
        log.info("Перешли на страницу профиля текущего пользователя");
        return true;
    }

    @Override
    public UserFriendsPage openProfileFriends() {
        log.info("Открываем друзей моего профиля.");
        userNavigation.clickOnFriends();
        return new MyUserFriendsPage();
    }

    @Override
    public UserPhotosPage openProfilePhotos() {
        log.info("Открываем фотки моего профиля.");
        userNavigation.clickOnPhotos();
        return new MyUserPhotosPage();
    }
}
