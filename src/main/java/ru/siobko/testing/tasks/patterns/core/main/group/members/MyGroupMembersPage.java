package ru.siobko.testing.tasks.patterns.core.main.group.members;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;


public class MyGroupMembersPage extends GroupMembersPage {
    private static final Logger log = LoggerFactory.getLogger(MyGroupMembersPage.class);
    private static final By TODO_BLOCK = byId("groupTODO");

    public MyGroupMembersPage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        $(TODO_BLOCK).shouldBe(
                visible.because(""));
        log.info("Перешли на страницу участников группы.");
        return true;
    }
}
