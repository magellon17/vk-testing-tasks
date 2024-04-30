package ru.siobko.testing.tasks.junit.tests.main.profiles.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("ru.siobko.testing.tasks.junit.tests.main.profiles.myProfilePage")
@IncludeTags("profiles")
public class ProfilesSuiteTest {
}
