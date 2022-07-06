package pages

import com.codeborne.selenide.Selenide.element
import locators.IssueCardPageLocators
import org.openqa.selenium.WebElement
import org.testng.Assert


class IssueCardPage : BasePage() {
    lateinit var taskId: String

    fun goToNewIssueDialogue(): IssueCardPage {
        element(IssueCardPageLocators.createNewIssueButton).click()
        return this
    }

    fun shouldLinkedTaskBeWithExpectedId(expectedTaskId: String): IssueCardPage {
        val linkedTaskId: String = element(IssueCardPageLocators.linkedTaskTitle).text()
        Assert.assertEquals(linkedTaskId, expectedTaskId)
        return this
    }

    fun shouldTaskSummaryBeAsExpected(expectedTaskSummary: String): IssueCardPage {
        val taskSummaryOnPage: String = element(IssueCardPageLocators.taskSummaryTitle).text
        Assert.assertEquals(taskSummaryOnPage, expectedTaskSummary)
        return this
    }

    fun shouldTaskBeAssignedToExpectedUser(expectedAssignee: String): IssueCardPage {
        val assignedUser: String = element(IssueCardPageLocators.taskAssignee).text
        Assert.assertEquals(assignedUser, expectedAssignee)
        return this
    }

    fun shouldTaskBeExpectedPriority(expectedPriority: String): IssueCardPage {
        val taskPriority: String = element(IssueCardPageLocators.taskPriorityTitle).text
        Assert.assertEquals(taskPriority, expectedPriority)
        return this
    }

    fun shouldTaskHaveExpectedTags(expectedTagsList: List<String>): IssueCardPage {
        val attachedTagsArray: List<WebElement> =
            this.tryToFindListOfElementsUntilTimeout(20000, IssueCardPageLocators.attachedTags)
        val listOfAttachedTagsString: List<String> = attachedTagsArray.map {
            it.text
        }
        val isListOfAttachedTagsContainsExpectedTagsList: Boolean = expectedTagsList.any {
            it in listOfAttachedTagsString
        }
        if (isListOfAttachedTagsContainsExpectedTagsList) return this
        else throw AssertionError("There is no expected tags $expectedTagsList attached to task")
    }

    fun setTaskId(): IssueCardPage {
        taskId = element(IssueCardPageLocators.taskIdTitle).text
        return this
    }
}
