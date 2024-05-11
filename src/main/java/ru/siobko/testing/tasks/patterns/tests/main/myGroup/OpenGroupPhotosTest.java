package ru.siobko.testing.tasks.patterns.tests.main.myGroup;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.group.MyGroupMainPage;
import ru.siobko.testing.tasks.patterns.core.main.group.photos.GroupPhotosPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("groups")
@Tag("groupPage")
public class OpenGroupPhotosTest extends BaseGroupPageTest {
    private static final Logger log = LoggerFactory.getLogger(OpenGroupPhotosTest.class);

    @Test
    @DisplayName("Проверка открытия страницы фото группы")
    public void testOpenPhotos() {
        log.info("Открываем страницу с фотками группы.");
        GroupPhotosPage groupPhotosPage = new MyGroupMainPage()
                .openGroupPhotosPage();
        assertTrue(groupPhotosPage.checkPage(),
                "Не открылась страница с фотками группы."
        );
    }
}
