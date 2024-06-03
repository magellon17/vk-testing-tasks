package ru.siobko.testing.tasks.patterns.tests.main.myGroupPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.patterns.tests.main.RequiredLoginTest;

@Tag("openMyGroupPages")
public class OpenMyGroupPhotosPageTest extends RequiredLoginTest {

    private final OpenMyGroupPagesSteps steps = new OpenMyGroupPagesSteps();

    @BeforeEach
    public void beforeTest() {
        steps.prepareTest();
    }

    @Test
    public void testOpenPhotosPage() {
        steps.openMyGroupPhotosPageAndCheckPage();
    }

    @AfterEach
    public void afterTest() {
        steps.removeGroupFromGroupPhotosPage();
    }
}
