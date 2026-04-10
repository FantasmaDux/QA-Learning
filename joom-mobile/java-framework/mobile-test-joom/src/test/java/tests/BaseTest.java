package tests;

/*
Настройка запусков тестов и управление драйвером Appium
 */

import io.appium.java_client.AppiumDriver;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mobile.Initializer;
import mobile.helper.Helper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

@Slf4j
public class BaseTest {
    protected static AppiumDriver driver;

    @BeforeEach
    @SneakyThrows // подавляет проверяемые исключения
    public void setUp() {
        log.info("Driver initializing before test\n");
        driver = Initializer.getDriver();
        Helper.setDriver(driver);

        Thread.sleep(4000); // для первого действия без ожидания, то есть ждем, пока прогрузится

        log.info("===== Starting test =====\n");
    }

    @AfterEach
    public void tearDown() {
        log.info("Driver closing after test\n");
        Initializer.quitDriver();
    }
}
