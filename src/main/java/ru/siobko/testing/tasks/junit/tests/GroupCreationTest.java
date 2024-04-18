package ru.siobko.testing.tasks.junit.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;
import ru.siobko.testing.tasks.junit.core.main.GroupPage;
import ru.siobko.testing.tasks.junit.core.main.GroupsPage;
import ru.siobko.testing.tasks.junit.core.login.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupCreationTest extends BaseTest {
    private static final String GROUP_NAME = "myGroup";

    @BeforeAll
    public static void setUp() {
        FeedPage feedPage = new LoginPage().login(EMAIL, PASSWORD);
        feedPage.openGroupsPage();
    }

    @Test
    public void testGroupCreation() {
        GroupPage groupPage = new GroupsPage().createGroup(GROUP_NAME);

        assertTrue(
                groupPage.checkGroupNameEquals(GROUP_NAME),
                "The group was created incorrectly."
        );
    }

    @AfterAll
    public static void tearDown() {
        new GroupPage().deleteGroup();
    }
}
