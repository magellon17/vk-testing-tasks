package ru.siobko.testing.tasks.junit.tests.publish;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;
import ru.siobko.testing.tasks.junit.core.main.MyProfilePage;
import ru.siobko.testing.tasks.junit.tests.BaseMainTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("publish")
public class PublishTextPostTest extends BaseMainTest {
    private static final String POST_TEXT = "Hello, World";

    @Test
    public void testPublishPost() {
        MyProfilePage myProfilePage = new FeedPage()
                .clickPublish()
                .clickPublishPost()
                .enterPostText(POST_TEXT)
                .clickSubmit()
                .openMyProfilePage();
        assertTrue(myProfilePage.checkLastFeedPostContains(POST_TEXT),
                "The post was not created."
        );
    }

    @AfterAll
    public static void deleteTextPost() {
        new MyProfilePage()
                .hoverLastFeedPostActionsMenu()
                .clickDeleteNote()
                .confirmDeletion();
    }
}
