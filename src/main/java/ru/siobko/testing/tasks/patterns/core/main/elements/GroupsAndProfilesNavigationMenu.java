package ru.siobko.testing.tasks.patterns.core.main.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Общее меню навигации для группы и профиля пользователя
 */
public abstract class GroupsAndProfilesNavigationMenu {
    private static final Logger log = LoggerFactory.getLogger(GroupsAndProfilesNavigationMenu.class);
    protected final SelenideElement navi = $(byXpath(".//*[@data-l='t,horizontalNavigation']"));
    protected static final By PHOTOS_BUTTON = byText("Фото");

    public void clickOnPhotos() {
        log.info("Кликаем на фото");
        navi.$(PHOTOS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка фоток")
        ).click();
    }
    // и так далее...
}
