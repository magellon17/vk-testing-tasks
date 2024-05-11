package ru.siobko.testing.tasks.patterns.tests.main.myGroupPage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.patterns.tests.main.BaseMainTest;

@Tag("openMyGroupPages")
public class OpenMyGroupMembersPageTest extends BaseMainTest {
    private final OpenMyGroupPagesSteps steps = new OpenMyGroupPagesSteps();

    @BeforeEach
    public void beforeTest() {
        steps.prepareTest();
    }

    @Test
    public void testOpenMembersPage() {
        steps.openMembersPageAndCheckPage();
    }

    @BeforeEach
    public void afterTest() {
        steps.tearDown();
    }
}
