package ru.siobko.testing.tasks.junit.tests.main.groups.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("ru.siobko.testing.tasks.junit.tests.main.groups.groupsPage")
@IncludeTags("groupsPage")
public class GroupsPageSuiteTest {
}
