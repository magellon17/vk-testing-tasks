package ru.siobko.testing.tasks.patterns.tests.login;

import org.junit.jupiter.api.DisplayName;
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
    private static final Logger TESTLOG = LoggerFactory.getLogger(LoginTest.class);

    @Test
    @DisplayName("Проверка входа в аккаунт")
    public void testLogin() {
        TESTLOG.info("Логинимся в аккаунт.");
        MyUserMainPage mainPage = new LoginPage()
                .enterLogin(BOT.login())
                .enterPassword(BOT.password())
                .clickSubmit();
        assertTrue(mainPage.checkProfileNameContains(BOT.login()),
                "Имя профиля, в который выполнен вход, не совпадает с ожидаемым."
        );
    }
}
