package ru.siobko.testing.tasks.patterns.tests.main.userCardToolbar;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.login.LoginPage;
import ru.siobko.testing.tasks.patterns.core.main.user.MyUserMainPage;
import ru.siobko.testing.tasks.patterns.tests.main.BaseMainTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("userCardToolbar")
public class LogoutTest extends BaseMainTest {
    private static final Logger log = LoggerFactory.getLogger(LogoutTest.class);

    @Test
    public void testLogin() {
        log.info("Выходим из аккаунта.");
        LoginPage loginPage = new MyUserMainPage()
                .expandUserCardToolbar()
                .clickOnLogout()
                .confirmLogout();
        assertTrue(loginPage.checkPage(),
                "Не попали на страницу входа"
        );
    }
}
