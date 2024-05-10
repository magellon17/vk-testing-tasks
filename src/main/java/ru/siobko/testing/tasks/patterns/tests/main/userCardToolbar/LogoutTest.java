package ru.siobko.testing.tasks.patterns.tests.main.userCardToolbar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.user.MyProfileMainPage;
import ru.siobko.testing.tasks.patterns.core.login.LoginPage;
import ru.siobko.testing.tasks.patterns.tests.main.BaseMainTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("userCardToolbar")
public class LogoutTest extends BaseMainTest {
    private static final Logger TESTLOG = LoggerFactory.getLogger(LogoutTest.class);

    @Test
    @DisplayName("Проверка выхода из аккаунта.")
    public void testLogin() {
        TESTLOG.info("Выходим из аккаунта.");
        new MyProfileMainPage()
                .expandUserCardToolbar()
                .clickOnLogout()
                .confirmLogout();
        assertTrue(new LoginPage().checkPage(),
                "Не вышли из аккаунта, т.е. не попали на страницу входа."
        );
    }
}
