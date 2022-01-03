

import io.github.bonigarcia.wdm.WebDriverManager;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class FileUploadWithRobotClass {

    public static void main(String[] args) throws InterruptedException, AWTException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/upload-download");
        Thread.sleep(2000);
        Actions act= new Actions(driver);
        WebElement chooseFile=driver.findElement(By.id("uploadFile"));


        act.moveToElement(chooseFile).click().perform();

        Thread.sleep(4000);

        uploadFile("E:\\MyCodeLibrary\\myTextFile.txt");

    }

    public static void setClipBoard(String file) {
        StringSelection obj= new StringSelection(file);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(obj, null);
    }

    public static void uploadFile(String filePath) throws AWTException {
        setClipBoard(filePath);
        Robot rb= new Robot();
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }


}
