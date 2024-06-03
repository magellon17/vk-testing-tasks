package ru.siobko.testing.tasks.patterns.tests.main;

import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.login.LoginPage;
import ru.siobko.testing.tasks.patterns.tests.UITest;

public abstract class RequiredLoginTest extends UITest {

    private static final Logger log = LoggerFactory.getLogger(RequiredLoginTest.class);

    @BeforeAll
    public static void login() {
        log.info("Логиним бота в аккаунт.");
        new LoginPage().login(BOT);
    }
}
