package ru.siobko.testing.tasks.junit.tests.main.groups.groupsPage;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.junit.core.main.groups.GroupsPage;
import ru.siobko.testing.tasks.junit.core.main.groups.OfficialGroupsPage;
import ru.siobko.testing.tasks.junit.tests.main.groups.BaseGroupsTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("groups")
@Tag("groupsPage")
public class OpenOfficialGroupsCatalogTest extends BaseGroupsTest {
    private static final Logger TESTLOG = LoggerFactory.getLogger(OpenOfficialGroupsCatalogTest.class);

    @Test
    public void testOpenOfficialGroupsCatalog() {
        TESTLOG.info("Открываем страницу с каталогом официальных групп.");
        OfficialGroupsPage officialGroupsPage = new GroupsPage()
                .openOfficialGroupsCatalog();
        assertTrue(officialGroupsPage.checkPage(),
                "Не открылась страница с каталогом официальных групп."
        );
    }
}
