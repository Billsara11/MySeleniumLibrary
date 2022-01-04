import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Frame {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize(); //maximize window
        driver.manage().deleteAllCookies(); //delete all the cookies

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        /* ---------------------------- Frame Handling  ------------------------------

        driver.switchTo().frame("frame name or Id");

        ------------------------------------------------------------------------------- */



        driver.get("https://demoqa.com/frames"); //enter URL



        Thread.sleep(3000);

        driver.switchTo().frame("frame1");
        Thread.sleep(2000);

        String frameText = driver.findElement(By.id("sampleHeading")).getText();

        System.out.println(frameText);



    }
}
