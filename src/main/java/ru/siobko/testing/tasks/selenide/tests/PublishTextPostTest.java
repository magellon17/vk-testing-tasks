package ru.siobko.testing.tasks.selenide.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.selenide.pages.main.FeedPage;
import ru.siobko.testing.tasks.selenide.pages.main.LoginPage;
import ru.siobko.testing.tasks.selenide.pages.main.MyProfilePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PublishTextPostTest extends BaseTest {
    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://ok.ru";
        Selenide.open("/");

        LoginPage loginPage = new LoginPage();
        loginPage.login(email, password);
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
        clearBrowserCache();
        Selenide.closeWebDriver();
    }
}
