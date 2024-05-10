package ru.siobko.testing.tasks.patterns.core.media.photoAlbum.card.actionsMenu;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.media.photoAlbum.PhotoAlbumPage;
import ru.siobko.testing.tasks.patterns.core.media.photoAlbum.card.PhotoAlbumCard;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PhotoAlbumCardActionsMenu {
    private static final Logger LOG = LoggerFactory.getLogger(PhotoAlbumCard.class);
    private final SelenideElement menu = $(byXpath(".//menu[contains(@class, 'actions-menu')]"));
    private static final By UPLOAD = byXpath(".//*[@data-l='t,upload-file']");
    private static final By EDIT = byXpath(".//*[contains(@href, 'PersonalAlbumEdit')]");

    public PhotoAlbumCardActionsMenu() {
        check();
    }

    public boolean check() {
        menu.shouldBe(
                visible.because("")
        );
        return true;
    }

    public PhotoAlbumPage uploadPhoto() {
        LOG.info("Clicking on album card");
        menu.$(UPLOAD).shouldBe(
                visible.because("")
        ).click();
        return new PhotoAlbumPage();
    }
}
