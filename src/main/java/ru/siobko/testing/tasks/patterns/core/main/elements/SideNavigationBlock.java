package ru.siobko.testing.tasks.patterns.core.main.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SideNavigationBlock {
    private static final Logger LOG = LoggerFactory.getLogger(SideNavigationBlock.class);

    private static final By GROUPS_BUTTON = byXpath(".//a[@data-l='t,userAltGroup']");
    private static final By MY_PROFILE_BUTTON = byXpath(".//a[@data-l='t,userPage']");

    public SideNavigationBlock() {
    }

    public void clickOnGroups() {
        LOG.info("Кликаем на группы");
        $(GROUPS_BUTTON).shouldBe(
                visible.because("Нет кнопки для перехода к группам.")
        ).click();
    }

    public void clickOnMyProfile() {
        LOG.info("Кликаем на мой профиль");
        $(MY_PROFILE_BUTTON).shouldBe(
                visible.because("Нет кнопки для перехода в профиль.")
        ).click();
    }

    public boolean checkProfileNameContains(String s) {
        return $(MY_PROFILE_BUTTON).shouldBe(
                        visible.because("Не отобразилась кнопка профиля пользователя.")
                ).getText()
                .contains(s);
    }
}
