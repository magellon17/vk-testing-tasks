package ru.siobko.testing.tasks.patterns.core.main.groups.elements.creatingGroup;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.models.group.GroupTopic;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CategoriesList extends CreateGroupForm {
    private static final Logger LOG = LoggerFactory.getLogger(CategoriesList.class);
    private static final By CARS_CATEGORY_BUTTON = byText("Автомобили");
    private static final By CAR_WOSH_CATEGORY_BUTTON = byText("Автомойка");

    public CategoriesList() {
        check();
    }

    public boolean check(){
        $(CAR_WOSH_CATEGORY_BUTTON).shouldBe(
                visible.because(""));
        $(CARS_CATEGORY_BUTTON).shouldBe(
                visible.because(""));
        return true;
    }

    public CreateGroupForm selectGroupCategory(GroupTopic topic) {
        LOG.info("Выбираем тематику группы");
        switch (topic) {
            case CARS:
                $(CARS_CATEGORY_BUTTON).shouldBe(
                        visible.because("Автомобильной тематики нет в списке.")
                ).click();
                break;
            case CAR_WASH:
                $(CAR_WOSH_CATEGORY_BUTTON).shouldBe(
                        visible.because("Нет варианта создать группу по интересам.")
                ).click();
        }
        return this;
    }

}
