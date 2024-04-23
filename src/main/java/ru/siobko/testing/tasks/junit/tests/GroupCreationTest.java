package ru.siobko.testing.tasks.junit.tests;

import org.junit.jupiter.api.*;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;
import ru.siobko.testing.tasks.junit.core.main.GroupPage;
import ru.siobko.testing.tasks.junit.core.login.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("groups")
public class GroupCreationTest extends BaseTest {
    private static final String GROUP_NAME = "myGroup";

    @BeforeAll
    public static void login() {
        new LoginPage()
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickSubmit();
    }

    @Test
    public void testGroupCreation() {
        GroupPage groupPage = new FeedPage()
                .openGroupsPage()
                .clickCreateGroup()
                .clickGroupByInterest()
                .enterGroupName(GROUP_NAME)
                .expandThematicsList()
                .clickAutoThematic()
                .clickCreate();
        assertTrue(groupPage.checkGroupNameEquals(GROUP_NAME),
                "The group was created incorrectly."
        );
    }

    @AfterAll
    public static void deleteGroup() {
        new GroupPage()
                .clickMoreActions()
                .clickDelete()
                .confirmDeletion();
    }
}
