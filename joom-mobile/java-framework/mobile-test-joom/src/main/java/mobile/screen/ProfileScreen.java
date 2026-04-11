package mobile.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.extern.slf4j.Slf4j;
import mobile.enums.LoginTitle;
import mobile.helper.Helper;
import mobile.locator.LoginLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


// Пример использования паттерна PageObject

@Slf4j
public class ProfileScreen extends BaseScreen {

    public ProfileScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void verifyLoginScreenOpened(LoginTitle loginTitle) {
        assertThat(Helper.isTextOnScreen(loginTitle.getValue()))
                .as("Check if the text '%s' is visible on screen", loginTitle.getValue())
                .isTrue();

        log.info("Verify '{}' text is visible", loginTitle.getValue());
    }

    @AndroidFindBy(xpath = LoginLocator.LOGIN_BUTTON_XPATH)
    private WebElement registrationButton;

    public ProfileScreen openRegistrationForm() {
        waitUntilElementIsVisible(registrationButton);
        registrationButton.click();
        log.info("Open registration form");
        return this;
    }

    @AndroidFindBy(xpath = LoginLocator.MORE_OPTIONS_BUTTON_XPATH)
    private WebElement moreOptionsButton;

    public void showMoreOptionsButton() {
        waitUntilElementIsVisible(moreOptionsButton);
        moreOptionsButton.click();
        log.info("Open more options");
    }

    @AndroidFindBy(xpath = LoginLocator.LOGIN_WITH_EMAIL_BUTTON_XPATH)
    private WebElement signUpWithEmailButton;

    public SignUpPopUpScreen signUpWithEmail() {
        showMoreOptionsButton();

        waitUntilElementIsVisible(signUpWithEmailButton);
        signUpWithEmailButton.click();
        log.info("Sign up with email");
        return new SignUpPopUpScreen(driver);
    }
}
