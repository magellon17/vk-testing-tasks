package ru.siobko.testing.tasks.patterns.core.main.group.members.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;

public class MyGroupMembersMenu extends GroupMembersMenu {
    private static final Logger LOG = LoggerFactory.getLogger(MyGroupMembersMenu.class);
    protected static final By GROUP_LEADERS_BUTTON = byXpath(".//*[contains(@hrefattrs, 'Menu_GroupLeaders')]");
}
