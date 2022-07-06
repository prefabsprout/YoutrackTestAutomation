package tests

import apihandler.ApiHandler
import org.testng.annotations.BeforeTest
import com.codeborne.selenide.Configuration
import common.IMPLICIT_WAIT_TIMEOUT
import org.testng.annotations.AfterTest
import pages.*

open class BaseTest {
    val basePage: BasePage = BasePage()
    val dashboardPage: DashboardPage = DashboardPage()
    val authorizationPage: AuthorizationPage = AuthorizationPage()
    val newIssuePage: NewIssuePage = NewIssuePage()
    val issueCardPage: IssueCardPage = IssueCardPage()
    val issuesPage: IssuesPage = IssuesPage()

    @BeforeTest
    fun setTimeout() {
        Configuration.timeout = IMPLICIT_WAIT_TIMEOUT
    }

    @AfterTest
    fun deleteAllTestData() {
        ApiHandler.deleteAllIssues()
    }
}
