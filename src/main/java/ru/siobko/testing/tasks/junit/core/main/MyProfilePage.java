package ru.siobko.testing.tasks.junit.core.main;

import org.openqa.selenium.By;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.siobko.testing.tasks.junit.core.settings.SettingsGeneralPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MyProfilePage extends BaseMainPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyProfilePage.class);
    private static final By SETTINGS_BUTTON = byXpath(".//li[@data-l='outlandertarget,settings,t,settings']");
    private static final By PROFILE_FEED = byXpath(".//div[@data-block='UserFeed']");
    private static final By LAST_FEED_POST_TEXT = byClassName("media-text_cnt");
    private static final By LAST_FEED_POST_ACTIONS_MENU = byXpath(".//div[@data-l='t,feed-actions-menu']");
    private static final By FEED_FILTER_MENU = byXpath(".//div[@data-l='t,filter']");
    private static final By PROFILE_NAVIGATION_MENU = byXpath(".//nav[@data-l='t,horizontalNavigation']");
    private static final By DELETE_NOTE_BUTTON = byXpath(".//*[text()='Удалить заметку']");
    private static final By CONFIRM_DELETION_BUTTON = byXpath(".//a[text()='Удалить заметку']");

    public MyProfilePage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        $(FEED_FILTER_MENU).shouldBe(
                visible.because("Feed filter menu should be visible on my profile page.")
        );
        $(PROFILE_NAVIGATION_MENU).shouldBe(
                visible.because("Navigation menu of profile feed should be visible on my profile page.")
        );
        $(PROFILE_FEED).shouldBe(
                visible.because("Profile feed should be visible on my profile page.")
        );
        LOGGER.info("Перешли на страницу профиля");
        return true;
    }

    public SettingsGeneralPage openProfileSettings() {
        LOGGER.info("Открываем настройки профиля.");
        $(SETTINGS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка настроек.")
        ).click();
        return new SettingsGeneralPage();
    }

    public boolean checkLastFeedPostContains(String text) {
        return $(LAST_FEED_POST_TEXT).shouldBe(
                        visible.because("Нет последнего текстового поста.")
                ).getText()
                .contains(text);
    }

    public MyProfilePage hoverLastFeedPostActionsMenu() {
        LOGGER.info("Наводим курсор на меню действий текстового поста.");
        $(LAST_FEED_POST_ACTIONS_MENU).shouldBe(
                        visible.because("Не отобразилось меню действий текстового поста.")
                ).scrollIntoView("{block: \"center\"}")
                .hover();
        return this;
    }

    public MyProfilePage clickDeleteNote() {
        LOGGER.info("Удаляем заметку.");
        $(DELETE_NOTE_BUTTON).shouldBe(
                visible.because("Button 'Удалить заметку' should be visible on post actions menu.")
        ).click();
        return this;
    }

    public void confirmDeletion() {
        LOGGER.info("Подтверждаем удаление заметки.");
        $(CONFIRM_DELETION_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка подтверждения удаления.")
        ).click();
    }
}
