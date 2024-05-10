package ru.siobko.testing.tasks.patterns.core.media.photoAlbum.card;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.media.photoAlbum.PhotoAlbumPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;

public class PhotoAlbumCard {
    private static final Logger LOG = LoggerFactory.getLogger(PhotoAlbumCard.class);
    protected static final By TITLE = byXpath(".//*[@data-l='t,title']");
    protected static final By INFO = byXpath(".//*[@data-l='t,info']");
    protected static final By COVER = byXpath(".//*[@data-l='t,cover']");
    protected final SelenideElement albumCard;

    public PhotoAlbumCard(SelenideElement albumCard) {
        this.albumCard = albumCard;
    }

    public PhotoAlbumPage clickOnAlbumCard() {
        LOG.info("Clicking on album card");
        albumCard.$(COVER).shouldBe(
                visible.because("")
        ).click();
        return new PhotoAlbumPage();
    }
}
