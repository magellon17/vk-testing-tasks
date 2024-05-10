package ru.siobko.testing.tasks.patterns.tests.main.groups.actions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.user.MyProfileMainPage;
import ru.siobko.testing.tasks.patterns.core.main.groups.GroupsMainPage;
import ru.siobko.testing.tasks.patterns.core.main.group.MyGroupMainPage;
import ru.siobko.testing.tasks.patterns.models.group.Group;
import ru.siobko.testing.tasks.patterns.models.group.GroupCategory;
import ru.siobko.testing.tasks.patterns.models.group.GroupType;
import ru.siobko.testing.tasks.patterns.tests.main.groups.BaseGroupsTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Создание группы")
@Tag("groups")
public class GroupCreationTest extends BaseGroupsTest {
    private static final Logger TESTLOG = LoggerFactory.getLogger(GroupCreationTest.class);
    private static final Group group1 = new Group(GroupType.BY_INTERESTS, GroupCategory.CARS, GROUP_NAME_ON_ENGLISH);
    private static final Group group2 = new Group(GroupType.BUSINESS, GroupCategory.CAR_WASH, GROUP_NAME_ON_RUSSIAN);

    @BeforeAll
    public static void openGroupsPage() {
        TESTLOG.info("Откроем страницу с группами.");
        new MyProfileMainPage().openGroupsPage();
    }

    @DisplayName("Проверка создания группы")
    @ParameterizedTest(name = "Группа: {0}")
    @ArgumentsSource(Params.class)
    public void testGroupCreation(Group group) {
        TESTLOG.info("Создаем группу.");
        MyGroupMainPage myGroupMainPage = new GroupsMainPage()
                .clickCreateGroup()
                .selectGroupType(group.type())
                .enterGroupName(group.name())
                .expandCategoriesList()
                .selectGroupCategory(group.category())
                .clickCreate();
        assertEquals(myGroupMainPage.getGroupName(),group.name(),
                "Название группы не совпало с ожидаемым."
        );
    }

    @AfterEach
    public void deleteGroup() {
        TESTLOG.info("Удаляем группу.");
        new MyGroupMainPage()
                .clickMoreActions()
                .clickDelete()
                .confirmDeletion();
    }

    static class Params implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(group1),
                    Arguments.of(group2)
            );
        }
    }
}
