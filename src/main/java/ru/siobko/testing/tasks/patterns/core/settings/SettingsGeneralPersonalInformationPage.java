package ru.siobko.testing.tasks.patterns.core.settings;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SettingsGeneralPersonalInformationPage extends SettingsBasePage {
    private static final Logger LOG = LoggerFactory.getLogger(SettingsGeneralPersonalInformationPage.class);

    private static final By NAME_FIELD = byName("fr.name");
    private static final By SURNAME_FIELD = byName("fr.surname");
    private static final By SUBMIT_BUTTON = byXpath(".//input[@data-l='t,profile_form_settings']");

    public SettingsGeneralPersonalInformationPage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        $(NAME_FIELD).shouldBe(
                visible.because("Не отобразилось поле имени.")
        );
        $(SURNAME_FIELD).shouldBe(
                visible.because("Не отобразилось поле фамилии.")
        );
        $(SUBMIT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка сохранения изменений.")
        );
        LOG.info("Перешли на страницу персональных настроек.");
        return true;
    }

    public SettingsGeneralPersonalInformationPage enterName(String name) {
        LOG.info("Вводим новое имя профиля: {}", name);
        $(NAME_FIELD).shouldBe(
                visible.because("Не отобразилось поле имени.")
        ).setValue(name);
        return this;
    }

    public void clickSubmit() {
        LOG.info("Подтверждаем изменения");
        $(SUBMIT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка сохранения изменений.")
        ).click();
    }
}
