package pages

import com.codeborne.selenide.Selectors.byText
import com.codeborne.selenide.Selenide.element
import locators.IssuePageLocators

class IssuesPage : BasePage() {
    fun findIssue(issueName: String): IssuesPage {
        element(IssuePageLocators.findIssueField).setValue(issueName)
        element(IssuePageLocators.searchButton).click()
        return this
    }

    fun issueShouldBeNotFound(): IssuesPage {
        element(byText("\n" +
                "    We didn't find any issues that match your search query\n" +
                "  "))
        return this
    }
}
