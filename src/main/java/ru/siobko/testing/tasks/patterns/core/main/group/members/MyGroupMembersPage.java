package ru.siobko.testing.tasks.patterns.core.main.group.members;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.group.BaseGroupPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MyGroupMembersPage extends BaseGroupPage {
    private static final Logger LOG = LoggerFactory.getLogger(MyGroupMembersPage.class);

    private static final By GROUP_MEMBERS_NAVI = byXpath(".//*[@id='GroupMembersMenu']");
    private static final By GROUP_MEMBERS_QUERY = byXpath(".//input[@placeholder='Поиск среди участников группы']");

    public MyGroupMembersPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(GROUP_MEMBERS_NAVI).shouldBe(
                visible.because("Не отобразилась навигация по участникам группы.")
        );
        $(GROUP_MEMBERS_QUERY).shouldBe(
                visible.because("Не отобразился поисковик по учатсникам группы.")
        );
        LOG.info("Перешли на страницу участников группы.");
        return true;
    }
}
