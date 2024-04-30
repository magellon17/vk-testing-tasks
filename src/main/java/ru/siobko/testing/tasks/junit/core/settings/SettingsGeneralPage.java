package ru.siobko.testing.tasks.junit.core.settings;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SettingsGeneralPage extends SettingsBasePage {
    private static final Logger LOG = LoggerFactory.getLogger(SettingsGeneralPage.class);
    private static final By PERSONAL_INFORMATION_FORM = byXpath(".//a[@data-l='t,profile_form']");
    private static final By PASSWORD_FORM = byXpath(".//a[@data-l='t,set_password']");
    private static final By EMAIL_FORM = byXpath(".//a[@data-l='t,set_email']");

    public SettingsGeneralPage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        $(PERSONAL_INFORMATION_FORM).shouldBe(
                visible.because("Не отобразилась форма персональной информации.")
        );
        $(PASSWORD_FORM).shouldBe(
                visible.because("Не отобразилась форма пароля.")
        );
        $(EMAIL_FORM).shouldBe(
                visible.because("Не отобразилась форма почты.")
        );
        LOG.info("Перешли на страницу основных настроек.");
        return true;
    }

    public SettingsGeneralPersonalInformationPage openPersonalInformationPage() {
        LOG.info("Открываем страницу с персональными настройками.");
        $(PERSONAL_INFORMATION_FORM).shouldBe(
                visible.because("Не отобразилась форма персональной информации.")
        ).click();
        return new SettingsGeneralPersonalInformationPage();
    }

}
