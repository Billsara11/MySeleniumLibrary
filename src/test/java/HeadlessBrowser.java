import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


import java.util.concurrent.TimeUnit;

public class HeadlessBrowser {


    public static void main(String[] args) throws InterruptedException {

        //WebDriver driver;
        WebDriverManager.chromedriver().setup();


        //htmlunitdriver is not available in Selenium. S
        //htmlunitdriver -- to use this concept, we have to download compatible htmlunitdriver JAR file.from this website -->
        // https://github.com/SeleniumHQ/htmlunit-driver/releases

        //advantages:
        //1. testing is happening behind the scene -- no browser is launched
        //2. Very fast -- execution of test cases -- very fast -- performance of the script
        //3. not suitable for Actions class -- user actions -- mousemovement, doubleClick, drag and drop
        //4. Ghost Driver -- HeadLess Browser:
        //--HtmlUnit Driver -- JAva
        //--PhantomJS -- JavaScript


        WebDriver driver = new HtmlUnitDriver();

        driver.manage().window().maximize(); //maximize window
        driver.manage().deleteAllCookies(); //delete all the cookies

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("http://www.freecrm.com");

        System.out.println("Before click sinup, title is:===" + driver.getTitle());



        driver.findElement(By.xpath("//span[contains(text(),'sign up')]")).click();

        Thread.sleep(2000);

        System.out.println("after login, title is:===" + driver.getTitle());
    }
}
