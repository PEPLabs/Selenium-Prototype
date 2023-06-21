import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.File;

public class SeleniumTest {
    private WebDriver webDriver;

    @Before
    public void setUp() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");//linux_64

        // Get file
        File file = new File("index.html");
        String path = "file://" + file.getAbsolutePath();
        //File chromeBinary = new File("./chrome/chrome");

        // Create a new ChromeDriver instance
        ChromeOptions options = new ChromeOptions();
        //options.setBinary("./chrome/chrome-linux64/chrome");
        options.addArguments("headless");
        webDriver = new ChromeDriver(options);


        // Open the HTML file
        webDriver.get(path);
    }

    @After
    public void tearDown() {
        // Close the browser
        webDriver.quit();
    }

    @Test
    public void testPageText() throws InterruptedException {
        WebElement test = webDriver.findElement(By.id("test"));
        System.out.println(test.getText());
        Assert.assertEquals("Test", test.getText());
        Thread.sleep(500);
    }


}
