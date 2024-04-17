package ru.siobko.testing.tasks.junit.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;
import ru.siobko.testing.tasks.junit.core.main.LoginPage;
import ru.siobko.testing.tasks.junit.core.main.MyProfilePage;
import ru.siobko.testing.tasks.junit.core.settings.SettingsGeneralPage;
import ru.siobko.testing.tasks.junit.core.settings.SettingsGeneralPersonalInformationPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangeUserNameTest extends BaseTest {
    private static final String NEW_USERNAME = "Boris";

    @BeforeAll
    public static void setUp() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(EMAIL, PASSWORD);

        FeedPage feedPage = new FeedPage();
        MyProfilePage myProfilePage = feedPage.openMyProfilePage();
        SettingsGeneralPage settingsGeneralPage = myProfilePage.openProfileSettings();
        settingsGeneralPage.openPersonalInformationPage();
    }

    @Test
    public void testChangeUserName() {
        SettingsGeneralPersonalInformationPage personalDataPage = new SettingsGeneralPersonalInformationPage();
        personalDataPage.changeName(NEW_USERNAME);
        Selenide.refresh();

        assertTrue(
                personalDataPage.checkProfileNameContains(NEW_USERNAME),
                "Incorrect name change."
        );
    }

    @AfterAll
    public static void tearDown() {
        SettingsGeneralPage settingsGeneralPage = new SettingsGeneralPage();
        SettingsGeneralPersonalInformationPage personalDataPage = settingsGeneralPage.openPersonalInformationPage();
        personalDataPage.changeName(EMAIL);
    }
}
