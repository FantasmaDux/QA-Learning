package mobile.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.extern.slf4j.Slf4j;
import mobile.enums.LoginTitle;
import mobile.helper.Helper;
import mobile.locator.JoomHomeLocator;
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
}
