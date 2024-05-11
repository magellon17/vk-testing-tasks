package ru.siobko.testing.tasks.patterns.tests.main.myUserProfilePage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.user.MyUserMainPage;
import ru.siobko.testing.tasks.patterns.core.main.user.profile.MyUserProfilePage;
import ru.siobko.testing.tasks.patterns.core.main.user.friends.UserFriendsPage;
import ru.siobko.testing.tasks.patterns.core.main.user.photos.UserPhotosPage;
import ru.siobko.testing.tasks.patterns.tests.main.BaseMainTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenMyProfilePagesSteps extends BaseMainTest {

    private static final Logger log = LoggerFactory.getLogger(OpenMyProfilePagesSteps.class);

    public void prepareTest() {
        log.info("Открываем страницу профиля текущего пользователя");
        new MyUserMainPage().openProfilePage();
    }

    public void openMyProfileFriendsPageAndCheckPage() {
        log.info("Открываем страницу с друзьями");
        UserFriendsPage myUserFriendsPage = new MyUserProfilePage()
                .openProfileFriends();
        assertTrue(myUserFriendsPage.checkPage(),
                "Страница с официальными группами не открылась."
        );
    }

    public void openMyProfilePhotosPageAndCheckPage() {
        log.info("Открываем страницу с фотографиями");
        UserPhotosPage myUserPhotosPage = new MyUserProfilePage()
                .openProfilePhotos();
        assertTrue(myUserPhotosPage.checkPage(),
                "Страница с фотками моего профиля не открылась не открылась."
        );
    }
}
