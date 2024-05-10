package ru.siobko.testing.tasks.patterns.core.main.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class QueryField {
    private final SelenideElement field = $(byXpath(".//*[@name='st.query']"));

    public QueryField() {
        check();
    }

    public boolean check(){
        field.shouldBe(
                visible.because("Не отобразился поисковик по учатсникам группы")
        );
        return true;
    }

    public void enter(String s){
        field.shouldBe(
                visible.because("Не отобразилось поле ввода")
        ).setValue(s);
    }
}
