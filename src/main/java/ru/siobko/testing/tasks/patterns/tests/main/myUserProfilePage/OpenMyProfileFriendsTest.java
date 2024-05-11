package ru.siobko.testing.tasks.patterns.tests.main.myUserProfilePage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.user.friends.MyUserFriendsPage;
import ru.siobko.testing.tasks.patterns.core.main.user.MyUserProfilePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("myUserProfilePage")
public class OpenMyProfileFriendsTest extends OpenMyProfilePagesSteps {
    private final OpenMyProfilePagesSteps steps = new OpenMyProfilePagesSteps();

    @BeforeEach
    public void beforeTest() {
        steps.prepareTest();
    }

    @Test
    public void testOpenProfileFriends() {
        steps.openMyProfileFriendsPageAndCheckPage();
    }
}
