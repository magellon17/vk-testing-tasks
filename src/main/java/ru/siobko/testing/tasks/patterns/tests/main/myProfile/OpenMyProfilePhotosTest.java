package ru.siobko.testing.tasks.patterns.tests.main.myProfile;

import org.junit.jupiter.api.DisplayName;
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
    private static final Logger TESTLOG = LoggerFactory.getLogger(OpenMyProfilePhotosTest.class);

    @Test
    @DisplayName("Проверка открытия страницы фото моего профиля.")
    public void testOpenMyProfilePhotos() {
        TESTLOG.info("Открываем страницу с фотографиями моего профиля.");
        MyUserPhotosPage myUserPhotosPage = new MyUserProfilePage()
                .openMyProfilePhotos();
        assertTrue(myUserPhotosPage.checkPage(),
                "Страница с фотками моего профиля не открылась не открылась."
        );
    }
}
