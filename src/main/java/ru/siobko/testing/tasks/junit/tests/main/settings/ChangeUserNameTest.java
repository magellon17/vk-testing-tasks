package ru.siobko.testing.tasks.junit.tests.main.settings;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.junit.core.main.profile.myProfile.MyProfileFeedPage;
import ru.siobko.testing.tasks.junit.core.settings.SettingsGeneralPage;
import ru.siobko.testing.tasks.junit.core.settings.SettingsGeneralPersonalInformationPage;
import ru.siobko.testing.tasks.junit.tests.main.BaseMainTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("settings")
public class ChangeUserNameTest extends BaseMainTest {
    private static final Logger TESTLOG = LoggerFactory.getLogger(ChangeUserNameTest.class);

    private static final String NEW_USERNAME = "Boris";

    @BeforeAll
    public static void openPersonalInformationPage() {
        TESTLOG.info("Откываем страницу с настройкой личной информации.");
        new MyProfileFeedPage()
                .openMyProfilePage()
                .openProfileSettings()
                .openPersonalInformationPage();
    }

    @Test
    public void testChangeUserName() {
        TESTLOG.info("Меняем имя пользователя.");
        SettingsGeneralPersonalInformationPage personalDataPage = new SettingsGeneralPersonalInformationPage();
        personalDataPage
                .enterName(NEW_USERNAME)
                .clickSubmit();
        Selenide.refresh();
        personalDataPage = new SettingsGeneralPage().openPersonalInformationPage();
        assertTrue(personalDataPage.checkProfileNameContains(NEW_USERNAME),
                "Новое имя пользователя не совпадает с ожидаемым."
        );
    }

    @AfterAll
    public static void returnUsername() {
        TESTLOG.info("Возвращаем изначальное имя пользователя.");
        new SettingsGeneralPersonalInformationPage()
                .enterName(BOT.getLogin())
                .clickSubmit();
    }
}
