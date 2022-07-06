package pages

import com.codeborne.selenide.Selectors.byText
import com.codeborne.selenide.Selenide.element
import locators.NewIssuePageLocators

class NewIssuePage : BasePage() {
    fun fillTaskSummary(taskSummary: String): NewIssuePage {
        element(NewIssuePageLocators.taskSummaryField).setValue(taskSummary)
        return this
    }

    fun clickOnCreateButton(): NewIssuePage {
        element(NewIssuePageLocators.createIssueButton).click()
        return this
    }

    fun attachFile(linkToFile: String): NewIssuePage {
        element(NewIssuePageLocators.attachFileButton).setValue(linkToFile)
        return this
    }

    fun changeTaskPriority(taskPriority: String): NewIssuePage {
        element(NewIssuePageLocators.priorityButton).click()
        element(NewIssuePageLocators.filterItems).setValue(taskPriority)
        element(byText(taskPriority)).click()
        return this
    }

    fun assignTaskToUser(userName: String): NewIssuePage {
        element(NewIssuePageLocators.assignToUserButton).click()
        element(NewIssuePageLocators.filterItems).setValue(userName)
        element(byText(userName)).click()
        return this
    }

    fun selectGroupToWhomTaskIsVisible(userName: String): NewIssuePage {
        element(NewIssuePageLocators.visibleToIssueReadersDropdown).click()
        element(NewIssuePageLocators.filterUsersInTaskVisibilityDropdown).setValue(userName)
        element(byText(userName)).click()
        return this
    }

    fun setTag(tagName: String): NewIssuePage {
        element(NewIssuePageLocators.addTagButton).click()
        element(NewIssuePageLocators.filterItems).setValue(tagName)
        element(byText(tagName)).click()
        return this
    }
}
