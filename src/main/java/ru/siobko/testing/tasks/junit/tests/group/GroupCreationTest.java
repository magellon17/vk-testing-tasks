package ru.siobko.testing.tasks.junit.tests.group;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;
import ru.siobko.testing.tasks.junit.core.main.GroupsPage;
import ru.siobko.testing.tasks.junit.core.main.group.GroupFeedPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("group")
public class GroupCreationTest extends BaseGroupTest {
    @BeforeAll
    public static void openGroupsPage() {
        new FeedPage().openGroupsPage();
    }

    @ParameterizedTest
    @ValueSource(strings = {GROUP_NAME_ON_ENGLISH, GROUP_NAME_ON_RUSSIAN})
    public void testGroupCreation(String groupName) {
        GroupFeedPage groupFeedPage = new GroupsPage()
                .clickCreateGroup()
                .clickGroupByInterest()
                .enterGroupName(groupName)
                .expandThematicsList()
                .clickAutoThematic()
                .clickCreate();
        assertTrue(groupFeedPage.checkGroupNameEquals(groupName),
                "The group was created incorrectly."
        );
    }

    @AfterEach
    public void deleteGroup() {
        new GroupFeedPage()
                .clickMoreActions()
                .clickDelete()
                .confirmDeletion();
    }
}
