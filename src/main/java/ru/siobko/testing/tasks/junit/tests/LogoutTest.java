package ru.siobko.testing.tasks.junit.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;
import ru.siobko.testing.tasks.junit.core.main.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest extends BaseTest {
    @BeforeAll
    public static void setUp() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(EMAIL, PASSWORD);
    }

    @Test
    public void testLogin() {
        FeedPage feedPage = new FeedPage();
        feedPage.openUserCardToolbar()
                .logout()
                .confirmLogout();

        assertTrue(
                LoginPage.checkPage(),
                "Login page was not found."
        );
    }
}
