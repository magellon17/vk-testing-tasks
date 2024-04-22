package ru.siobko.testing.tasks.junit.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;
import ru.siobko.testing.tasks.junit.core.login.LoginPage;
import ru.siobko.testing.tasks.junit.core.main.MyProfilePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("publish")
public class PublishTextPostTest extends BaseTest {
    private static final String POST_TEXT = "Hello, World";

    @BeforeAll
    public static void login() {
        new LoginPage().login(EMAIL, PASSWORD);
    }

    @ParameterizedTest
    @ValueSource(strings = {POST_TEXT})
    public void testPublishPost(String postText) {
        FeedPage feedPage = new FeedPage();
        feedPage.publishTextPost(postText);
        MyProfilePage myProfilePage = feedPage.openMyProfilePage();

        assertTrue(
                myProfilePage.checkLastFeedPostContains(postText),
                "The post was not created."
        );
    }

    @AfterAll
    public static void deleteTextPost() {
        new MyProfilePage().deleteLastTextPost();
    }
}
