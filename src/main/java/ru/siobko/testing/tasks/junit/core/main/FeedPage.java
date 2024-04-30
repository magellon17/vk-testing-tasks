package ru.siobko.testing.tasks.junit.core.main;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FeedPage extends BaseMainPage {
    private static final Logger LOG = LoggerFactory.getLogger(FeedPage.class);
    private static final By PROFILE_AVATAR = byId("hook_Block_Avatar");
    private static final By ONLINE_FRIENDS_PANEL = byId("online-fr_block");
    private static final By FEED_FILTER_MENU = byXpath(".//hybrid-feed-filter[@data-bundle-name='contents_hybrid-feed-filter']");

    public FeedPage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        $(PROFILE_AVATAR).shouldBe(
                visible.because("Не отобразилась аватарка пользователя.")
        );
        $(FEED_FILTER_MENU).shouldBe(
                visible.because("Не отобразились фильтры ленты.")
        );
        $(ONLINE_FRIENDS_PANEL).shouldBe(
                visible.because("Не отобразилась панель друзей на сайте.")
        );
        LOG.info("Перешли на страницу ленты");
        return true;
    }

    public boolean checkProfileNameContains(String email) {
        return $(MY_PROFILE_BUTTON).shouldBe(
                        visible.because("Не отобразилась кнопка профиля пользователя.")
                ).getText()
                .contains(email);
    }
}
