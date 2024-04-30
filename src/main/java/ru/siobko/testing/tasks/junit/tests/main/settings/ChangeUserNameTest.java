package ru.siobko.testing.tasks.junit.tests.main.settings;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;
import ru.siobko.testing.tasks.junit.core.settings.SettingsGeneralPage;
import ru.siobko.testing.tasks.junit.core.settings.SettingsGeneralPersonalInformationPage;
import ru.siobko.testing.tasks.junit.tests.main.BaseMainTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("settings")
public class ChangeUserNameTest extends BaseMainTest {
    private static final String NEW_USERNAME = "Boris";

    @BeforeAll
    public static void openPersonalInformationPage() {
        new FeedPage().openMyProfilePage()
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
                .enterName(BOT.getLogin())
                .clickSubmit();
    }
}
