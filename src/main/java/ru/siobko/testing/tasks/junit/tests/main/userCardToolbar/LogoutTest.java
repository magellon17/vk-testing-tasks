package ru.siobko.testing.tasks.junit.tests.main.userCardToolbar;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.junit.core.main.profile.myProfile.MyProfileFeedPage;
import ru.siobko.testing.tasks.junit.core.login.LoginPage;
import ru.siobko.testing.tasks.junit.tests.main.BaseMainTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("userCardToolbar")
public class LogoutTest extends BaseMainTest {
    @Test
    public void testLogin() {
        new MyProfileFeedPage()
                .expandUserCardToolbar()
                .logout()
                .confirmLogout();
        assertTrue(new LoginPage().checkPage(),
                "Не вышли из аккаунта, т.е. не попали на страницу входа."
        );
    }
}
