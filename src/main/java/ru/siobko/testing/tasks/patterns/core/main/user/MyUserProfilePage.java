package ru.siobko.testing.tasks.patterns.core.main.user;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.siobko.testing.tasks.patterns.core.main.user.elements.UserNavigationMenu;
import ru.siobko.testing.tasks.patterns.core.main.user.friends.MyUserFriendsPage;
import ru.siobko.testing.tasks.patterns.core.main.user.photos.MyUserPhotosPage;

public class MyUserProfilePage {
    private static final Logger LOG = LoggerFactory.getLogger(MyUserProfilePage.class);
    private final UserNavigationMenu horizontalNavigation = new UserNavigationMenu();

    public MyUserProfilePage() {
        checkPage();
    }

    public boolean checkPage() {
        LOG.info("Перешли на страницу профиля");
        return true;
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
