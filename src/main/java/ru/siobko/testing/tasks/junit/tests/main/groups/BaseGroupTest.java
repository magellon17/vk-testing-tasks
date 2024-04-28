package ru.siobko.testing.tasks.junit.tests.main.groups;

import org.junit.jupiter.api.BeforeAll;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;
import ru.siobko.testing.tasks.junit.tests.main.BaseMainTest;

public abstract class BaseGroupTest extends BaseMainTest {
    protected static final String GROUP_NAME_ON_ENGLISH = "my Group";
    protected static final String GROUP_NAME_ON_RUSSIAN = "моя Группа";

    @BeforeAll
    public static void openGroupsPage() {
        new FeedPage().openGroupsPage();
    }
}
