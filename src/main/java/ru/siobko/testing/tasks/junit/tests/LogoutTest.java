package ru.siobko.testing.tasks.junit.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;
import ru.siobko.testing.tasks.junit.core.login.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest extends BaseTest {
    @BeforeAll
    public static void setUp() {
        new LoginPage().login(EMAIL, PASSWORD);
    }

    @Test
    public void testLogin() {
        new FeedPage().openUserCardToolbar()
                .logout()
                .confirmLogout();

        assertTrue(
                LoginPage.checkPage(),
                "Login page was not found."
        );
    }
}
