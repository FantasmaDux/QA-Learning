package mobile.util;

import lombok.extern.slf4j.Slf4j;
import mobile.Initializer;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

@Slf4j
public class UtilsMethod {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = Initializer.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (input == null) {
                log.error("Unable to find config.properties");
                throw new IllegalStateException("File config.properties not found");
            }

            properties.load(input);

        } catch (Exception e) {
            log.error("Failed to load config: ", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static String getValue(String key) {
        if (key.equals("USER_EMAIL")) {
            return generateDynamicEmail();
        }
        return properties.getProperty(key);
    }

    private static String generateDynamicEmail() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timeStamp = dateFormat.format(new Date());
        return "email" + timeStamp + "@test.com";
    }

}
