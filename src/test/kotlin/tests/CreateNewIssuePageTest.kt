package tests

import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.Selenide.closeWebDriver
import common.MysteriousGuy
import common.RootUser
import common.YOUTRACK_URL
import org.testng.annotations.Test

class CreateNewIssuePageTest: BaseTest() {
    @Test
    fun `User creates new issue without description test`() {
        open(YOUTRACK_URL)
        authorizationPage.login(RootUser)
        dashboardPage.goToNewIssuePage()
        newIssuePage
            .fillTaskSummary("QA dummy task")
            .clickOnCreateButton()
        issueCardPage.shouldTaskSummaryBeAsExpected("QA dummy task")
        closeWebDriver()
    }

    @Test
    fun `User creates task visible only to him`() {
        open(YOUTRACK_URL)
        authorizationPage.login(RootUser)
        dashboardPage.goToNewIssuePage()
        newIssuePage
            .fillTaskSummary("QA dummy task")
            .selectGroupToWhomTaskIsVisible("QA Team")
            .clickOnCreateButton()
        issueCardPage.setTaskId()
        val taskId = issueCardPage.taskId
        basePage.logout()
        authorizationPage.login(MysteriousGuy)
        basePage.goToIssuesTab()
        issuesPage
            .findIssue(taskId)
            .issueShouldBeNotFound()
        closeWebDriver()
    }

    @Test
    fun `User creates task assigned to another user`() {
        open(YOUTRACK_URL)
        authorizationPage.login(RootUser)
        dashboardPage.goToNewIssuePage()
        newIssuePage
            .fillTaskSummary("QA dummy task")
            .assignTaskToUser("Mysterious Guy")
            .clickOnCreateButton()
        issueCardPage.shouldTaskBeAssignedToExpectedUser("Mysterious Guy")
        closeWebDriver()
    }

    @Test
    fun `User creates task with critical priority`() {
        open(YOUTRACK_URL)
        authorizationPage.login(RootUser)
        dashboardPage.goToNewIssuePage()
        newIssuePage
            .fillTaskSummary("QA dummy task")
            .changeTaskPriority("Критическая")
            .clickOnCreateButton()
        issueCardPage.shouldTaskBeExpectedPriority("Критическая")
        closeWebDriver()
    }

    @Test
    fun `User creates task with tag`() {
        open(YOUTRACK_URL)
        authorizationPage.login(RootUser)
        dashboardPage.goToNewIssuePage()
        newIssuePage
            .fillTaskSummary("QA dummy task")
            .setTag("qa-tag")
            .clickOnCreateButton()
        issueCardPage.shouldTaskHaveExpectedTags(listOf("qa-tag"))
        closeWebDriver()
    }
}
