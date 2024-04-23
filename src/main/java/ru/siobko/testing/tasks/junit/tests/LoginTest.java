package ru.siobko.testing.tasks.junit.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.tasks.junit.core.login.LoginPage;
import ru.siobko.testing.tasks.junit.core.main.FeedPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("auth")
public class LoginTest extends BaseTest {
    @Test
    public void testLogin() {
        FeedPage feedPage = new LoginPage()
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickSubmit();
        assertTrue(feedPage.checkProfileNameContains(EMAIL),
                "Incorrect account login name."
        );
    }
}
