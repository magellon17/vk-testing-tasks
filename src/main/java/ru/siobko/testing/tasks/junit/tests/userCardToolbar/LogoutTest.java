package ru.siobko.testing.tasks.junit.tests.userCardToolbar;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;
import ru.siobko.testing.tasks.junit.core.login.LoginPage;
import ru.siobko.testing.tasks.junit.tests.BaseMainTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("userCardToolbar")
public class LogoutTest extends BaseMainTest {
    @Test
    public void testLogin() {
        new FeedPage()
                .expandUserCardToolbar()
                .logout()
                .confirmLogout();
        assertTrue(new LoginPage().checkPage(),
                "Login page was not found."
        );
    }
}
