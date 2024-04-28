package ru.siobko.testing.tasks.junit.tests.login.loginPage;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.junit.core.login.LoginPage;
import ru.siobko.testing.tasks.junit.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("loginPage")
public class EnterPasswordTest extends BaseTest {
    @Test
    public void testEnterPassword() {
        LoginPage loginPage = new LoginPage()
                .enterPassword(PASSWORD);
        assertEquals(loginPage.getPasswordFieldText(), PASSWORD,
                "Incorrect account login name."
        );
    }
}
