package ru.siobko.testing.tasks.patterns.core.main.user.profile;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.user.elements.UserNavigationMenu;
import ru.siobko.testing.tasks.patterns.core.main.user.friends.UserFriendsPage;
import ru.siobko.testing.tasks.patterns.core.main.user.photos.UserPhotosPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class UserProfilePage {
    private static final Logger LOG = LoggerFactory.getLogger(UserProfilePage.class);
    protected final UserNavigationMenu horizontalNavigation = new UserNavigationMenu();
    protected static final By ABOUT_USER_BLOCK = byId("hook_Block_AboutUserRB");

    public UserProfilePage() {
        checkPage();
    }

    public boolean checkPage() {
        $(ABOUT_USER_BLOCK).shouldBe(
                visible.because("Не отобразилась панель 'О себе'"));
        LOG.info("Перешли на страницу профиля пользователя");
        return true;
    }

    public UserFriendsPage openProfileFriends() {
        LOG.info("Открываем друзей моего профиля.");
        horizontalNavigation.clickOnFriends();
        return new UserFriendsPage();
    }

    public UserPhotosPage openProfilePhotos() {
        LOG.info("Открываем фотки моего профиля.");
        horizontalNavigation.clickOnPhotos();
        return new UserPhotosPage();
    }
}
