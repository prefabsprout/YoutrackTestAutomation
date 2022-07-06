package locators

import org.openqa.selenium.By

object NewIssuePageLocators {
    val addTagButton: By = By.cssSelector("[aria-label=\"Add tag\"]")
    val taskSummaryField: By = By.cssSelector("[data-test=\"summary\"]")
    val createIssueButton: By = By.cssSelector("[data-test=\"submit-button\"]")
    val visibleToIssueReadersDropdown: By = By.cssSelector(".toolbarRight__be4 :nth-child(2)")
    val attachFileButton: By = By.cssSelector("[data-test=\"attach-file\"]")
    val filterItems: By = By.cssSelector("[aria-label=\"Filter items\"]")
    val filterUsersInTaskVisibilityDropdown: By = By.cssSelector("[aria-label=\"Filter users, groups, and teams\"]")
    val priorityButton: By = By.cssSelector(".sidebar__de9 > :nth-child(2)")
    val assignToUserButton: By = By.cssSelector(".sidebar__de9 > :nth-child(5)")
    val filterTaskToLinkField: By = By.cssSelector("[data-test=\"ring-query-assist-input\"]")
    val searchButton: By = By.cssSelector("[data-test=\"search-button\"]")
}
