package ru.siobko.testing.tasks.patterns.tests.main.myGroupPage;

import org.junit.jupiter.api.*;
import ru.siobko.testing.tasks.patterns.tests.main.BaseMainTest;

@Tag("openMyGroupPages")
public class OpenMyGroupMembersPageTest extends BaseMainTest {
    private final OpenMyGroupPagesSteps steps = new OpenMyGroupPagesSteps();

    @BeforeEach
    public void beforeTest() {
        steps.prepareTest();
    }

    @Test
    public void testOpenMyGroupMembersPage() {
        steps.openMyGroupMembersPageAndCheckPage();
    }

    @AfterEach
    public void afterTest() {
        steps.removeGroupFromGroupMembersPage();
    }
}
