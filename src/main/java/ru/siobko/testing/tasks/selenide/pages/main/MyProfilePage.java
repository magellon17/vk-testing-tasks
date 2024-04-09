package ru.siobko.testing.tasks.selenide.pages.main;

import com.codeborne.selenide.SelenideElement;
import ru.siobko.testing.tasks.selenide.pages.settings.SettingsBasicPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MyProfilePage extends BaseMainPage {
    private final SelenideElement settingsButton = $(byXpath(".//li[@data-l='outlandertarget,settings,t,settings']"));
    private final SelenideElement profileFeed = $(byXpath(".//div[@data-block='UserFeed']"));
    private final SelenideElement lastFeedPost = profileFeed.$(byClassName("feed-w"));
    private final SelenideElement lastFeedPostText = lastFeedPost.$(byClassName("media-text_cnt"));
    private final SelenideElement feedFilterMenu = $(byXpath(".//div[@data-l='t,filter']"));
    private final SelenideElement navigationMenu = $(byXpath(".//nav[@data-l='t,horizontalNavigation']"));

    public MyProfilePage() {
        checkPage();
    }

    private void checkPage() {
        feedFilterMenu.shouldBe(visible);
        navigationMenu.shouldBe(visible);
        profileFeed.shouldBe(visible);
    }

    public SelenideElement getLastFeedPost() {
        return lastFeedPost;
    }

    public SettingsBasicPage openProfileSettings() {
        settingsButton.click();
        return new SettingsBasicPage();
    }

    public String getLastFeedPostText() {
        return lastFeedPostText.getText();
    }
}