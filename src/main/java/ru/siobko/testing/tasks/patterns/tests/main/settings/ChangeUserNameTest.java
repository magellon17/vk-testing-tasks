package ru.siobko.testing.tasks.patterns.tests.main.settings;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.user.feed.MyProfileMainPage;
import ru.siobko.testing.tasks.patterns.core.settings.SettingsGeneralPage;
import ru.siobko.testing.tasks.patterns.core.settings.SettingsGeneralPersonalInformationPage;
import ru.siobko.testing.tasks.patterns.tests.main.BaseMainTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("settings")
public class ChangeUserNameTest extends BaseMainTest {
    private static final Logger TESTLOG = LoggerFactory.getLogger(ChangeUserNameTest.class);

    private static final String NEW_USERNAME = "Boris";

    @BeforeAll
    public static void openPersonalInformationPage() {
        TESTLOG.info("Откываем страницу с настройкой личной информации.");
        new MyProfileMainPage()
                .openMyProfilePage()
                .openProfileSettings()
                .openPersonalInformationPage();
    }

    @Test
    @DisplayName("Проверка смены имени пользователя.")
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
