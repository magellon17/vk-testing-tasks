package ru.siobko.testing.tasks.junit.tests.main.publish;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.junit.core.main.profile.myProfile.MyProfileFeedPage;
import ru.siobko.testing.tasks.junit.core.media.PostPage;
import ru.siobko.testing.tasks.junit.tests.main.BaseMainTest;

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
        PostPage postPage = new MyProfileFeedPage()
                .clickPublish()
                .clickPublishPost()
                .enterPostText(text)
                .clickSubmit()
                .openPost();
        assertEquals(postPage.getText(), text,
                "Текст поста не совпал с ожидаемым."
        );
    }

    @AfterEach
    public void deletePost() {
        TESTLOG.info("Удаляем пост.");
        new PostPage()
                .deletePost()
                .closePost();
    }
}
