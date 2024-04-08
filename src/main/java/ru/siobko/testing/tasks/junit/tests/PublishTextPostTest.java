package ru.siobko.testing.tasks.junit.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.selenide.pages.main.FeedPage;
import ru.siobko.testing.tasks.selenide.pages.main.LoginPage;
import ru.siobko.testing.tasks.selenide.pages.main.MyProfilePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

        assertEquals(myProfilePage.getLastFeedPostText(),
                "Hello, World",
                "The post was not created."
        );
    }

    @AfterAll
    public static void tearDown() {
        $(byXpath(".//div[@data-l='t,feed-actions-menu']"))
                .shouldBe(visible)
                .scrollIntoView("{block: \"center\"}")
                .hover();
        $(byXpath(".//*[text()='Удалить заметку']")).shouldBe(visible).click();
    }
}
