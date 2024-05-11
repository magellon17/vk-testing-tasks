package ru.siobko.testing.tasks.patterns.tests.main.myGroup;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.groups.GroupsMainPage;
import ru.siobko.testing.tasks.patterns.models.group.Group;
import ru.siobko.testing.tasks.patterns.models.group.GroupTopic;
import ru.siobko.testing.tasks.patterns.models.group.GroupType;
import ru.siobko.testing.tasks.patterns.tests.main.groups.BaseGroupsTest;

public class BaseGroupPageTest extends BaseGroupsTest {
    private static final Logger TESTLOG = LoggerFactory.getLogger(BaseGroupPageTest.class);
    private static final Group group = new Group(GroupType.BY_INTERESTS, GroupTopic.CARS, RandomString.make(10));

    @BeforeAll
    public static void createGroup() {
        TESTLOG.info("Создаем группу.");
        new GroupsMainPage()
                .clickCreateGroup()
                .selectGroupType(group.type())
                .enterGroupName(group.name())
                .expandCategoriesList()
                .selectGroupCategory(group.topic())
                .clickCreate();
    }
}
