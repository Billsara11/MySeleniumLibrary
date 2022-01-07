import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;





public class WaitSynchronization {



    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        /* ---------------------------- Synchronization Issues -----------------------------------------

        There are 3 type wait options in Selenium (should not use implicit wait and explicit wait together never)

        1) Implicit wait
        2) Explicit wait
        3) FluentWait

        1- Implicit wait -->                                    |       2) Explicit wait -->
               * It`s global wait so can not be customized      |           * can customized it
               * Undocumented/Undefined behavior                |           * very well documented
               * Runs of Remote side of Selenium Webdriver      |           * Runs at the local part of the selenium
               * Only works for findElement(s)                  |           * Not only for web elements also for other options
                                                                |           * can ignore the exceptions


       3)   There is actually very little difference between Explicit wait and Fluent wait.
            According to WebDriverWait source code it says:It will ignore instances of NotFoundException
            that are encountered (thrown) by default in the until condition, and immediately propagate all others.
            You can add more to the ignore list by calling ignoring(exceptions to add)
            The only difference is that by default *element not found exception* is ignored in WebDriverWait.
            The rest of features is all exactly the same with FluentWait since WebDriverWait extends it.


        --------------------------------------------------------------------------------------------*/



        // Implicit wait

        /*
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.ebay.com/");
        */


        // Explicit wait
        /*

                // Initialize and wait till element(link) became clickable - timeout in 10 seconds
                    driver.get("https://www.ebay.com/");


                    WebElement electronicsElement =driver.findElement(By.xpath("//body/div[@id='mainContent']/div[1]/ul[1]/li[5]/a[1]"));
                    WebElement iphonesElement = driver.findElement(By.xpath("//a[contains(text(),'iPhones')]"));

                    Actions actions= new Actions(driver);

                    actions.moveToElement(electronicsElement).perform(); // mouse hover on Electronics (firstElement) link

                    actions.moveToElement(iphonesElement).click();  // click to iphones link
                                                                    // --> this element can not clickable because of synchronization problem


                    // to fix this problem we can use wait method at below -->


                    WebElement clickCameras = new WebDriverWait(driver,10).
                                            until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Cameras & Photo')]")));

                    iphonesElement.click();

                    // you can see the other expected conditions method from link below
                    // --> https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html

    */


        // Fluent wait

        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 5 seconds.

        driver.get("https://www.ebay.com/");


        WebElement electronicsElement =driver.findElement(By.xpath("//body/div[@id='mainContent']/div[1]/ul[1]/li[5]/a[1]"));
        WebElement iphonesElement = driver.findElement(By.xpath("//a[contains(text(),'iPhones')]"));

        Actions actions= new Actions(driver);

        actions.moveToElement(electronicsElement).perform(); // mouse hover on Electronics (firstElement) link

        actions.moveToElement(iphonesElement).click();  // click to iphones link
        // --> this element can not clickable because of synchronization problem

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                            withTimeout(Duration.ofSeconds(10)).
                            pollingEvery(Duration.ofSeconds(2)).
                            withMessage("This is my message");

                        wait.until(ExpectedConditions.elementToBeClickable(iphonesElement)).click();

        // you can see the other expected conditions method from link below
        // --> https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html

}
}
