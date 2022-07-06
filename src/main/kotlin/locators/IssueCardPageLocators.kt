package locators

import org.openqa.selenium.By

object IssueCardPageLocators {
    val taskSummaryTitle: By = By.cssSelector("[data-test=\"ticket-summary\"]")
    val taskIdTitle: By = By.cssSelector(".idLink__a4b > a > span")
    val taskPriorityTitle: By = By.cssSelector(".sidebar__de9 > div:nth-child(2) button span")
    val taskAssignee: By = By.cssSelector(".sidebar__de9 > div:nth-child(5) button span")
    val linkedTaskTitle: By = By.cssSelector(".row__a39 div:nth-child(2) span")
    val createNewIssueButton: By = By.cssSelector("[data-test=\"createIssueButton\"]")
    val attachedTags: By = By.cssSelector(".tags__c93 button:nth-child(1) span a")
}
