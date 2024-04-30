package ru.siobko.testing.tasks.junit.core.main.profile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.junit.core.main.BaseMainPage;

public abstract class BaseProfilePage extends BaseMainPage {
    private static final Logger LOG = LoggerFactory.getLogger(BaseProfilePage.class);

    public BaseProfilePage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        return true;
    }
}
