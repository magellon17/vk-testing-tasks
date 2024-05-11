package ru.siobko.testing.tasks.patterns.core.main.elements.publish;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.user.MyUserMainPage;

import java.io.File;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PublishingMenuForm extends MyUserMainPage {
    private static final Logger LOG = LoggerFactory.getLogger(PublishingMenuForm.class);
    private final SelenideElement form = $(byXpath(".//*[contains(@class, 'dropdown-list__')]"));
    private static final By PHOTO_INPUT = byXpath(".//input[@accept='image/*, video/*, .heic,']");
    private static final By POST_BUTTON = byXpath(".//*[@data-l='t,feed.posting.ui.input']");

    public PublishingMenuForm() {
        check();
    }

    public boolean check(){
        form.$(POST_BUTTON).shouldBe(
                visible.because("Не отобразился поисковик по учатсникам группы")
        );
        return true;
    }

    public MyUserMainPage uploadPhoto(String filename) {
        LOG.info("Публикуем фотку.");
        form.$(PHOTO_INPUT).shouldBe(
                exist.because("Не отобразилась кнопка загрзуки фото.")
        ).uploadFile(new File(filename));
        return this;
    }

    public PostingForm clickPublishPost() {
        LOG.info("Кликаем на кнопку публикации поста.");
        form.$(POST_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка публикации поста.")
        ).click();
        return new PostingForm();
    }
}
