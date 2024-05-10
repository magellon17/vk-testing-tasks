package ru.siobko.testing.tasks.patterns.tests.main.myProfile.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("ru.siobko.testing.tasks.patterns.tests.main.profiles.myProfilePage")
@IncludeTags("myProfile")
public class MyUserFeedPageSuiteTest {
}
