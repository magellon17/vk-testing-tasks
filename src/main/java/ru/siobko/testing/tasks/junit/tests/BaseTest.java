package ru.siobko.testing.tasks.junit.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.siobko.testing.tasks.junit.models.TestBot;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public abstract class BaseTest {
    protected static final String BROWSER = "chrome";
    protected static final String BASE_URL = "https://ok.ru";
    protected static final TestBot BOT = new TestBot("technopol72", "technopolisPassword");
    protected static final TestBot EXTRA_BOT = new TestBot("technopol54", "technopolisPassword");

    @BeforeAll
    public static void setUp() {
        Configuration.browser = BROWSER;
        Configuration.baseUrl = BASE_URL;
        Selenide.open("/");
    }

    @AfterAll
    public static void tearDown() {
        clearBrowserCache();
        Selenide.closeWebDriver();
    }
}
