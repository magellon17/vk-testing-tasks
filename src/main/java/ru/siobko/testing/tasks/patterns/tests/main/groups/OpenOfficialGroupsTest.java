package ru.siobko.testing.tasks.patterns.tests.main.groups;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.groups.GroupsMainPage;
import ru.siobko.testing.tasks.patterns.core.main.groups.OfficialGroupsPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("groups")
@Tag("groupsPage")
public class OpenOfficialGroupsTest extends BaseGroupsTest {
    private static final Logger log = LoggerFactory.getLogger(OpenOfficialGroupsTest.class);

    @Test
    public void testOpenOfficialGroupsCatalog() {
        log.info("Открываем страницу с каталогом официальных групп.");
        OfficialGroupsPage officialGroupsPage = new GroupsMainPage()
                .openOfficialGroupsCatalog();
        assertTrue(officialGroupsPage.checkPage(),
                "Не открылась страница с каталогом официальных групп."
        );
    }
}
