package pages

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import locators.BasePageLocators
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

open class BasePage {
    fun tryToFindListOfElementsUntilTimeout(timeoutInMilliseconds: Long, elementLocator: By): List<WebElement> {
        val startTime: Long = System.currentTimeMillis()
        lateinit var listOfElements: List<WebElement>
        while ((System.currentTimeMillis() - startTime) < timeoutInMilliseconds) {
            listOfElements = Selenide.elements(elementLocator)
            if (listOfElements.isNotEmpty()) return listOfElements
        }
        throw NoSuchElementException("After $timeoutInMilliseconds milliseconds there is still no elements with locator $elementLocator")
    }

    fun logout(): BasePage {
        element(BasePageLocators.userAvatarButton).click()
        element(BasePageLocators.logoutButton).click()
        return this
    }

    fun goToHomePage(): BasePage {
        element(BasePageLocators.youTrackLogo).click()
        return this
    }

    fun goToIssuesTab(): BasePage {
        element(BasePageLocators.issuesTab).click()
        return this
    }
}
