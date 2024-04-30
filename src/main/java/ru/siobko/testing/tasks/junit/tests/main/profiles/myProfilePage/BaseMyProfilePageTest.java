package ru.siobko.testing.tasks.junit.tests.main.profiles.myProfilePage;

import org.junit.jupiter.api.BeforeAll;
import ru.siobko.testing.tasks.junit.core.main.profile.myProfile.MyProfileFeedPage;
import ru.siobko.testing.tasks.junit.tests.main.BaseMainTest;

public class BaseMyProfilePageTest extends BaseMainTest {
    @BeforeAll
    public static void openMyProfilePage() {
        new MyProfileFeedPage().openMyProfilePage();
    }
}
