package ru.siobko.testing.tasks.patterns.core.main;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.BasePage;
import ru.siobko.testing.tasks.patterns.core.login.LoginPage;
import ru.siobko.testing.tasks.patterns.core.main.elements.SideNavigationBlock;
import ru.siobko.testing.tasks.patterns.core.main.elements.UserCardToolBar;
import ru.siobko.testing.tasks.patterns.core.main.groups.GroupsPage;
import ru.siobko.testing.tasks.patterns.core.main.myProfile.MyProfilePage;
import ru.siobko.testing.tasks.patterns.core.media.PhotoLayer;
import ru.siobko.testing.tasks.patterns.core.media.PostLayer;

import java.io.File;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import static com.codeborne.selenide.Selectors.byXpath;

public abstract class BaseMainPage extends BasePage {
    private static final Logger LOG = LoggerFactory.getLogger(BaseMainPage.class);
    private final SideNavigationBlock sideNavigationBlock = new SideNavigationBlock();
    private final UserCardToolBar userCardToolBar = new UserCardToolBar();

    // Публикация
    protected static final By PUBLISH_BUTTON = byXpath(".//button[@data-testid='ddm-button']");
    protected static final By PUBLISH_POST_BUTTON = byXpath(".//*[@class='item-container__7e56q']");
    protected static final By PUBLISH_PHOTO_BUTTON = byXpath(".//input[@accept='image/*, video/*, .heic,']");

    //Страница поста
    protected static final By OPEN_PUBLISHED_POST_BUTTON = byXpath(".//a[@class='js-tip-block-url al']");

    //Страница фото
    protected static final By OPEN_PUBLISHED_PHOTO_BUTTON = byXpath(".//up-photo-midget[@data-l='t,view-photo']");

    //Публикация поста
    protected static final By POST_TEXT_BOX = byXpath(".//div[@data-module='postingForm/mediaText']");
    protected static final By SUBMIT_BUTTON = byXpath(".//button[@data-l='t,button.submit']");

    protected BaseMainPage() {
    }

    @Override
    protected boolean checkPage() {
        $(PUBLISH_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка публикации.")
        );
        return true;
    }

    public GroupsPage openGroupsPage() {
        LOG.info("Переходим на страницу с группами.");
        sideNavigationBlock.clickOnGroups();
        return new GroupsPage();
    }

    public MyProfilePage openMyProfilePage() {
        LOG.info("Переходим на страницу профиля.");
        sideNavigationBlock.clickOnMyProfile();
        return new MyProfilePage();
    }

    public BaseMainPage clickPublish() {
        LOG.info("Кликаем на кнопку 'Опубликовать'.");
        $(PUBLISH_BUTTON).shouldBe(
                visible.because("Нет кнопки 'Опубликовать'.")
        ).click();
        return this;
    }

    public BaseMainPage clickPublishPhoto(String filename) {
        LOG.info("Публикуем фотку.");
        $(PUBLISH_PHOTO_BUTTON).shouldBe(
                exist.because("Не отобразилась кнопка загрзуки фото.")
        ).uploadFile(new File(filename));
        return this;
    }

    public BaseMainPage clickPublishPost() {
        LOG.info("Кликаем на кнопку публикации поста.");
        $(PUBLISH_POST_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка публикации поста.")
        ).click();
        return this;
    }

    public BaseMainPage enterPostText(String postText) {
        LOG.info("Вводим текст поста.");
        $(POST_TEXT_BOX).shouldBe(
                visible.because("Не отобразилось поле ввода текста поста.")
        ).setValue(postText);
        return this;
    }

    public BaseMainPage clickSubmit() {
        LOG.info("Публикуем пост.");
        $(SUBMIT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка подтвержденря публикации поста.")
        ).click();
        return this;
    }

    public BaseMainPage expandUserCardToolbar() {
        LOG.info("Открываем карточку пользователя");
        userCardToolBar.expand();
        return this;
    }

    public BaseMainPage logout() {
        LOG.info("Выходим из аккаунта.");
        userCardToolBar.clickOnLogout();
        return this;
    }

    public LoginPage confirmLogout() {
        LOG.info("Подтвеждаем выход из аккаунта");
        userCardToolBar.confirmLogout();
        return new LoginPage();
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
}
