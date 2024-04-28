package ru.siobko.testing.tasks.junit.tests.groups.groupPage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.junit.core.main.groups.GroupsPage;
import ru.siobko.testing.tasks.junit.core.main.group.GroupFeedPage;
import ru.siobko.testing.tasks.junit.core.main.group.GroupMembersPage;
import ru.siobko.testing.tasks.junit.tests.groups.BaseGroupTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("groupPage")
public class OpenGroupMembersTest extends BaseGroupTest {
    @BeforeAll
    public static void createGroup() {
        new GroupsPage()
                .clickCreateGroup()
                .clickGroupByInterest()
                .enterGroupName(GROUP_NAME_ON_ENGLISH)
                .expandThematicsList()
                .clickAutoThematic()
                .clickCreate();
    }

    @Test
    public void testOpenMembers() {
        GroupMembersPage groupMembersPage = new GroupFeedPage()
                .openGroupMembersPage();
        assertTrue(groupMembersPage.checkPage(),
                "Group members page is not opened."
        );
    }
}
