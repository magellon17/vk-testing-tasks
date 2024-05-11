package ru.siobko.testing.tasks.patterns.core.main.group.photos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GroupPhotosPage {
    private static final Logger LOG = LoggerFactory.getLogger(GroupPhotosPage.class);

    public GroupPhotosPage() {
        checkPage();
    }

    public boolean checkPage() {
        LOG.info("Перешли на страницу фотографий группы.");
        return true;
    }
}
