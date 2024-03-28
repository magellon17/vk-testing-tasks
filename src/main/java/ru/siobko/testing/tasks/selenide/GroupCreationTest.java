package ru.siobko.testing.tasks.selenide;

import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.selenide.pages.FeedPage;
import ru.siobko.testing.tasks.selenide.pages.GroupPage;
import ru.siobko.testing.tasks.selenide.pages.GroupsPage;
import ru.siobko.testing.tasks.selenide.pages.LoginPage;

import static com.codeborne.selenide.Condition.visible;

public class GroupCreationTest extends BaseTest {
    @Test
    public void testGroupCreation() {
        LoginPage loginPage = new LoginPage();
        loginPage.open().login(email, password);

        FeedPage feedPage = new FeedPage();
        GroupsPage groupsPage = feedPage.openGroupPage();
        GroupPage groupPage = groupsPage.createGroup("myGroup1");

        groupPage.members.shouldBe(visible);
    }
}
