package ru.siobko.testing.tasks.junit.core.media;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class StatusPage {
    private static final Logger LOG = LoggerFactory.getLogger(StatusPage.class);

    private static final By DELETE_PUBLISHED_POST_BUTTON = byXpath(".//a[contains(@hrefattrs, 'deleteButton')]");
    private static final By CLOSE_PUBLISHED_POST_BUTTON = byXpath(".//button[@data-l='t,mtLayerClose']");
    private static final By AUTHOR_REF =byXpath(".//div[@data-l='t,author']");
    private static final By TEXT_BOX =byXpath(".//div[@class='media-text_cnt_tx emoji-tx textWrap']");

    public StatusPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(AUTHOR_REF).shouldBe(
                visible.because("Не отобразилась гиперссылка на автора статуса.")
        );
        $(TEXT_BOX).shouldBe(
                visible.because("Не отобразился текст статуса.")
        );
        LOG.info("Перешли на страницу статуса.");
        return true;
    }

    public String getText() {
        return $(TEXT_BOX).shouldBe(
                visible.because("Не отобразился текст статуса.")
        ).getText();
    }

    public StatusPage deleteStatus() {
        LOG.info("Удаляем статус.");
        executeJavaScript("arguments[0].click();", $(DELETE_PUBLISHED_POST_BUTTON));
        return this;
    }

    public void closeStatus() {
        LOG.info("Закрываем страницу с статусом.");
        executeJavaScript("arguments[0].click();", $(CLOSE_PUBLISHED_POST_BUTTON));
    }
}
