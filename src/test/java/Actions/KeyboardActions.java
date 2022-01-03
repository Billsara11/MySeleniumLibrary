package Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        /* ---------------------------- Keyboard actions ------------------------------



        -----------------------------------------------------------------------------------------*/

        driver.get("https://google.com");

        WebElement searchElement = driver.findElement(By.name("q"));


        // Enter "webdriver" text and perform "ENTER" keyboard action
       searchElement.sendKeys("webdriver" + Keys.ENTER);

        Actions actionProvider = new Actions(driver);

        Action keydown = actionProvider.keyDown(Keys.CONTROL).sendKeys("a").build(); // Ctrl + a

        keydown.perform();



      /*  Actions actionProvider2 = new Actions(driver);
        driver.get("https://google.com");
        WebElement search2 = driver.findElement(By.name("q"));
        //Thread.sleep(2000);

        Action shiftLetter = actionProvider2.keyDown(Keys.SHIFT).sendKeys(search2,"qwerty").
                                        keyUp(Keys.SHIFT).sendKeys("qwerty").build();


        shiftLetter.perform(); */




}
}
