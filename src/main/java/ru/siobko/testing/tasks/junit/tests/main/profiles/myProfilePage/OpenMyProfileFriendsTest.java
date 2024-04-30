package ru.siobko.testing.tasks.junit.tests.main.profiles.myProfilePage;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.junit.core.main.profile.myProfile.MyProfileFriendsPage;
import ru.siobko.testing.tasks.junit.core.main.profile.myProfile.MyProfilePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("profiles")
@Tag("myProfile")
public class OpenMyProfileFriendsTest extends BaseMyProfilePageTest {
    @Test
    public void testOpenProfileFriends() {
        MyProfileFriendsPage myProfileFriendsPage = new MyProfilePage()
                .openMyProfileFriends();
        assertTrue(myProfileFriendsPage.checkPage(),
                "Страница с официальными группами не открылась."
        );
    }
}
