package ru.siobko.testing.tasks.patterns.tests.main.myUserProfilePage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.user.MyUserMainPage;
import ru.siobko.testing.tasks.patterns.core.main.user.MyUserProfilePage;
import ru.siobko.testing.tasks.patterns.core.main.user.friends.MyUserFriendsPage;
import ru.siobko.testing.tasks.patterns.core.main.user.photos.MyUserPhotosPage;
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
        MyUserFriendsPage myUserFriendsPage = new MyUserProfilePage()
                .openMyProfileFriends();
        assertTrue(myUserFriendsPage.checkPage(),
                "Страница с официальными группами не открылась."
        );
    }

    public void openMyProfilePhotosPageAndCheckPage() {
        log.info("Открываем страницу с фотографиями");
        MyUserPhotosPage myUserPhotosPage = new MyUserProfilePage()
                .openMyProfilePhotos();
        assertTrue(myUserPhotosPage.checkPage(),
                "Страница с фотками моего профиля не открылась не открылась."
        );
    }
}
