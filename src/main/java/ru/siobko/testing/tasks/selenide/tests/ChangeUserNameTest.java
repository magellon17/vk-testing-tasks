package ru.siobko.testing.tasks.selenide.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.selenide.pages.main.FeedPage;
import ru.siobko.testing.tasks.selenide.pages.main.LoginPage;
import ru.siobko.testing.tasks.selenide.pages.main.MyProfilePage;
import ru.siobko.testing.tasks.selenide.pages.settings.SettingsBasicPage;
import ru.siobko.testing.tasks.selenide.pages.settings.SettingsBasicPersonalDataPage;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangeUserNameTest extends BaseTest {
    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://ok.ru";
        Selenide.open("/");

        LoginPage loginPage = new LoginPage();
        loginPage.login(email, password);

        FeedPage feedPage = new FeedPage();
        MyProfilePage myProfilePage = feedPage.openMyProfilePage();
        SettingsBasicPage settingsBasicPage = myProfilePage.openProfileSettings();
        settingsBasicPage.openPersonalDataPage();
    }

    @Test
    public void testChangeUserName() {
        SettingsBasicPersonalDataPage personalDataPage = new SettingsBasicPersonalDataPage();
        String newUserName = "Boris";

        personalDataPage.changeName(newUserName);
        Selenide.refresh();

        assertTrue(
                personalDataPage.getProfileName().contains(newUserName),
                "Incorrect name change."
        );
    }

    @AfterAll
    public static void tearDown() {
        SettingsBasicPage settingsBasicPage = new SettingsBasicPage();
        SettingsBasicPersonalDataPage personalDataPage = settingsBasicPage.openPersonalDataPage();
        personalDataPage.changeName(email);

        clearBrowserCache();
        Selenide.closeWebDriver();
    }
}
