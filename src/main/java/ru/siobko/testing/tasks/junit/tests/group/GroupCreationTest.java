package ru.siobko.testing.tasks.junit.tests.group;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;
import ru.siobko.testing.tasks.junit.core.main.GroupsPage;
import ru.siobko.testing.tasks.junit.core.main.group.GroupFeedPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(groupFeedPage.getGroupName(),groupName,
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
