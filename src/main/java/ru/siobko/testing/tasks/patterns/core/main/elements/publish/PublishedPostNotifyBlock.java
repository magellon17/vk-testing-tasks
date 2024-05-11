package ru.siobko.testing.tasks.patterns.core.main.elements.publish;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.elements.UIComponent;
import ru.siobko.testing.tasks.patterns.core.main.user.MyUserMainPage;
import ru.siobko.testing.tasks.patterns.core.media.PostLayer;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Блок уведомления, который появляется после создания поста
 */
public class PublishedPostNotifyBlock extends MyUserMainPage implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(PublishedPostNotifyBlock.class);

    private static final SelenideElement block = $(byId("hook_Block_TipBlock"));

    private static final By OPEN_PUBLISHED_POST_BUTTON = byXpath(".//a[@class='js-tip-block-url al']");

    public PublishedPostNotifyBlock(){
        isLoaded();
    }

    @Override
    public boolean isLoaded() {
        block.$(OPEN_PUBLISHED_POST_BUTTON).shouldBe(
                visible.because(""));
        return true;
    }

    public PostLayer openPublishedPost() {
        log.info("Открываем опубликованный пост");
        $(OPEN_PUBLISHED_POST_BUTTON).shouldBe(
                visible.because("Не найден пост.")
        ).click();
        return new PostLayer();
    }
}
