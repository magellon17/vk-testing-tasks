package ru.siobko.testing.tasks.junit.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;
import ru.siobko.testing.tasks.junit.core.main.LoginPage;
import ru.siobko.testing.tasks.junit.core.main.MyProfilePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PublishTextPostTest extends BaseTest {
    @BeforeAll
    public static void setUp() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(EMAIL, PASSWORD);
    }

    @Test
    public void testPublishPost() {
        FeedPage feedPage = new FeedPage();
        feedPage.publishTextPost("Hello, World");
        MyProfilePage myProfilePage = feedPage.openMyProfilePage();

        assertTrue(
                myProfilePage.checkLastFeedPostContains("Hello, World"),
                "The post was not created."
        );
    }

    @AfterAll
    public static void tearDown() {
        MyProfilePage myProfilePage = new MyProfilePage();
        myProfilePage.deleteLastTextPost();
    }
}
