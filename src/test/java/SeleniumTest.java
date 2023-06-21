import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;

public class SeleniumTest {
    private WebDriver webDriver;

    @Before
    public void setUp() {
        // Set up ChromeDriver path
        //System.setProperty("webdriver.chrome.driver", "./chromedriver");//linux_64
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");//windows_64

        // Create a new ChromeDriver instance
        webDriver = new ChromeDriver();
        File file = new File("./index.html");

        // Open the HTML file
        webDriver.get(file.getAbsolutePath());
    }

    @After
    public void tearDown() {
        // Close the browser
        webDriver.quit();
    }

    @Test
    public void testPageText() throws InterruptedException {
        WebElement test = webDriver.findElement(By.id("test"));
        Assert.assertEquals("Test", test.getText());
        Thread.sleep(500);
    }


}
