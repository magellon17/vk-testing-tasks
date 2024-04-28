package ru.siobko.testing.tasks.junit.tests;

import org.junit.jupiter.api.BeforeAll;
import ru.siobko.testing.tasks.junit.core.login.LoginPage;
import ru.siobko.testing.tasks.junit.models.TestBot;

public class BaseMainTest extends BaseTest {
    private static final TestBot bot = new TestBot(EMAIL, PASSWORD);

    @BeforeAll
    public static void login() {
        new LoginPage().login(bot);
    }
}
