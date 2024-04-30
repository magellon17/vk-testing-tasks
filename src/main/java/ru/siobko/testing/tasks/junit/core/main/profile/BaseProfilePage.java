package ru.siobko.testing.tasks.junit.core.main.profile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.junit.core.main.BaseMainPage;
import ru.siobko.testing.tasks.junit.core.main.profile.myProfile.MyProfilePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class BaseProfilePage extends BaseMainPage {
    private static final Logger LOG = LoggerFactory.getLogger(MyProfilePage.class);

    public BaseProfilePage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        return true;
    }
}
