package ru.siobko.testing.tasks.patterns.tests.login.loginPage;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.login.LoginPage;
import ru.siobko.testing.tasks.patterns.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("LoginPageTextFields")
public class EnterLoginTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(EnterLoginTest.class);

    @Test
    public void testEnterLogin() {
        log.info("Вводим пароль.");
        LoginPage loginPage = new LoginPage()
                .enterLogin(BOT.login());
        assertEquals(loginPage.getLoginFieldText(), BOT.login(),
                "Значение текстового поля логина не совпадает с ожидаемым."
        );
    }
}
