package ru.siobko.testing.tasks.junit.core.main.profile.myProfile;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.junit.core.main.profile.BaseProfilePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MyProfileFriendsPage extends BaseProfilePage {
    private static final Logger LOG = LoggerFactory.getLogger(MyProfileFriendsPage.class);

    private static final By FRIEND_REQUESTS_BUTTON = byXpath(".//a[@data-l='t,userFriendRequest']");
    private static final By FRIEND_SUGGESTS_BUTTON = byXpath(".//a[@data-l='t,userFriendSuggest']");

    public MyProfileFriendsPage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        $(FRIEND_REQUESTS_BUTTON).shouldBe(
                visible.because("Feed filter menu should be visible on my profile page.")
        );
        $(FRIEND_SUGGESTS_BUTTON).shouldBe(
                visible.because("Navigation menu of profile feed should be visible on my profile page.")
        );
        LOG.info("Перешли на страницу друзей моего профиля.");
        return true;
    }
}
