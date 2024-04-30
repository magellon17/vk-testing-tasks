package ru.siobko.testing.tasks.junit.tests.main.groups.groupPage;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.junit.core.main.group.GroupFeedPage;
import ru.siobko.testing.tasks.junit.core.main.group.GroupPhotosPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("groups")
@Tag("groupPage")
public class OpenGroupPhotosTest extends BaseGroupPageTest {
    private static final Logger TESTLOG = LoggerFactory.getLogger(OpenGroupPhotosTest.class);

    @Test
    public void testOpenPhotos() {
        TESTLOG.info("Открываем страницу с фотками группы.");
        GroupPhotosPage groupPhotosPage = new GroupFeedPage()
                .openGroupPhotosPage();
        assertTrue(groupPhotosPage.checkPage(),
                "Не открылась страница с фотками группы."
        );
    }
}
