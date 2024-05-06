package ru.siobko.testing.tasks.junit.core.media;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PostPage {
    private static final Logger LOG = LoggerFactory.getLogger(PostPage.class);

    private static final By DELETE_PUBLISHED_POST_BUTTON = byXpath(".//a[contains(@hrefattrs, 'deleteButton')]");
    private static final By CLOSE_PUBLISHED_POST_BUTTON = byXpath(".//button[@data-l='t,mtLayerClose']");
    private static final By AUTHOR_REF =byXpath(".//div[@data-l='t,author']");
    private static final By TEXT_BOX =byXpath(".//div[@class='media-text_cnt_tx emoji-tx textWrap']");

    public PostPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(AUTHOR_REF).shouldBe(
                visible.because("Не отобразилась гиперссылка на автора поста.")
        );
        $(TEXT_BOX).shouldBe(
                visible.because("Не отобразился текст поста.")
        );
        LOG.info("Перешли на страницу поста.");
        return true;
    }

    public String getText() {
        return $(TEXT_BOX).shouldBe(
                visible.because("Не отобразился текст поста.")
        ).getText();
    }

    public PostPage deletePost() {
        LOG.info("Удаляем пост.");
        executeJavaScript("arguments[0].click();", $(DELETE_PUBLISHED_POST_BUTTON));
        return this;
    }

    public void closePost() {
        LOG.info("Закрываем страницу с постом.");
        executeJavaScript("arguments[0].click();", $(CLOSE_PUBLISHED_POST_BUTTON));
    }
}
