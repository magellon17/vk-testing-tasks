package ru.siobko.testing.tasks.selenide.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.selenide.pages.LoginPage;
import ru.siobko.testing.tasks.selenide.pages.FeedPage;

import static com.codeborne.selenide.Condition.text;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {
    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://ok.ru";
    }

    @Test
    public void testLogin() {
        Selenide.open("/");
        LoginPage loginPage = new LoginPage();
        FeedPage feedPage = loginPage.login(email, password);

        feedPage.getMyProfileButton().shouldHave(text(email));
    }
}
