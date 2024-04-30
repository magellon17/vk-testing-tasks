package ru.siobko.testing.tasks.junit.tests.login;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.junit.core.login.LoginPage;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;
import ru.siobko.testing.tasks.junit.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("login")
public class LoginTest extends BaseTest {
    @Test
    public void testLogin() {
        FeedPage feedPage = new LoginPage()
                .enterLogin(BOT.getLogin())
                .enterPassword(BOT.getPassword())
                .clickSubmit();
        assertTrue(feedPage.checkProfileNameContains(BOT.getLogin()),
                "Имя профиля, в который выполнен вход, не совпадает с ожидаемым."
        );
    }
}
