package ru.siobko.testing.tasks.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage extends BasePage{
    public final SelenideElement aboutGroupPanel = $(byId("hook_Block_LeftColumnTopCardAltGroup"));
    public final SelenideElement mainContentHeader = $(byId("hook_Block_MainContentHeader"));
    public final SelenideElement groupName = $(byClassName("group-name_h"));

    public GroupPage(){
        check();
    }

    private void check(){
        mainContentHeader.shouldBe(visible);
        aboutGroupPanel.shouldBe(visible);
    }

}
