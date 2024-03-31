package ru.siobko.testing.tasks.selenide.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.selenide.pages.main.LoginPage;
import ru.siobko.testing.tasks.selenide.pages.main.FeedPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {
    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://ok.ru";
        Selenide.open("/");
    }

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage();
        FeedPage feedPage = loginPage.login(email, password);


        assertTrue(
                feedPage.getMyProfileName().contains(email),
                "Incorrect account login."
        );
    }
}
