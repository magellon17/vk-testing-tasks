package ru.siobko.testing.tasks.junit.tests.main.userCardToolbar;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.junit.core.main.profile.myProfile.MyProfileFeedPage;
import ru.siobko.testing.tasks.junit.core.login.LoginPage;
import ru.siobko.testing.tasks.junit.tests.main.BaseMainTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("userCardToolbar")
public class LogoutTest extends BaseMainTest {
    private static final Logger TESTLOG = LoggerFactory.getLogger(LogoutTest.class);

    @Test
    public void testLogin() {
        TESTLOG.info("Выходим из аккаунта.");
        new MyProfileFeedPage()
                .expandUserCardToolbar()
                .logout()
                .confirmLogout();
        assertTrue(new LoginPage().checkPage(),
                "Не вышли из аккаунта, т.е. не попали на страницу входа."
        );
    }
}
