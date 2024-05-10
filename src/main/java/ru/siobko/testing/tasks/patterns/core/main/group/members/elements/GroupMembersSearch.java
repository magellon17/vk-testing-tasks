package ru.siobko.testing.tasks.patterns.core.main.group.members.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GroupMembersSearch {
    private final SelenideElement item = $(byXpath(".//*[contains(@hrefattrs, 'MembersSearch')]"));
    private static final By QUERY_FIELD = byXpath(".//*[@id='search']");

    public GroupMembersSearch() {
        check();
    }

    public boolean check(){
        item.shouldBe(
                visible.because("Не отобразился поисковик по учатсникам группы")
        );
        return true;
    }

    public void enter(String s){
        item.$(QUERY_FIELD).shouldBe(
                visible.because("Не отобразилось поле ввода")
        ).setValue(s);
    }
}
