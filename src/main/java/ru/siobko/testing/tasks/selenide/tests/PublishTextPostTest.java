package ru.siobko.testing.tasks.selenide.tests;

import org.junit.jupiter.api.*;
import ru.siobko.testing.tasks.selenide.pages.main.FeedPage;
import ru.siobko.testing.tasks.selenide.pages.login.LoginPage;
import ru.siobko.testing.tasks.selenide.pages.main.MyProfilePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PublishTextPostTest extends BaseTest {
    private static final String POST_TEXT = "Hello, World";

    @BeforeAll
    public static void login() {
        new LoginPage().enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickSubmit();
    }

    @Test
    public void testPublishPost() {
        FeedPage feedPage = new FeedPage();
        feedPage.publishTextPost(POST_TEXT);
        MyProfilePage myProfilePage = feedPage.openMyProfilePage();

        assertTrue(
                myProfilePage.checkLastFeedPostContains(POST_TEXT),
                "The post was not created."
        );
    }

    @AfterAll
    public static void deleteTextPost() {
        new MyProfilePage().deleteLastTextPost();
    }
}
