package ru.siobko.testing.tasks.patterns.tests.main.myProfile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.user.friends.MyUserFriendsPage;
import ru.siobko.testing.tasks.patterns.core.main.user.MyUserProfilePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("profiles")
@Tag("myProfile")
public class OpenMyProfileFriendsTest extends BaseMyProfilePageTest {
    private static final Logger TESTLOG = LoggerFactory.getLogger(OpenMyProfileFriendsTest.class);

    @Test
    @DisplayName("Проверка открытия страницы друзей моего профиля.")
    public void testOpenProfileFriends() {
        TESTLOG.info("Открываем страницу с друзьями моего профиля.");
        MyUserFriendsPage myUserFriendsPage = new MyUserProfilePage()
                .openMyProfileFriends();
        assertTrue(myUserFriendsPage.checkPage(),
                "Страница с официальными группами не открылась."
        );
    }
}
