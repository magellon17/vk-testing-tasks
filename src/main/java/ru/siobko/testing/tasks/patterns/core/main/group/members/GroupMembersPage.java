package ru.siobko.testing.tasks.patterns.core.main.group.members;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.group.members.elements.GroupMembersMenu;


public class GroupMembersPage {
    private static final Logger LOG = LoggerFactory.getLogger(GroupMembersPage.class);
    private final GroupMembersMenu membersMenu = new GroupMembersMenu();

    public GroupMembersPage() {
        checkPage();
    }

    public boolean checkPage() {
        LOG.info("Перешли на страницу участников группы.");
        return true;
    }
}
