package ru.siobko.testing.tasks.junit.core.main.groups;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.junit.core.main.BaseMainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public abstract class BaseGroupsPage extends BaseMainPage {
    private static final Logger LOG = LoggerFactory.getLogger(BaseGroupsPage.class);

    protected static final By GROUP_SEARCH_FIELD = byXpath(".//group-search-input[@data-bundle-name='search_group-search-input']");
    protected static final By OFFICIAL_GROUPS_BUTTON = byXpath(".//a[@aria-label='Официальные']");

    protected BaseGroupsPage() {
        checkPage();
    }

    @Override
    protected boolean checkPage() {
        $(GROUP_SEARCH_FIELD).shouldBe(
                visible.because("Не отобразился поисковик по группам.")
        );
        return true;
    }

    public OfficialGroupsPage openOfficialGroupsCatalog() {
        LOG.info("Открываем страницу с официальными группами.");
        $(OFFICIAL_GROUPS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка для перехода к официальным группам.")
        ).click();
        return new OfficialGroupsPage();
    }
}
