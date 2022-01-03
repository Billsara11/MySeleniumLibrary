import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScriptAlertPopUp {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        /* ---------------------------- JavaScript Alert and PopUp -----------------------------------------

            * Alert alert = driver.switchTo().alert();      This method switch to alert.

                alert.sendKeys("my message");       This method sends data to the alert box. (doesnt work with chrome there is a bug)
                alert.getText();                    This method gets the alert message text
                alert.accept();                     This method clicks on the 'OK' button of the alert box.
                alert.dismiss();                    This method clicks on 'Cancel' button of the alert box.



        --------------------------------------------------------------------------------------------*/

        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.id("promtButton")).click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        //Wait for the alert to be displayed and store it in a variable
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();    // This method switch to alert.
                                Thread.sleep(2000);

        alert.sendKeys("my message");       // This method sends data to the alert box.
                                Thread.sleep(2000);
        alert.getText();
                String alertMessage= alert.getText();  // This method gets the alert message text
                System.out.println(alertMessage);
                                Thread.sleep(2000);

        alert.accept();             // This method clicks on the 'OK' button of the alert box.

        // alert.dismiss();         // when the 'Cancel' button clicks in the alert box.




    }
    }
