package ru.siobko.testing.tasks.junit.tests.main.publish;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.junit.core.main.profile.myProfile.MyProfileFeedPage;
import ru.siobko.testing.tasks.junit.core.media.StatusPage;
import ru.siobko.testing.tasks.junit.tests.main.BaseMainTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("publish")
public class PublishStatusTest extends BaseMainTest {
    private static final Logger TESTLOG = LoggerFactory.getLogger(PublishStatusTest.class);

    private static final String ENGLISH_TEXT = "Hello, World";
    private static final String RUSSIAN_TEXT = "Лена Пранова самая лучшая!!!";

    @ParameterizedTest
    @ValueSource(strings = {ENGLISH_TEXT, RUSSIAN_TEXT})
    public void testPublishStatus(String text) {
        TESTLOG.info("Публикуем статус.");
        StatusPage statusPage = new MyProfileFeedPage()
                .clickPublish()
                .clickPublishStatus()
                .enterPostText(text)
                .clickSubmit()
                .openStatus();
        assertEquals(statusPage.getText(), text,
                "Текст поста не совпал с ожидаемым."
        );
    }

    @AfterEach
    public void deleteStatus() {
        TESTLOG.info("Удаляем статус.");
        new StatusPage()
                .deleteStatus()
                .closeStatus();
    }
}
