package ru.siobko.testing.tasks.selenide;

import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.selenide.pages.FeedPage;
import ru.siobko.testing.tasks.selenide.pages.GroupPage;
import ru.siobko.testing.tasks.selenide.pages.GroupsPage;

import static com.codeborne.selenide.Condition.text;

public class GroupCreationTest extends BaseTest {
    @Test
    public void testGroupCreation() {
        FeedPage feedPage = new FeedPage();
        GroupsPage groupsPage = feedPage.openGroupsPage();
        GroupPage groupPage = groupsPage.createGroup("myGroup");

        groupPage.groupName.shouldHave(text("myGroup"));
    }
}
