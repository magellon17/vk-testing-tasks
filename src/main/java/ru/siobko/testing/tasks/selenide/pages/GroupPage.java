package ru.siobko.testing.tasks.selenide.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GroupPage extends BasePage{
    public final SelenideElement members = $("[data-l = 'outlandermenu,altGroupMembers']");


}
