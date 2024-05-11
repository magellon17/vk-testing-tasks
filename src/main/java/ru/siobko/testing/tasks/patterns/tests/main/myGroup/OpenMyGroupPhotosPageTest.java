package ru.siobko.testing.tasks.patterns.tests.main.myGroup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.patterns.tests.main.BaseMainTest;

@Tag("openMyGroupPage")
public class OpenMyGroupPhotosPageTest extends BaseMainTest {
    private final OpenMyGroupPagesSteps steps = new OpenMyGroupPagesSteps();

    @BeforeEach
    public void beforeTest() {
        steps.prepareTest();
    }

    @Test
    public void testOpenPhotosPage() {
        steps.openPhotosPageAndCheckPage();
    }
}
