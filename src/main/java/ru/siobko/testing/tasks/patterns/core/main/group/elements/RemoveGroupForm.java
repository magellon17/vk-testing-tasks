package ru.siobko.testing.tasks.patterns.core.main.group.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.main.groups.GroupsMainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RemoveGroupForm {
    private static final Logger LOG = LoggerFactory.getLogger(RemoveGroupForm.class);
    private static final By CONFIRM_DELETION_BUTTON = byXpath(".//*[@data-l='t,confirm']");

    public GroupsMainPage confirmDeletion() {
        LOG.info("Подтверждаем удаление группы.");
        $(CONFIRM_DELETION_BUTTON).shouldBe(
                visible.because("Не появилась кнопка пожтверждения удаления.")
        ).click();
        return new GroupsMainPage();
    }
}
