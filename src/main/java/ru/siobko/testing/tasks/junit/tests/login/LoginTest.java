package ru.siobko.testing.tasks.junit.tests.login;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.junit.core.login.LoginPage;
import ru.siobko.testing.tasks.junit.core.main.profile.myProfile.MyProfileFeedPage;
import ru.siobko.testing.tasks.junit.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("login")
public class LoginTest extends BaseTest {
    private static final Logger TESTLOG = LoggerFactory.getLogger(LoginTest.class);

    @Test
    public void testLogin() {
        TESTLOG.info("Логинимся в аккаунт.");
        MyProfileFeedPage myProfileFeedPage = new LoginPage()
                .enterLogin(BOT.getLogin())
                .enterPassword(BOT.getPassword())
                .clickSubmit();
        assertTrue(myProfileFeedPage.checkProfileNameContains(BOT.getLogin()),
                "Имя профиля, в который выполнен вход, не совпадает с ожидаемым."
        );
    }
}
