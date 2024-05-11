package ru.siobko.testing.tasks.patterns.core.main.group.members;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;


public class GroupMembersPage {
    private static final Logger LOG = LoggerFactory.getLogger(GroupMembersPage.class);
    protected static final By MEMBERS_BLOCK = byId("listBlockPanelGroupMembersPagingBlock");

    public GroupMembersPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(MEMBERS_BLOCK).shouldBe(
                visible.because(""));
        LOG.info("Перешли на страницу участников группы.");
        return true;
    }
}
