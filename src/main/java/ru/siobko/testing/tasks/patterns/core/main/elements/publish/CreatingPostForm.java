package ru.siobko.testing.tasks.patterns.core.main.elements.publish;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.elements.SideNavigationBlock;
import ru.siobko.testing.tasks.patterns.core.main.elements.UIComponent;
import ru.siobko.testing.tasks.patterns.core.main.user.MyUserMainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Форма с текстовым полем для написания текста поста
 */
public class CreatingPostForm extends MyUserMainPage implements UIComponent {
    private static final Logger log = LoggerFactory.getLogger(SideNavigationBlock.class);
    private static final By POST_TEXT_BOX = byXpath(".//div[@data-module='postingForm/mediaText']");
    private static final By SUBMIT_BUTTON = byXpath(".//button[@data-l='t,button.submit']");

    public CreatingPostForm(){
        isLoaded();
    }

    @Override
    public boolean isLoaded(){
        $(SUBMIT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка публикации"));
        $(POST_TEXT_BOX).shouldBe(
                visible.because("Не отобразилось поле ввода текста поста"));
        log.info("Загрузилась форма для написания и публикации поста");
        return true;
    }

    public CreatingPostForm enterPostText(String postText) {
        log.info("Вводим текст поста");
        $(POST_TEXT_BOX).shouldBe(
                visible.because("Не отобразилось поле ввода текста поста")
        ).setValue(postText);
        return this;
    }

    public PublishedPostNotifyBlock clickSubmit() {
        log.info("Публикуем пост");
        $(SUBMIT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка подтвержденря публикации поста.")
        ).click();
        return new PublishedPostNotifyBlock();
    }
}
