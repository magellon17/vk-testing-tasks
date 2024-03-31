package ru.siobko.testing.tasks.selenide.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MyProfilePage extends BasePage {
    private static final SelenideElement profileFeed = $(byXpath(".//*[@data-l='fL,self']"));
    private static final SelenideElement lastFeedPost = profileFeed.$(byClassName("feed-w"));
    private static final SelenideElement lastFeedPostText = lastFeedPost.$(byClassName("media-text_cnt"));

    public MyProfilePage() {
        checkPage();
    }

    private void checkPage() {
    }

    public SelenideElement getLastFeedPost() {
        return lastFeedPost;
    }

    public SettingsBasicPage openProfileSettings() {
        return new SettingsBasicPage();
    }

    public SelenideElement getLastFeedPostText() {
        return lastFeedPostText;
    }
}
