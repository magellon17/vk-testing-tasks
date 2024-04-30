package ru.siobko.testing.tasks.junit.tests.main.groups.groupPage;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.junit.core.main.group.GroupFeedPage;
import ru.siobko.testing.tasks.junit.core.main.group.GroupMembersPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("groupPage")
public class OpenGroupMembersTest extends BaseGroupPageTest {
    private static final Logger TESTLOG = LoggerFactory.getLogger(OpenGroupMembersTest.class);

    @Test
    public void testOpenMembers() {
        TESTLOG.info("Открываем страницу с участниками группы.");
        GroupMembersPage groupMembersPage = new GroupFeedPage()
                .openGroupMembersPage();
        assertTrue(groupMembersPage.checkPage(),
                "Не открылась страница с участниками группы."
        );
    }
}
