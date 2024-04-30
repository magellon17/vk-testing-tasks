package ru.siobko.testing.tasks.junit.tests.main.profiles.myProfilePage;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.junit.core.main.profile.myProfile.MyProfilePage;
import ru.siobko.testing.tasks.junit.core.main.profile.myProfile.MyProfilePhotosPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("profiles")
@Tag("myProfile")
public class OpenMyProfilePhotosTest extends BaseMyProfilePageTest {
    @Test
    public void testOpenMyProfilePhotos() {
        MyProfilePhotosPage myProfilePhotosPage = new MyProfilePage()
                .openMyProfilePhotos();
        assertTrue(myProfilePhotosPage.checkPage(),
                "Страница с фотками моего профиля не открылась не открылась."
        );
    }
}
