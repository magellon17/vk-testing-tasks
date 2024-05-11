package ru.siobko.testing.tasks.patterns.tests.main.myUserProfile;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.user.MyUserProfilePage;
import ru.siobko.testing.tasks.patterns.core.main.user.photos.MyUserPhotosPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("profiles")
@Tag("myProfile")
public class OpenMyProfilePhotosTest extends BaseMyProfilePageTest {
    private static final Logger log = LoggerFactory.getLogger(OpenMyProfilePhotosTest.class);

    @Test
    public void testOpenMyProfilePhotos() {
        log.info("Открываем страницу с фотографиями моего профиля.");
        MyUserPhotosPage myUserPhotosPage = new MyUserProfilePage()
                .openMyProfilePhotos();
        assertTrue(myUserPhotosPage.checkPage(),
                "Страница с фотками моего профиля не открылась не открылась."
        );
    }
}
