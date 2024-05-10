package ru.siobko.testing.tasks.patterns.tests.main.groups.actions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.user.MyProfileMainPage;
import ru.siobko.testing.tasks.patterns.core.main.groups.GroupsPage;
import ru.siobko.testing.tasks.patterns.core.main.group.MyGroupMainPage;
import ru.siobko.testing.tasks.patterns.tests.main.groups.BaseGroupsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Создание группы")
@Tag("groups")
public class GroupCreationTest extends BaseGroupsTest {
    private static final Logger TESTLOG = LoggerFactory.getLogger(GroupCreationTest.class);

    @BeforeAll
    public static void openGroupsPage() {
        TESTLOG.info("Откроем страницу с группами.");
        new MyProfileMainPage().openGroupsPage();
    }

    @DisplayName("Проверка создания группы")
    @ParameterizedTest(name = "Группы с именем: {0}")
    @ValueSource(strings = {GROUP_NAME_ON_ENGLISH, GROUP_NAME_ON_RUSSIAN})
    public void testGroupCreation(String groupName) {
        TESTLOG.info("Создаем группу.");
        MyGroupMainPage myGroupMainPage = new GroupsPage()
                .clickCreateGroup()
                .clickGroupByInterest()
                .enterGroupName(groupName)
                .expandThematicsList()
                .clickAutoThematic()
                .clickCreate();
        assertEquals(myGroupMainPage.getGroupName(),groupName,
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
}
