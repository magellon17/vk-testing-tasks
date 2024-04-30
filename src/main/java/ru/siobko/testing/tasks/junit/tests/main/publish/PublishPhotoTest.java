package ru.siobko.testing.tasks.junit.tests.main.publish;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.junit.core.main.profile.myProfile.MyProfileFeedPage;
import ru.siobko.testing.tasks.junit.core.media.PhotoPage;
import ru.siobko.testing.tasks.junit.tests.main.BaseMainTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("publish")
public class PublishPhotoTest extends BaseMainTest {
    private static final Logger TESTLOG = LoggerFactory.getLogger(PublishPhotoTest.class);

    private static final String JPG_PHOTO = "src/main/java/ru/siobko/testing/tasks/junit/tests/data/bestPhoto.jpg";
    private static final String PNG_PHOTO = "src/main/java/ru/siobko/testing/tasks/junit/tests/data/lovelyPhoto.png";

    @DisplayName("Публикация фото")
    @ParameterizedTest(name = "Фото: {0}")
    @ValueSource(strings = {JPG_PHOTO, PNG_PHOTO})
    public void testPublishPhoto(String filename) {
        TESTLOG.info("Публикуем фото.");
        PhotoPage photoPage = new MyProfileFeedPage()
                .clickPublish()
                .clickPublishPhoto(filename)
                .openPhoto();
        assertTrue(photoPage.checkImage(),
                "Отсутствует фото."
        );
    }

    @AfterEach
    public void deletePhoto() {
        TESTLOG.info("Удаляем фото.");
        new PhotoPage()
                .deletePhoto()
                .closePhoto();
    }
}
