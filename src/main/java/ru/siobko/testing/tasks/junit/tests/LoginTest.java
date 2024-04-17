package ru.siobko.testing.tasks.junit.tests;

import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.junit.core.main.LoginPage;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail(EMAIL);
        loginPage.enterPassword(PASSWORD);
        FeedPage feedPage = loginPage.clickSubmit();

        assertTrue(
                feedPage.checkProfileNameContains(EMAIL),
                "Incorrect account login name."
        );
    }
}
