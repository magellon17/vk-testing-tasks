package ru.siobko.testing.tasks.selenide.tests;

import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.selenide.pages.login.LoginPage;
import ru.siobko.testing.tasks.selenide.pages.main.FeedPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void testLogin() {
        FeedPage feedPage = new LoginPage()
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickSubmit();

        assertTrue(feedPage.checkProfileNameContains(EMAIL),
                "Incorrect account login name."
        );
    }
}
