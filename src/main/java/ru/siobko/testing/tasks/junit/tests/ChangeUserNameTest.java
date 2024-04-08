package ru.siobko.testing.tasks.junit.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;
import ru.siobko.testing.tasks.junit.core.main.LoginPage;
import ru.siobko.testing.tasks.junit.core.main.MyProfilePage;
import ru.siobko.testing.tasks.junit.core.settings.SettingsBasicPage;
import ru.siobko.testing.tasks.junit.core.settings.SettingsBasicPersonalDataPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangeUserNameTest extends BaseTest {
    @BeforeAll
    public static void setUp() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(EMAIL, PASSWORD);

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
                personalDataPage.checkProfileNameContains(newUserName),
                "Incorrect name change."
        );
    }

    @AfterAll
    public static void tearDown() {
        SettingsBasicPage settingsBasicPage = new SettingsBasicPage();
        SettingsBasicPersonalDataPage personalDataPage = settingsBasicPage.openPersonalDataPage();
        personalDataPage.changeName(EMAIL);
    }
}
