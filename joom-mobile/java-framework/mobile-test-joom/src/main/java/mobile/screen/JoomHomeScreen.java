package mobile.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import mobile.locator.JoomHomeLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Slf4j
@Setter
public class JoomHomeScreen extends BaseScreen {

    public JoomHomeScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public JoomHomeScreen closeAdvertisement() {
        int xCoordinates = 997;
        int yCoordinates = 188;

        tapByCoordinates(xCoordinates, yCoordinates);
        log.info("Advertisement closed");

        return new JoomHomeScreen(driver);
    }

    @AndroidFindBy(xpath = JoomHomeLocator.SKIP_SPINNING_WHEEL_XPATH)
    private WebElement skipSpinningWheel;

    public JoomHomeScreen skipSpinningWheel() {
        waitUntilElementIsVisible(skipSpinningWheel);
        skipSpinningWheel.click();
        log.info("Skipping Spinning Wheel");
        return new JoomHomeScreen(driver);
    }

    public JoomHomeScreen choseToUseOtherCountry() {
        int xCoordinates = 545;
        int yCoordinates = 1649;

        tapByCoordinates(xCoordinates, yCoordinates);
        log.info("Country chosen");

        return new JoomHomeScreen(driver);
    }
}
