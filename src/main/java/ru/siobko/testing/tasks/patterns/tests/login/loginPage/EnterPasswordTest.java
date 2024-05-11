package ru.siobko.testing.tasks.patterns.tests.login.loginPage;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.login.LoginPage;
import ru.siobko.testing.tasks.patterns.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("LoginPageTextFields")
public class EnterPasswordTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(EnterPasswordTest.class);

    @Test
    public void testEnterPassword() {
        log.info("Вводим пароль.");
        LoginPage loginPage = new LoginPage()
                .enterPassword(BOT.password());
        assertEquals(loginPage.getPasswordFieldText(), BOT.password(),
                "Значение текстового поля пароля не совпадает с ожидаемым."
        );
    }
}
