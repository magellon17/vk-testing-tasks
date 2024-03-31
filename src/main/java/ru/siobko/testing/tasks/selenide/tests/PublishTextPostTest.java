package ru.siobko.testing.tasks.selenide.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.selenide.pages.main.FeedPage;
import ru.siobko.testing.tasks.selenide.pages.main.MyProfilePage;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PublishTextPostTest extends BaseTest {
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
        MyProfilePage myProfilePage = new MyProfilePage();
        SelenideElement moreActionsMenu = myProfilePage.getLastFeedPost()
                .$(byXpath(".//div[@data-l='t,feed-actions-menu']"));

        moreActionsMenu.scrollIntoView(true);
        moreActionsMenu
                .hover()
                .$(byXpath(".//a[@data-l='t,.r']"))
                .click();

        clearBrowserCache();
        Selenide.closeWebDriver();
    }
}
