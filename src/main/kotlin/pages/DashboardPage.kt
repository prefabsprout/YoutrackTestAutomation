package pages

import com.codeborne.selenide.Selenide.element
import locators.DashboardPageLocators

class DashboardPage : BasePage() {
    fun goToNewIssuePage(): DashboardPage {
        element(DashboardPageLocators.createNewIssueButton).click()
        return this
    }
}
