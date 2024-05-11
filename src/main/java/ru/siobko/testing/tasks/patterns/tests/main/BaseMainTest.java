package ru.siobko.testing.tasks.patterns.tests.main;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.login.LoginPage;
import ru.siobko.testing.tasks.patterns.tests.BaseTest;

public abstract class BaseMainTest extends BaseTest {
    private static final Logger TESTLOG = LoggerFactory.getLogger(BaseMainTest.class);

    @BeforeAll
    public static void login() {
        TESTLOG.info("Логиним бота в аккаунт.");
        new LoginPage().login(BOT);
    }
}
