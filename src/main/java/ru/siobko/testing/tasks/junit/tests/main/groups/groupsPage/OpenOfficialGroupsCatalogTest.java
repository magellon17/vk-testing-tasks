package ru.siobko.testing.tasks.junit.tests.main.groups.groupsPage;

import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.junit.core.main.groups.GroupsPage;
import ru.siobko.testing.tasks.junit.core.main.groups.OfficialGroupsPage;
import ru.siobko.testing.tasks.junit.tests.main.groups.BaseGroupTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenOfficialGroupsCatalogTest extends BaseGroupTest {
    @Test
    public void testOpenOfficialGroupsCatalog() {
        OfficialGroupsPage officialGroupsPage = new GroupsPage()
                .openOfficialGroupsCatalog();
        assertTrue(officialGroupsPage.checkPage(),
                "Страница с официальными группами не открылась."
        );
    }
}
