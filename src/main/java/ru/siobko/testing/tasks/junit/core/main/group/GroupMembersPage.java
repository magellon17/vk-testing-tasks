package ru.siobko.testing.tasks.junit.core.main.group;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GroupMembersPage extends BaseGroupPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupMembersPage.class);
    private static final By GROUP_MEMBERS_MENU = byXpath(".//div[@id='GroupMembersMenu']");
    private static final By GROUP_MEMBERS_PAGING_BLOCK = byXpath(".//div[@id='hook_Block_GroupMembersPagingBlock']");
    private static final By GROUP_MEMBERS_QUERY = byXpath(".//input[@placeholder='Поиск среди участников группы']");

    public GroupMembersPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(GROUP_MEMBERS_MENU).shouldBe(
                visible.because("Query Filed should be visible on all pages.")
        );
        $(GROUP_MEMBERS_PAGING_BLOCK).shouldBe(
                visible.because("Ecosystem button should be visible on all pages.")
        );
        $(GROUP_MEMBERS_QUERY).shouldBe(
                visible.because("Ecosystem button should be visible on all pages.")
        );
        LOGGER.info("Перешли на страницу участников группы");
        return true;
    }
}
