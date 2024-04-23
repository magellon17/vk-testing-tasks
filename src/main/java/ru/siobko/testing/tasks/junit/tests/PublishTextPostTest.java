package ru.siobko.testing.tasks.junit.tests;

import org.junit.jupiter.api.*;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;
import ru.siobko.testing.tasks.junit.core.login.LoginPage;
import ru.siobko.testing.tasks.junit.core.main.MyProfilePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("publish")
public class PublishTextPostTest extends BaseTest {
    private static final String POST_TEXT = "Hello, World";

    @BeforeAll
    public static void login() {
        new LoginPage()
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickSubmit();
    }

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
