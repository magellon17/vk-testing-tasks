package ru.siobko.testing.tasks.selenide.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.siobko.testing.tasks.selenide.pages.LoginPage;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class BaseTest {
    protected static final String email = "technopol72";
    protected static final String password = "technopolisPassword";

    @BeforeAll
    public static void setUp(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://ok.ru";
        Selenide.open("/");

        LoginPage loginPage = new LoginPage();
        loginPage.login(email, password);
    }

    @AfterAll
    public static void tearDown(){
        clearBrowserCache();
        Selenide.closeWebDriver();
    }
}
