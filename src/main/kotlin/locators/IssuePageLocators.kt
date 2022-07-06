package locators

import org.openqa.selenium.By

object IssuePageLocators {
    val findIssueField: By = By.cssSelector("[aria-label=\"Search\"]")
    val searchButton: By = By.cssSelector("[title=\"Search issues\"]")
}
