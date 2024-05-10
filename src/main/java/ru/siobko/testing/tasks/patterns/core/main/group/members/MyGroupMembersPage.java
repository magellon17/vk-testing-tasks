package ru.siobko.testing.tasks.patterns.core.main.group.members;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.group.members.elements.MyGroupMembersMenu;


public class MyGroupMembersPage extends GroupMembersPage {
    private static final Logger LOG = LoggerFactory.getLogger(MyGroupMembersPage.class);
    private final MyGroupMembersMenu menu = new MyGroupMembersMenu();

    public MyGroupMembersPage() {
        checkPage();
    }

    public boolean checkPage() {
        LOG.info("Перешли на страницу участников группы.");
        return true;
    }
}
