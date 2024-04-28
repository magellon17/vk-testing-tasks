package ru.siobko.testing.tasks.junit.tests;

import org.junit.jupiter.api.BeforeAll;
import ru.siobko.testing.tasks.junit.core.login.LoginPage;

public class BaseMainTest extends BaseTest {
    @BeforeAll
    public static void login() {
        new LoginPage()
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickSubmit();
    }
}
