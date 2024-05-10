package ru.siobko.testing.tasks.patterns.core.main.group.members.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.BaseMainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GroupMembersMenu {
    private static final Logger LOG = LoggerFactory.getLogger(GroupMembersMenu.class);

    protected final SelenideElement item = $(byXpath(".//*[@id='GroupMembersMenu']"));
    protected static final By GROUP_MEMBERS = byXpath(".//*[contains(@hrefattrs, 'Menu_GroupMembers')]");

    public GroupMembersMenu() {
        check();
    }

    public boolean check() {
        item.shouldBe(visible.because(""));
        LOG.info("Check group members menu");
        return true;
    }

    public void clickOnGroupMembers() {
        $(GROUP_MEMBERS).shouldBe(visible.because("")).click();
    }
}
