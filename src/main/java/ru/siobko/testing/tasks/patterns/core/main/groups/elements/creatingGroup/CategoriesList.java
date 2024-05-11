package ru.siobko.testing.tasks.patterns.core.main.groups.elements.creatingGroup;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.elements.UIComponent;
import ru.siobko.testing.tasks.patterns.models.group.GroupTopic;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CategoriesList extends CreateGroupForm implements UIComponent {
    private static final Logger LOG = LoggerFactory.getLogger(CategoriesList.class);
    private static final By CARS_CATEGORY_BUTTON = byXpath(".//*[text()='Автомобили']");
    private static final By CAR_WOSH_CATEGORY_BUTTON = byXpath(".//*[text()='Автомойка']");

    public CategoriesList() {
        isLoaded();
    }

    @Override
    public boolean isLoaded() {
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
