import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DirectlyUnderWebdriverMethods {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        /* ---------------------------- Directly Under WebDriver Methods  ------------------------------

        driver.get(url);                Load the website
        driver.getTitle();              Get website title
        driver.getTitle().length();     Get titel`s lenght
        driver.getPageSource();         Get web page source code
        driver.pageSource.length()      Get web page source lenght
        driver.close();                 Close only the current window
        driver.quit();                  Closes all windows opened by the WebDriver

        ------------------------------------------------------------------------------------------------*/


        // Storing the Application Url in the String variable
        String url = "http://automationpractice.com/index.php";

        //Launch the WebSite
        driver.get(url);

        // Storing Title name in the String variable
        String title = driver.getTitle();

        // Storing Title length in the Int variable
        int titleLength = driver.getTitle().length();

        // Printing Title & Title length in the Console window
        System.out.println("Title of the page is : " + title);
        System.out.println("Length of the title is : "+ titleLength);

        // Storing Page Source in String variable
        String pageSource = driver.getPageSource();
        //System.out.println(pageSource);

        // Storing Page Source length in Int variable
        int pageSourceLength = pageSource.length();

        // Printing length of the Page Source on console
        System.out.println("Total length of the Pgae Source is : " + pageSourceLength);

        // wait here 2 seconds
        Thread.sleep(2000);

        //Closing current browser
        driver.close();

        // Closing all browser
        driver.quit();




    }



}
