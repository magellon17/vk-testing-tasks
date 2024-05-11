package ru.siobko.testing.tasks.patterns.tests.main.groupsPage;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.groups.GroupsMainPage;
import ru.siobko.testing.tasks.patterns.core.main.group.MyGroupMainPage;
import ru.siobko.testing.tasks.patterns.core.main.user.MyUserMainPage;
import ru.siobko.testing.tasks.patterns.models.group.Group;
import ru.siobko.testing.tasks.patterns.models.group.GroupTopic;
import ru.siobko.testing.tasks.patterns.models.group.GroupType;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupCreationTest {
    private static final Logger log = LoggerFactory.getLogger(GroupCreationTest.class);
    private static final Group group1 = new Group(GroupType.BY_INTERESTS, GroupTopic.CARS, RandomString.make(10));
    private static final Group group2 = new Group(GroupType.BUSINESS, GroupTopic.CAR_WASH, RandomString.make(10));

    @BeforeAll
    public static void openGroupsPage() {
        log.info("Откроем страницу с группами.");
        new MyUserMainPage().openGroupsPage();
    }

    @ParameterizedTest(name = "Группа: {0}")
    @ArgumentsSource(GroupsParams.class)
    public void testGroupCreation(Group group) {
        log.info("Создаем группу.");
        MyGroupMainPage myGroupMainPage = new GroupsMainPage()
                .clickCreateGroup()
                .selectGroupType(group.type())
                .enterGroupName(group.name())
                .expandCategoriesList()
                .selectGroupCategory(group.topic())
                .clickCreate();
        assertAll(
                "Проверка названия и категории группы",
                () -> assertEquals(myGroupMainPage.getGroupName(), group.name(),
                        "Название группы не совпало с ожидаемым."),
                () -> assertEquals(myGroupMainPage.getGroupCategory(), group.topic().toString(),
                        "Категория группы не совпала с ожидаемым.")
        );
    }

    @AfterEach
    public void deleteGroup() {
        log.info("Удаляем группу");
        new MyGroupMainPage()
                .dropdownActionsMenu()
                .clickOnDelete()
                .confirmDeletion();
    }

    static class GroupsParams implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(group1),
                    Arguments.of(group2)
            );
        }
    }
}
