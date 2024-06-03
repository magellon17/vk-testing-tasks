package ru.siobko.testing.tasks.patterns.tests.main.publish;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.user.MyUserMainPage;
import ru.siobko.testing.tasks.patterns.core.media.PostLayer;
import ru.siobko.testing.tasks.patterns.tests.main.RequiredLoginTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("publishMedia")
public class PublishPostTest extends RequiredLoginTest {

    private static final Logger log = LoggerFactory.getLogger(PublishPostTest.class);

    private static final String ENGLISH_TEXT = "Life moves pretty fast. If you don't stop and look around once in a while, you could miss it.";
    private static final String AUF_TEXT = "Лучше один день прожить волком, чем сто лет-шакалом.";

    @ParameterizedTest(name = "Текст: {0}")
    @ValueSource(strings = {ENGLISH_TEXT, AUF_TEXT})
    public void testPublishPost(String text) {
        log.info("Публикуем пост");
        PostLayer postLayer = new MyUserMainPage()
                .clickPublish()
                .clickOnPublishPost()
                .enterPostText(text)
                .clickSubmit()
                .openPublishedPost();
        assertEquals(postLayer.getText(), text,
                "Текст поста не совпал с ожидаемым."
        );
    }

    @AfterEach
    public void deletePost() {
        log.info("Удаляем пост");
        new PostLayer()
                .clickOnDelete()
                .closeLayer();
    }
}
