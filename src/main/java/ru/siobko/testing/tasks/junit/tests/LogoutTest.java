package ru.siobko.testing.tasks.junit.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;
import ru.siobko.testing.tasks.junit.core.login.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("auth")
public class LogoutTest extends BaseTest {
    @BeforeAll
    public static void login() {
        new LoginPage()
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickSubmit();
    }

    @Test
    public void testLogin() {
        new FeedPage().openUserCardToolbar()
                .logout()
                .confirmLogout();

        assertTrue(new LoginPage().checkPage(),
                "Login page was not found."
        );
    }
}
