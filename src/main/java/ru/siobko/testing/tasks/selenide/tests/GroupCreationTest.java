package ru.siobko.testing.tasks.selenide.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.selenide.pages.FeedPage;
import ru.siobko.testing.tasks.selenide.pages.GroupPage;
import ru.siobko.testing.tasks.selenide.pages.GroupsPage;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupCreationTest extends BaseTest {
    @Test
    public void testGroupCreation() {
        GroupPage groupPage = createGroup("myGroup");

        assertEquals(
                groupPage.getGroupName().getText(),
                "myGroup",
                "The group was created incorrectly."
        );
    }

    private GroupPage createGroup(String groupName) {
        FeedPage feedPage = new FeedPage();
        GroupsPage groupsPage = feedPage.openGroupsPage();
        return groupsPage.createGroup(groupName);
    }

    private static void deleteGroup() {
        GroupPage groupPage = new GroupPage();
        groupPage.getMoreActionsButton().click();
        groupPage.getDeleteButton().click();
        groupPage.getConfirmDeletionButton().click();
    }

    @AfterAll
    public static void tearDown() {
        deleteGroup();
        clearBrowserCache();
        Selenide.closeWebDriver();
    }
}
