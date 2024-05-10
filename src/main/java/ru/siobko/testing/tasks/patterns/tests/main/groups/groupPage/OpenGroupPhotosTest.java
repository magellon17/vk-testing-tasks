package ru.siobko.testing.tasks.patterns.tests.main.groups.groupPage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.group.feed.GroupFeedPage;
import ru.siobko.testing.tasks.patterns.core.main.group.photos.GroupPhotosPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("groups")
@Tag("groupPage")
public class OpenGroupPhotosTest extends BaseGroupPageTest {
    private static final Logger TESTLOG = LoggerFactory.getLogger(OpenGroupPhotosTest.class);

    @Test
    @DisplayName("Проверка открытия страницы фото группы")
    public void testOpenPhotos() {
        TESTLOG.info("Открываем страницу с фотками группы.");
        GroupPhotosPage groupPhotosPage = new GroupFeedPage()
                .openGroupPhotosPage();
        assertTrue(groupPhotosPage.checkPage(),
                "Не открылась страница с фотками группы."
        );
    }
}
