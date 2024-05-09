package ru.siobko.testing.tasks.patterns.tests.main.profiles.myProfilePage;

import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.myProfile.MyProfileFeedPage;
import ru.siobko.testing.tasks.patterns.tests.main.BaseMainTest;

public class BaseMyProfilePageTest extends BaseMainTest {
    private static final Logger TESTLOG = LoggerFactory.getLogger(BaseMyProfilePageTest.class);

    @BeforeAll
    public static void openMyProfilePage() {
        TESTLOG.info("Открываем страницу моего профиля.");
        new MyProfileFeedPage().openMyProfilePage();
    }
}
