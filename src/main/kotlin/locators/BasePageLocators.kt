package locators

import org.openqa.selenium.By

object BasePageLocators {
    val issuesTab: By = By.cssSelector("[href=\"issues\"]")
    val youTrackLogo: By = By.cssSelector("[src=\"/youtrack.svg\"]")
    val userAvatarButton: By = By.cssSelector(".avatarWrapper_e8b4.resetButton_ddd2")
    val logoutButton: By = By.cssSelector("[aria-label=\"Dropdown menu\"] > div:nth-child(6)")
}
