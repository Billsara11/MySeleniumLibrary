import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverNavigationMethods {



    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        /* ---------------------------- Navigation Methods  ------------------------------

        driver.navigate().to(String arg0)       Loads a new web page in the current browser window.
        driver.navigate().to(url)               Exactly the same thing as the driver.get(appUrl) method
        driver.navigate().back()                Same operation as clicking on the Back Button of any browser
        driver.navigate().forward()             Same operation as clicking on the Forward Button of any browser
        driver.navigate().refresh();            Refresh the current page

        ------------------------------------------------------------------------------------------------*/


        driver.navigate().to("http://automationpractice.com/index.php");

        Thread.sleep(2000);

        By clickWomen = By.xpath("//a[@title='Women']");
        WebElement element = driver.findElement(clickWomen);
        element.click();

        Thread.sleep(2000);

        driver.navigate().back();

        Thread.sleep(2000);

        driver.navigate().forward();

        Thread.sleep(2000);

        driver.navigate().refresh();

        Thread.sleep(2000);

        driver.quit();




    }
}
