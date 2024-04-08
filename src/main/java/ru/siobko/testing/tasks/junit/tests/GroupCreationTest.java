package ru.siobko.testing.tasks.junit.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.selenide.pages.main.FeedPage;
import ru.siobko.testing.tasks.selenide.pages.main.GroupPage;
import ru.siobko.testing.tasks.selenide.pages.main.GroupsPage;
import ru.siobko.testing.tasks.selenide.pages.main.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupCreationTest extends BaseTest {
    @BeforeAll
    public static void setUp() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(EMAIL, PASSWORD);

        FeedPage feedPage = new FeedPage();
        feedPage.openGroupsPage();
    }

    @Test
    public void testGroupCreation() {
        GroupsPage groupsPage = new GroupsPage();
        GroupPage groupPage = groupsPage.createGroup("myGroup");

        assertEquals(
                groupPage.getGroupName(),
                "myGroup",
                "The group was created incorrectly."
        );
    }

    @AfterAll
    public static void tearDown() {
        GroupPage groupPage = new GroupPage();
        groupPage.deleteGroup();
    }
}
