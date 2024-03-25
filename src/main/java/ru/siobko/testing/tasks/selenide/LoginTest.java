package ru.siobko.testing.tasks.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.selenide.pages.LoginPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginTest {
    @BeforeAll
    public static void setUp(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://ok.ru";
    }

    @Test
    public void testLogin(){
        LoginPage loginPage = new LoginPage();
        loginPage.open().login();
        $(byText("Друзья на сайте")).shouldBe(visible);
    }

    @AfterAll
    public static void tearDown(){
        Selenide.closeWebDriver();
    }
}
