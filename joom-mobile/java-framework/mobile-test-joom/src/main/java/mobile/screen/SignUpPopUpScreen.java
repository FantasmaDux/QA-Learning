package mobile.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mobile.dto.AddUserDataDto;
import mobile.enums.AccountTitle;
import mobile.helper.Helper;
import mobile.locator.SignUpPopUpLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
public class SignUpPopUpScreen extends BaseScreen {

    public SignUpPopUpScreen(AppiumDriver driver) {
        super(driver);

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = SignUpPopUpLocator.SIGN_UP_BUTTON_XPATH)
    private WebElement signUpButton;

    public void signUp() {
        waitUntilElementIsVisible(signUpButton);
        signUpButton.click();
    }

    @AndroidFindBy(xpath = SignUpPopUpLocator.INPUT_FIRST_NAME_FIELD_XPATH)
    private WebElement firstNameField;

    public void setFirstName(String firstName) {
        waitUntilElementIsVisible(firstNameField);
        firstNameField.click();
        firstNameField.sendKeys(firstName);
    }

    @AndroidFindBy(xpath = SignUpPopUpLocator.INPUT_LAST_NAME_FIELD_XPATH)
    private WebElement lastNameField;

    public void setLastName(String lastName) {
        waitUntilElementIsVisible(lastNameField);
        lastNameField.click();
        lastNameField.sendKeys(lastName);
    }

    @AndroidFindBy(xpath = SignUpPopUpLocator.INPUT_EMAIL_FIELD_XPATH)
    private WebElement emailField;

    public void setEmail(String email) {
        waitUntilElementIsVisible(emailField);
        emailField.click();
        emailField.sendKeys(email);
    }

    @AndroidFindBy(xpath = SignUpPopUpLocator.INPUT_PASSWORD_FIELD_XPATH)
    private WebElement passwordField;

    public void setPassword(String password) {
        waitUntilElementIsVisible(passwordField);
        passwordField.click();
        passwordField.sendKeys(password);
    }

    @AndroidFindBy(xpath = SignUpPopUpLocator.INPUT_PASSWORD_CONFIRMATION_FIELD_XPATH)
    private WebElement passwordConfirmationField;

    public void setPasswordConfirmation(String passwordConfirmation) {
        waitUntilElementIsVisible(passwordConfirmationField);
        passwordConfirmationField.click();
        passwordConfirmationField.sendKeys(passwordConfirmation);
    }

    @AndroidFindBy(xpath = SignUpPopUpLocator.FINISH_SIGN_UP_BUTTON_XPATH)
    private WebElement continueSignUpButton;

    public void continueSignUp() {
        waitUntilElementIsVisible(continueSignUpButton);
        continueSignUpButton.click();
        log.info("finish sign up");
    }

    @SneakyThrows
    public SignUpPopUpScreen registrationNewUser(AddUserDataDto addUserDataDto) {
        signUp();
        setFirstName(addUserDataDto.getUserFirstName());
        setLastName(addUserDataDto.getUserLastName());
        setEmail(addUserDataDto.getUserEmail());
        setPassword(addUserDataDto.getUserPassword());
        setPasswordConfirmation(addUserDataDto.getUserPasswordConfirmation());

        log.info("Registration user '{}' success", addUserDataDto.getUserEmail());

        continueSignUp();
        Thread.sleep(1000);
        return this;
    }

    public void verifyUserRegistered(AccountTitle accountTitle) {
        assertThat(Helper.isTextOnScreen(accountTitle.getValue()))
                .as("check if text %s is displayed", accountTitle.getValue())
                .isTrue();

        log.info("Verified '{}' text is visible", accountTitle.getValue());
    }

}
