package ru.siobko.testing.tasks.patterns.core.main.user;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.elements.publish.PublishingMenuForm;
import ru.siobko.testing.tasks.patterns.core.main.elements.SideNavigationBlock;
import ru.siobko.testing.tasks.patterns.core.main.elements.myUserCard.MyUserCardToolBar;
import ru.siobko.testing.tasks.patterns.core.main.groups.GroupsMainPage;
import ru.siobko.testing.tasks.patterns.core.main.user.profile.MyUserProfilePage;
import ru.siobko.testing.tasks.patterns.core.media.photo.PhotoLayer;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

import static com.codeborne.selenide.Selectors.byXpath;

public class MyUserMainPage {

    private static final Logger log = LoggerFactory.getLogger(MyUserMainPage.class);

    private final SideNavigationBlock sideNavigationBlock = new SideNavigationBlock();

    private static final By USER_CARD_TOOLBAR_DROPDOWN = byXpath(".//button[@aria-label='Настройки профиля']");
    private static final By PUBLISH_BUTTON = byXpath(".//button[@data-testid='ddm-button']");
    private static final By OPEN_PUBLISHED_PHOTO_BUTTON = byXpath(".//up-photo-midget[@data-l='t,view-photo']");
    private static final By FEED_WRAPPER = byId("hook_Block_MainFeedsWrapper");

    public MyUserMainPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(FEED_WRAPPER).shouldBe(
                visible.because("Не отобразилась лента пользователя"));
        return true;
    }

    public GroupsMainPage openGroupsPage() {
        log.info("Переходим на страницу с группами.");
        sideNavigationBlock.clickOnGroups();
        return new GroupsMainPage();
    }

    public MyUserProfilePage openProfilePage() {
        log.info("Переходим на страницу профиля.");
        sideNavigationBlock.clickOnMyProfile();
        return new MyUserProfilePage();
    }

    public PublishingMenuForm clickPublish() {
        log.info("Кликаем на кнопку 'Опубликовать'.");
        $(PUBLISH_BUTTON).shouldBe(
                visible.because("Нет кнопки 'Опубликовать'.")
        ).click();
        return new PublishingMenuForm();
    }

    public MyUserCardToolBar expandUserCardToolbar() {
        log.info("Открываем карточку пользователя");
        $(USER_CARD_TOOLBAR_DROPDOWN).shouldBe(
                visible.because("Нет карточки пользователя на странице.")
        ).click();
        return new MyUserCardToolBar();
    }

    public PhotoLayer openPhoto() {
        log.info("Открываем фото.");
        $(OPEN_PUBLISHED_PHOTO_BUTTON).shouldBe(
                visible.because("Не найдено фото.")
        ).click();
        return new PhotoLayer();
    }

    public boolean checkProfileNameContains(String name) {
        return sideNavigationBlock.checkProfileNameContains(name);
    }
}
