package ru.siobko.testing.tasks.patterns.tests.main.myUserProfile;

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
    private static final Logger log = LoggerFactory.getLogger(OpenMyProfileFriendsTest.class);

    @Test
    public void testOpenProfileFriends() {
        log.info("Открываем страницу с друзьями моего профиля.");
        MyUserFriendsPage myUserFriendsPage = new MyUserProfilePage()
                .openMyProfileFriends();
        assertTrue(myUserFriendsPage.checkPage(),
                "Страница с официальными группами не открылась."
        );
    }
}
