package ru.siobko.testing.tasks.patterns.core.main.user.photos;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MyUserPhotosPage {
    private static final Logger LOG = LoggerFactory.getLogger(MyUserPhotosPage.class);

    private static final By ALBUMS_BUTTON = byXpath(".//a[@data-l='t,albums_new']");
    private static final By SHARED_ALBUMS_BUTTON = byXpath(".//a[@data-l='t,shared-albums']");

    public MyUserPhotosPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(ALBUMS_BUTTON).shouldBe(
                visible.because("Feed filter menu should be visible on my profile page.")
        );
        $(SHARED_ALBUMS_BUTTON).shouldBe(
                visible.because("Navigation menu of profile feed should be visible on my profile page.")
        );
        LOG.info("Перешли на страницу фотографий моего профиля.");
        return true;
    }
}
