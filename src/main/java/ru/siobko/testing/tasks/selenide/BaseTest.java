package ru.siobko.testing.tasks.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class BaseTest {
    protected final String email = "technopol72";
    protected final String password = "technopolisPassword";

    @BeforeAll
    public static void setUp(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://ok.ru";
        clearBrowserCache();
    }


    @AfterAll
    public static void tearDown(){
        Selenide.closeWebDriver();
    }
}
