package ru.siobko.testing.tasks.junit.tests.main.groups.groupPage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.junit.core.main.groups.GroupsPage;
import ru.siobko.testing.tasks.junit.core.main.group.GroupFeedPage;
import ru.siobko.testing.tasks.junit.core.main.group.GroupPhotosPage;
import ru.siobko.testing.tasks.junit.tests.main.groups.BaseGroupTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("groupPage")
public class OpenGroupPhotosTest extends BaseGroupTest {
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
    public void testOpenPhotos() {
        GroupPhotosPage groupPhotosPage = new GroupFeedPage()
                .openGroupPhotosPage();
        assertTrue(groupPhotosPage.checkPage(),
                "Group photos page is not opened."
        );
    }
}
