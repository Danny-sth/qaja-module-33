import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

// java -Dwebdriver.chrome.driver=$(pwd)/chromedriver -jar $(pwd)/selenium-server-standalone-3.141.59.jar
public class SimpleTest {
    public RemoteWebDriver driver;
    public static final String SELENIUM_URL = "http://localhost:4444/wd/hub";

    @BeforeTest
    public void start() throws Exception {
        this.driver = new RemoteWebDriver(
                new URL(SELENIUM_URL),
                new ChromeOptions());
    }

        @Test
        public void openGooglePageTest() throws InterruptedException {
            this.driver.get("http://google.com/");
            Thread.sleep(3000);
        }

        @AfterTest
    public void closeBrowser() {
        this.driver.close();
        this.driver.quit();
        }


}
