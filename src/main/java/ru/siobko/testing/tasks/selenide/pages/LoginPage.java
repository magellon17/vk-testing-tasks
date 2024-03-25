package ru.siobko.testing.tasks.selenide.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final String email = "technopol72";
    private final String password = "technopolisPassword";

    public LoginPage open() {
        Selenide.open("/");
        return this;
    }
    public LoginPage login() {
        $(By.name("st.email")).setValue(email);
        $(By.name("st.password")).setValue(password);
        $(byValue("Log in to OK")).click();
        return this;
    }
}
