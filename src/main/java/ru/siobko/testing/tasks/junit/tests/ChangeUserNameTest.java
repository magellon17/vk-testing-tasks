package ru.siobko.testing.tasks.junit.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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
        FeedPage feedPage = new LoginPage().login(EMAIL, PASSWORD);
        feedPage.openMyProfilePage()
                .openProfileSettings()
                .openPersonalInformationPage();
    }

    @ParameterizedTest
    @ValueSource(strings = {NEW_USERNAME})
    public void testChangeUserName(String username) {
        SettingsGeneralPersonalInformationPage personalDataPage = new SettingsGeneralPersonalInformationPage();
        personalDataPage.changeName(username);

        Selenide.refresh();

        personalDataPage = new SettingsGeneralPage().openPersonalInformationPage();
        assertTrue(
                personalDataPage.checkProfileNameContains(username),
                "Incorrect name change."
        );
    }

    @AfterAll
    public static void returnUsername() {
        SettingsGeneralPersonalInformationPage personalDataPage = new SettingsGeneralPersonalInformationPage();
        personalDataPage.changeName(EMAIL);
    }
}
