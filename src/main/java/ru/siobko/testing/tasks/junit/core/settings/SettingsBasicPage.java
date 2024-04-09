package ru.siobko.testing.tasks.junit.core.settings;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SettingsBasicPage extends SettingsBasePage {
    private static final By personaDataForm = byXpath(".//a[@data-l='t,profile_form']");
    private static final By passwordForm = byXpath(".//a[@data-l='t,set_password']");
    private static final By emailForm = byXpath(".//a[@data-l='t,set_email']");

    public SettingsBasicPage() {
        checkPage();
    }

    public static boolean checkPage() {
        $(personaDataForm).shouldBe(visible);
        $(passwordForm).shouldBe(visible);
        $(emailForm).shouldBe(visible);
        return true;
    }

    public SettingsBasicPersonalDataPage openPersonalDataPage() {
        $(personaDataForm).click();
        return new SettingsBasicPersonalDataPage();
    }

}
