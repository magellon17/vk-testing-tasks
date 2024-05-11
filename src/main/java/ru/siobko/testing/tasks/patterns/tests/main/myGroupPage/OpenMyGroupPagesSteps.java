package ru.siobko.testing.tasks.patterns.tests.main.myGroupPage;

import net.bytebuddy.utility.RandomString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.group.MyGroupMainPage;
import ru.siobko.testing.tasks.patterns.core.main.group.members.GroupMembersPage;
import ru.siobko.testing.tasks.patterns.core.main.group.photos.GroupPhotosPage;
import ru.siobko.testing.tasks.patterns.core.main.groups.GroupsMainPage;
import ru.siobko.testing.tasks.patterns.core.main.user.MyUserMainPage;
import ru.siobko.testing.tasks.patterns.models.group.Group;
import ru.siobko.testing.tasks.patterns.models.group.GroupTopic;
import ru.siobko.testing.tasks.patterns.models.group.GroupType;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenMyGroupPagesSteps {
    private static final Logger log = LoggerFactory.getLogger(OpenMyGroupPagesSteps.class);
    private static final Group group = new Group(GroupType.BY_INTERESTS, GroupTopic.CARS, RandomString.make(10));

    public void prepareTest() {
        log.info("Открываем главную страницу с группами");
        GroupsMainPage groupsMainPage = new MyUserMainPage().openGroupsPage();
        log.info("Создаем группу");
        groupsMainPage
                .clickCreateGroup()
                .selectGroupType(group.type())
                .enterGroupName(group.name())
                .expandCategoriesList()
                .selectGroupCategory(group.topic())
                .clickCreate();
    }

    public void openMembersPageAndCheckPage() {
        log.info("Открываем страницу с участниками группы.");
        GroupMembersPage groupMembersPage = new MyGroupMainPage()
                .openGroupMembersPage();
        assertTrue(groupMembersPage.checkPage(),
                "Не открылась страница с участниками группы."
        );
    }

    public void openPhotosPageAndCheckPage() {
        log.info("Открываем страницу с фотками группы.");
        GroupPhotosPage groupPhotosPage = new MyGroupMainPage()
                .openGroupPhotosPage();
        assertTrue(groupPhotosPage.checkPage(),
                "Не открылась страница с фотками группы."
        );
    }
}
