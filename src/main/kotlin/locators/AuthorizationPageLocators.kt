package locators

import org.openqa.selenium.By

object AuthorizationPageLocators {
    val usernameField: By = By.cssSelector("[data-test=\"username-field\"]")
    val passwordField: By = By.cssSelector("[data-test=\"password-field\"]")
    val loginButton: By = By.cssSelector("[data-test=\"login-button\"]")
}
