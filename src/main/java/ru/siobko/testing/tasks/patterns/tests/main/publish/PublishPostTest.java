package ru.siobko.testing.tasks.patterns.tests.main.publish;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.user.MyUserMainPage;
import ru.siobko.testing.tasks.patterns.core.media.PostLayer;
import ru.siobko.testing.tasks.patterns.tests.main.BaseMainTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("publish")
public class PublishPostTest extends BaseMainTest {
    private static final Logger TESTLOG = LoggerFactory.getLogger(PublishPostTest.class);

    private static final String ENGLISH_TEXT = "Hello, World";
    private static final String RUSSIAN_TEXT = "Лена Пранова самая лучшая!!!";

    @DisplayName("Проверка публикации поста")
    @ParameterizedTest(name = "Текст: {0}")
    @ValueSource(strings = {ENGLISH_TEXT, RUSSIAN_TEXT})
    public void testPublishPost(String text) {
        TESTLOG.info("Публикуем пост.");
        PostLayer postLayer = new MyUserMainPage()
                .clickPublish()
                .clickPublishPost()
                .enterPostText(text)
                .clickSubmit()
                .openPost();
        assertEquals(postLayer.getText(), text,
                "Текст поста не совпал с ожидаемым."
        );
    }

    @AfterEach
    public void deleteStatus() {
        TESTLOG.info("Удаляем пост.");
        new PostLayer()
                .clickOnDelete()
                .closeLayer();
    }
}
