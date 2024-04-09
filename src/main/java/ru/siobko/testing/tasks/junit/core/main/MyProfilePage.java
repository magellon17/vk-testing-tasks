package ru.siobko.testing.tasks.junit.core.main;

import org.openqa.selenium.By;
import ru.siobko.testing.tasks.junit.core.settings.SettingsBasicPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MyProfilePage extends BaseMainPage {
    private static final By settingsButton = byXpath(".//li[@data-l='outlandertarget,settings,t,settings']");
    private static final By profileFeed = byXpath(".//div[@data-block='UserFeed']");
    private static final By lastFeedPostText = byClassName("media-text_cnt");
    private static final By lastFeedPostActionsMenu = byXpath(".//div[@data-l='t,feed-actions-menu']");
    private static final By feedFilterMenu = byXpath(".//div[@data-l='t,filter']");
    private static final By navigationMenu = byXpath(".//nav[@data-l='t,horizontalNavigation']");

    public MyProfilePage() {
        checkPage();
    }

    public static boolean checkPage() {
        $(feedFilterMenu).shouldBe(visible);
        $(navigationMenu).shouldBe(visible);
        $(profileFeed).shouldBe(visible);
        return true;
    }

    public SettingsBasicPage openProfileSettings() {
        $(settingsButton).click();
        return new SettingsBasicPage();
    }

    public boolean checkLastFeedPostContains(String s) {
        return $(lastFeedPostText)
                .getText()
                .contains(s);
    }

    public void deleteLastTextPost() {
        $(lastFeedPostActionsMenu)
                .shouldBe(visible)
                .scrollIntoView("{block: \"center\"}")
                .hover();
        $(byXpath(".//*[text()='Удалить заметку']")).shouldBe(visible).click();
    }
}
