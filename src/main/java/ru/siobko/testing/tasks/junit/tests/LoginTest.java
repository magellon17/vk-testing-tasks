package ru.siobko.testing.tasks.junit.tests;

import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.selenide.pages.main.LoginPage;
import ru.siobko.testing.tasks.selenide.pages.main.FeedPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage();
        FeedPage feedPage = loginPage.login(EMAIL, PASSWORD);


        assertTrue(
                feedPage.getMyProfileName().contains(EMAIL),
                "Incorrect account login."
        );
    }
}
