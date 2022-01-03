import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.print.PrintOptions;

import java.util.Set;

public class DriverManageMethods {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    /* ---------------------------- Manage Methods  ------------------------------

        driver.manage().window().maximize();                        Maximize the window
        driver.manage().window().getPosition();                     Get window position
        driver.manage().window().setPosition(new Point(0, 0));      Set window position
        driver.manage().window().fullscreen();                      Full screen to window
        driver.manage().addCookie(new Cookie("test1", "cookie1"));
        driver.manage().getCookies();

        ------------------------------------------------------------------------------------------------*/

        driver.get("http://automationpractice.com/index.php");

        driver.manage().window().maximize();


        Point position = driver.manage().window().getPosition();
        int x1 = position.getX();
        int y1 = position.getY();
        System.out.println("x : " +x1 );
        System.out.println("y : "+ y1 );

        Thread.sleep(2000);

        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().maximize();

        driver.manage().window().fullscreen();
        driver.manage().addCookie(new Cookie("test1", "cookie1"));
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("alll cokies"+cookies);


        /*----------------------Selenium 4 feature ----------------------------------------*/

        //        driver.get("https://www.selenium.dev");
//        PrintsPage printer = (PrintsPage) driver;
//
//        PrintOptions printOptions = new PrintOptions();
//        printOptions.setPageRanges("1-2");
//
//        Pdf pdf = printer.print(printOptions);
//        String content = pdf.getContent();
//        System.out.println(content);
    }
}
