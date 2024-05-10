package ru.siobko.testing.tasks.patterns.tests.main.groups.groupPage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.group.MyGroupMainPage;
import ru.siobko.testing.tasks.patterns.core.main.group.members.GroupMembersPage;
import ru.siobko.testing.tasks.patterns.core.main.group.members.MyGroupMembersPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("groups")
@Tag("groupPage")
public class OpenGroupMembersTest extends BaseGroupPageTest {
    private static final Logger TESTLOG = LoggerFactory.getLogger(OpenGroupMembersTest.class);

    @Test
    @DisplayName("Проверка открытия страницы участников группы")
    public void testOpenMembers() {
        TESTLOG.info("Открываем страницу с участниками группы.");
        GroupMembersPage groupMembersPage = new MyGroupMainPage()
                .openGroupMembersPage();
        assertTrue(groupMembersPage.checkPage(),
                "Не открылась страница с участниками группы."
        );
    }
}
