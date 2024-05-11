package ru.siobko.testing.tasks.patterns.core.media;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PostLayer {
    private static final Logger log = LoggerFactory.getLogger(PostLayer.class);

    private static final By DELETE_POST_BUTTON = byXpath(".//a[contains(@hrefattrs, 'deleteButton')]");
    private static final By CLOSE_POST_BUTTON = byXpath(".//button[@data-l='t,mtLayerClose']");
    private static final By AUTHOR_REF = byXpath(".//div[@data-l='t,author']");
    private static final By TEXT_BOX = byXpath(".//div[@class='media-text_cnt_tx emoji-tx textWrap']");

    public PostLayer() {
        checkPage();
    }

    public boolean checkPage() {
        $(AUTHOR_REF).shouldBe(
                visible.because("Не отобразилась гиперссылка на автора поста.")
        );
        $(TEXT_BOX).shouldBe(
                visible.because("Не отобразился текст поста.")
        );
        log.info("Перешли на страницу поста.");
        return true;
    }

    /**
     * Удаляет пост
     * @return String
     */
    public String getText() {
        return $(TEXT_BOX).shouldBe(
                visible.because("Не отобразился текст поста.")
        ).getText();
    }

    /**
     * Клик по кнопке удаления
     */
    public PostLayer clickOnDelete() {
        log.info("Удаляем пост");
        executeJavaScript("arguments[0].click();", $(DELETE_POST_BUTTON));
        return this;
    }

    /**
     * Закрывает леер поста
     */
    public void closeLayer() {
        log.info("Закрываем леер поста");
        executeJavaScript("arguments[0].click();", $(CLOSE_POST_BUTTON));
    }
}
