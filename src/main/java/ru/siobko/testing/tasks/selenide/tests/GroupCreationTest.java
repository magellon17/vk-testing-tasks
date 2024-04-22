package ru.siobko.testing.tasks.selenide.tests;

import org.junit.jupiter.api.*;
import ru.siobko.testing.tasks.selenide.pages.main.FeedPage;
import ru.siobko.testing.tasks.selenide.pages.main.GroupPage;
import ru.siobko.testing.tasks.selenide.pages.main.GroupsPage;
import ru.siobko.testing.tasks.selenide.pages.login.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupCreationTest extends BaseTest {
    private static final String GROUP_NAME = "myGroup";

    @BeforeAll
    public static void login() {
        FeedPage feedPage = new LoginPage()
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickSubmit();
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
    public static void deleteGroup() {
        new GroupPage().deleteGroup();
    }
}
