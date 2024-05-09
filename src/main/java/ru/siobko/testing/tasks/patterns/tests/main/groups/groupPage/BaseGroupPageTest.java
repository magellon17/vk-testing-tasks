package ru.siobko.testing.tasks.patterns.tests.main.groups.groupPage;

import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.groups.GroupsPage;
import ru.siobko.testing.tasks.patterns.tests.main.groups.BaseGroupsTest;

public class BaseGroupPageTest extends BaseGroupsTest {
    private static final Logger TESTLOG = LoggerFactory.getLogger(BaseGroupPageTest.class);

    @BeforeAll
    public static void createGroup() {
        TESTLOG.info("Создаем группу.");
        new GroupsPage()
                .clickCreateGroup()
                .clickGroupByInterest()
                .enterGroupName(GROUP_NAME_ON_ENGLISH)
                .expandThematicsList()
                .clickAutoThematic()
                .clickCreate();
    }
}
