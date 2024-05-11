package ru.siobko.testing.tasks.patterns.core.main.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.user.MyUserMainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PostingForm extends MyUserMainPage {
    private static final Logger LOG = LoggerFactory.getLogger(SideNavigationBlock.class);
    private static final By POST_TEXT_BOX = byXpath(".//div[@data-module='postingForm/mediaText']");
    private static final By SUBMIT_BUTTON = byXpath(".//button[@data-l='t,button.submit']");

    public PostingForm enterPostText(String postText) {
        LOG.info("Вводим текст поста.");
        $(POST_TEXT_BOX).shouldBe(
                visible.because("Не отобразилось поле ввода текста поста.")
        ).setValue(postText);
        return this;
    }

    public MyUserMainPage clickSubmit() {
        LOG.info("Публикуем пост.");
        $(SUBMIT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка подтвержденря публикации поста.")
        ).click();
        return this;
    }
}
