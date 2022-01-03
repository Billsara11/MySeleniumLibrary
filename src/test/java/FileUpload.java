import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {



    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        /* ---------------------------- File Upload and Download  ------------------------------

        1)

         --------------------------------------------------------------------------------------*/

       // For the upload the file

       driver.get("https://demoqa.com/upload-download");

       WebElement uploadFile =driver.findElement(By.id("uploadFile"));

       uploadFile.sendKeys("E:\\MyCodeLibrary\\myTextFile.txt");

    }
}
