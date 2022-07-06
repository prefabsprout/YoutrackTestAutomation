package pages

import com.codeborne.selenide.Selenide.element
import common.User
import locators.AuthorizationPageLocators

class AuthorizationPage : BasePage() {
    fun login(user: User): AuthorizationPage {
        element(AuthorizationPageLocators.usernameField).setValue(user.MAIL)
        element(AuthorizationPageLocators.passwordField).setValue(user.PASSWORD)
        element(AuthorizationPageLocators.loginButton).click()
        return this
    }
}
