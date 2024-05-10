package ru.siobko.testing.tasks.patterns.core.media.photoAlbum.card;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.media.photoAlbum.card.actionsMenu.PhotoAlbumCardActionsMenu;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MyPhotoAlbumCard extends PhotoAlbumCard {
    private static final Logger LOG = LoggerFactory.getLogger(MyPhotoAlbumCard.class);
    private static final By SHOW_ACTIONS_MENU = byXpath(".//*[@data-l='t,show-action-menu']");

    public MyPhotoAlbumCard(SelenideElement albumCard) {
        super(albumCard);
    }

    public PhotoAlbumCardActionsMenu clikcOnActionsMenu() {
        $(SHOW_ACTIONS_MENU).shouldBe(
                visible.because("")
        ).click();
        return new PhotoAlbumCardActionsMenu();
    }
}
