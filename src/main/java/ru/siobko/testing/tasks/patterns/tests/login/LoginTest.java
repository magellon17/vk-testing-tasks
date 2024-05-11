package ru.siobko.testing.tasks.patterns.tests.login;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.login.LoginPage;
import ru.siobko.testing.tasks.patterns.core.main.user.MyUserMainPage;
import ru.siobko.testing.tasks.patterns.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("login")
public class LoginTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @Test
    public void testLogin() {
        log.info("Логинимся в аккаунт.");
        MyUserMainPage mainPage = new LoginPage()
                .enterLogin(BOT.login())
                .enterPassword(BOT.password())
                .clickSubmit();
        assertTrue(mainPage.checkProfileNameContains(BOT.login()),
                "Имя профиля, в который выполнен вход, не совпадает с ожидаемым."
        );
    }
}
