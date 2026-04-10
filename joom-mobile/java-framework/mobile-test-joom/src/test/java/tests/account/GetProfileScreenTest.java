package tests.account;

import mobile.helper.TestDescription;
import mobile.screen.JoomHomeScreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static mobile.enums.LoginTitle.LOGIN_TITLE;

public class GetProfileScreenTest extends BaseTest {

    @Test
    @DisplayName("Open login screen")
    @TestDescription("Close advertisement, chose country, skip the quiz, open login screen")
    public void openLoginScreenTest() {
        JoomHomeScreen joomHomeScreen = new JoomHomeScreen(driver);

        joomHomeScreen.closeAdvertisement()
                .choseToUseOtherCountry()
                .skipSpinningWheel()
                .openLoginScreen()
                .verifyLoginScreenOpened(LOGIN_TITLE);

    }

}
