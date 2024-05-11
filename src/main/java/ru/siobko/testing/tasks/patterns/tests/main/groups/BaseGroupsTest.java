package ru.siobko.testing.tasks.patterns.tests.main.groups;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.user.MyUserMainPage;
import ru.siobko.testing.tasks.patterns.tests.main.BaseMainTest;

public abstract class BaseGroupsTest extends BaseMainTest {
    private static final Logger log = LoggerFactory.getLogger(BaseGroupsTest.class);

    @BeforeAll
    public static void openGroupsPage() {
        log.info("Открываем страницу с группами.");
        new MyUserMainPage().openGroupsPage();
    }
}
