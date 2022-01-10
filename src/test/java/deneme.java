import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class deneme {


    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/documentation/webdriver/");

        String name = "Ali";

       ////div[@id='contact-link']



        driver.findElement(By.xpath("//div[@id='contact-link']"));

        By contactLocator = By.xpath("//button[contains(text(),'Giriş Yap')]");

        WebElement contactButtonElement = driver.findElement(contactLocator);





    }
}
