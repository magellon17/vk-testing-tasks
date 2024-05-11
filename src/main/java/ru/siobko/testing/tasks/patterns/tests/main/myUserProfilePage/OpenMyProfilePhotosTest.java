package ru.siobko.testing.tasks.patterns.tests.main.myUserProfilePage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("myUserProfilePage")
public class OpenMyProfilePhotosTest extends OpenMyProfilePagesSteps {

    private final OpenMyProfilePagesSteps steps = new OpenMyProfilePagesSteps();

    @BeforeEach
    public void beforeTest() {
        steps.prepareTest();
    }

    @Test
    public void testOpenMyProfilePhotos() {
        steps.openMyProfilePhotosPageAndCheckPage();
    }
}
