package mobile.helper;

/*
Методы для считывания с экрана
 */

import io.appium.java_client.AppiumDriver;
import lombok.Setter;

public class Helper {
    @Setter // этим драйвером будем пользоваться и в других классах
    private static AppiumDriver driver;

    public static boolean isTextOnScreen(String expectedText) {
        return driver.getPageSource().contains(expectedText);
    }
}
