package ru.siobko.testing.tasks.junit.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;
import ru.siobko.testing.tasks.junit.core.login.LoginPage;
import ru.siobko.testing.tasks.junit.core.settings.SettingsGeneralPage;
import ru.siobko.testing.tasks.junit.core.settings.SettingsGeneralPersonalInformationPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("settings")
public class ChangeUserNameTest extends BaseTest {
    private static final String NEW_USERNAME = "Boris";

    @BeforeAll
    public static void login() {
        FeedPage feedPage = new LoginPage()
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickSubmit();
        feedPage.openMyProfilePage()
                .openProfileSettings()
                .openPersonalInformationPage();
    }

    @Test
    public void testChangeUserName() {
        SettingsGeneralPersonalInformationPage personalDataPage = new SettingsGeneralPersonalInformationPage();
        personalDataPage
                .enterName(NEW_USERNAME)
                .clickSubmit();
        Selenide.refresh();
        personalDataPage = new SettingsGeneralPage().openPersonalInformationPage();
        assertTrue(personalDataPage.checkProfileNameContains(NEW_USERNAME),
                "Incorrect name change."
        );
    }

    @AfterAll
    public static void returnUsername() {
        SettingsGeneralPersonalInformationPage personalDataPage = new SettingsGeneralPersonalInformationPage();
        personalDataPage
                .enterName(EMAIL)
                .clickSubmit();
    }
}
