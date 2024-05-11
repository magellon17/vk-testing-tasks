package ru.siobko.testing.tasks.patterns.core.main.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.user.elements.UserNavigationMenu;
import ru.siobko.testing.tasks.patterns.core.main.user.friends.UserFriendsPage;
import ru.siobko.testing.tasks.patterns.core.main.user.photos.UserPhotosPage;

public class UserMainPage {
    private static final Logger LOG = LoggerFactory.getLogger(UserMainPage.class);
    private final UserNavigationMenu horizontalNavigation = new UserNavigationMenu();

    public UserMainPage() {
        checkPage();
    }

    public boolean checkPage() {
        LOG.info("Перешли на страницу профиля");
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
