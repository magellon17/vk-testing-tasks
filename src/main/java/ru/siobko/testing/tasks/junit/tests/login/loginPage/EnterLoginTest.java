package ru.siobko.testing.tasks.junit.tests.login.loginPage;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.junit.core.login.LoginPage;
import ru.siobko.testing.tasks.junit.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("loginPage")
public class EnterLoginTest extends BaseTest {

    @Test
    public void testEnterLogin() {
        LoginPage loginPage = new LoginPage()
                .enterLogin(BOT.getLogin());
        assertEquals(loginPage.getLoginFieldText(), BOT.getLogin(),
                "Incorrect account login name."
        );
    }
}
