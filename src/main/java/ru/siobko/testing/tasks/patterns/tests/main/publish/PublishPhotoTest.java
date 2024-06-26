package ru.siobko.testing.tasks.patterns.tests.main.publish;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.user.MyUserMainPage;
import ru.siobko.testing.tasks.patterns.core.media.photo.PhotoLayer;
import ru.siobko.testing.tasks.patterns.tests.main.RequiredLoginTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("publishMedia")
public class PublishPhotoTest extends RequiredLoginTest {

    private static final Logger log = LoggerFactory.getLogger(PublishPhotoTest.class);

    private static final String JPG_PHOTO = "src/main/java/ru/siobko/testing/tasks/patterns/tests/data/bestPhoto.jpg";
    private static final String PNG_PHOTO = "src/main/java/ru/siobko/testing/tasks/patterns/tests/data/lovelyPhoto.png";

    @ParameterizedTest(name = "Фото: {0}")
    @ValueSource(strings = {JPG_PHOTO, PNG_PHOTO})
    public void testPublishPhoto(String filename) {
        log.info("Публикуем фото.");
        PhotoLayer photoLayer = new MyUserMainPage()
                .clickPublish()
                .uploadPhoto(filename)
                .openPhoto();
        assertTrue(photoLayer.checkImage(),
                "Отсутствует фото."
        );
    }

    @AfterEach
    public void deletePhoto() {
        log.info("Удаляем фото.");
        new PhotoLayer()
                .expandActionsMenu()
                .deletePhoto()
                .closeLayer();
    }
}
