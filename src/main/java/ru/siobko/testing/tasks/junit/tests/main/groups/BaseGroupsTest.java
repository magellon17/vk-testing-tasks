package ru.siobko.testing.tasks.junit.tests.main.groups;

import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.junit.core.main.profile.myProfile.MyProfileFeedPage;
import ru.siobko.testing.tasks.junit.tests.main.BaseMainTest;

public abstract class BaseGroupsTest extends BaseMainTest {
    private static final Logger TESTLOG = LoggerFactory.getLogger(BaseGroupsTest.class);

    protected static final String GROUP_NAME_ON_ENGLISH = "my Group";
    protected static final String GROUP_NAME_ON_RUSSIAN = "моя Группа";

    @BeforeAll
    public static void openGroupsPage() {
        TESTLOG.info("Открываем страницу с группами.");
        new MyProfileFeedPage().openGroupsPage();
    }
}
