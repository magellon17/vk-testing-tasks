package ru.siobko.testing.tasks.junit.tests.group.groupPage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;
import ru.siobko.testing.tasks.junit.core.main.group.GroupFeedPage;
import ru.siobko.testing.tasks.junit.core.main.group.GroupPhotosPage;
import ru.siobko.testing.tasks.junit.tests.group.BaseGroupTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenGroupPhotosTest extends BaseGroupTest {
    @BeforeAll
    public static void createGroup() {
        new FeedPage()
                .openGroupsPage()
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
