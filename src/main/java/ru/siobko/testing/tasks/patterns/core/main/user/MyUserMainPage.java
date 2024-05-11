package ru.siobko.testing.tasks.patterns.core.main.user;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.elements.publish.PublishingMenuForm;
import ru.siobko.testing.tasks.patterns.core.main.elements.SideNavigationBlock;
import ru.siobko.testing.tasks.patterns.core.main.elements.UserCardToolBar;
import ru.siobko.testing.tasks.patterns.core.main.groups.GroupsMainPage;
import ru.siobko.testing.tasks.patterns.core.media.photo.PhotoLayer;
import ru.siobko.testing.tasks.patterns.core.media.PostLayer;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import static com.codeborne.selenide.Selectors.byXpath;

public class MyUserMainPage {
    private static final Logger LOG = LoggerFactory.getLogger(MyUserMainPage.class);
    private final SideNavigationBlock sideNavigationBlock = new SideNavigationBlock();
    private static final By USER_CARD_TOOLBAR_DROPDOWN = byXpath(".//button[@aria-label='Настройки профиля']");
    private static final By PUBLISH_BUTTON = byXpath(".//button[@data-testid='ddm-button']");
    private static final By OPEN_PUBLISHED_POST_BUTTON = byXpath(".//a[@class='js-tip-block-url al']");
    private static final By OPEN_PUBLISHED_PHOTO_BUTTON = byXpath(".//up-photo-midget[@data-l='t,view-photo']");

    public MyUserMainPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(PUBLISH_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка публикации.")
        );
        return true;
    }

    public GroupsMainPage openGroupsPage() {
        LOG.info("Переходим на страницу с группами.");
        sideNavigationBlock.clickOnGroups();
        return new GroupsMainPage();
    }

    public MyUserProfilePage openProfilePage() {
        LOG.info("Переходим на страницу профиля.");
        sideNavigationBlock.clickOnMyProfile();
        return new MyUserProfilePage();
    }

    public PublishingMenuForm clickPublish() {
        LOG.info("Кликаем на кнопку 'Опубликовать'.");
        $(PUBLISH_BUTTON).shouldBe(
                visible.because("Нет кнопки 'Опубликовать'.")
        ).click();
        return new PublishingMenuForm();
    }

    public UserCardToolBar expandUserCardToolbar() {
        LOG.info("Открываем карточку пользователя");
        $(USER_CARD_TOOLBAR_DROPDOWN).shouldBe(
                visible.because("Нет карточки пользователя на странице.")
        ).click();
        return new UserCardToolBar();
    }

    public PostLayer openPost() {
        LOG.info("Открываем пост.");
        $(OPEN_PUBLISHED_POST_BUTTON).shouldBe(
                visible.because("Не найден пост.")
        ).click();
        return new PostLayer();
    }

    public PhotoLayer openPhoto() {
        LOG.info("Открываем фото.");
        $(OPEN_PUBLISHED_PHOTO_BUTTON).shouldBe(
                visible.because("Не найдено фото.")
        ).click();
        return new PhotoLayer();
    }

    public boolean checkProfileNameContains(String name) {
        return sideNavigationBlock.checkProfileNameContains(name);
    }
}
