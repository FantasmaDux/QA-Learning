package tests.account;

import mobile.dto.AddUserDataDto;
import mobile.enums.AccountTitle;
import mobile.generator.FakeRandomGenerator;
import mobile.helper.TestDescription;
import mobile.screen.JoomHomeScreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static mobile.util.Constants.*;

public class RegistrationUserTest extends BaseTest {

    private final AccountTitle newUserData = FakeRandomGenerator.getRandomOption(AccountTitle.class);

    private final AddUserDataDto addUserDataDto =
            AddUserDataDto.builder()
                    .userFirstName(USER_FIRST_NAME)
                    .userLastName(USER_LAST_NAME)
                    .userEmail(USER_EMAIL)
                    .userPassword(USER_PASSWORD)
                    .userPasswordConfirmation(USER_PASSWORD_CONFIRMATION)
                    .build();

    @Test
    @DisplayName("User registration")
    @TestDescription("Close advertisement, chose country, skip the quiz, open login screen and sign up")
    public void testRegistrationUser() {
        JoomHomeScreen joomHomeScreen = new JoomHomeScreen(driver);

        joomHomeScreen.closeAdvertisement()
                .choseToUseOtherCountry()
                .skipSpinningWheel()
                .openLoginScreen()
                .openRegistrationForm()
                .signUpWithEmail()
                .registrationNewUser(addUserDataDto)
                .verifyUserRegistered(newUserData);

//        userNameTest = //android.widget.Button[@resource-id='com.joom:id/profile_header_name']
//                myOrdersOptTest = //android.widget.GridView[@resource-id='com.joom:id/recycler']/androidx.compose.ui.platform.ComposeView[2]/android.view.View/android.view.View/android.widget.Button


    }
}
