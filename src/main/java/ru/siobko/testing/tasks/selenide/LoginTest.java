package ru.siobko.testing.tasks.selenide;

import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.selenide.pages.LoginPage;
import ru.siobko.testing.tasks.selenide.pages.FeedPage;

import static com.codeborne.selenide.Condition.visible;

public class LoginTest extends BaseTest {
    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage();
        FeedPage feedPage = loginPage.open().login(email, password);

        feedPage.navigationPanel.shouldBe(visible);
        feedPage.possibleFriendsList.shouldBe(visible);
        feedPage.onlineFriendsList.shouldBe(visible);
        feedPage.navigationToolBar.shouldBe(visible);
        feedPage.profileAvatar.shouldBe(visible);
        feedPage.groupsButton.shouldBe(visible);
        feedPage.friendsButton.shouldBe(visible);
    }
}
