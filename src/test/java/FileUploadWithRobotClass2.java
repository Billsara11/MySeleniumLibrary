import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUploadWithRobotClass2 {

    public static void main(String[] args) throws InterruptedException, AWTException {

        // bu ikinci method mouse cursor u asagiya kadar indirilemdeginden bu sitede javascript methodunu kullanarak cursor u surukledim

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html");
        Thread.sleep(2000);
        Actions act= new Actions(driver);
        WebElement chooseFile=driver.findElement(By.cssSelector("#fileupload1"));



        JavascriptExecutor js = (JavascriptExecutor) driver;
        //This will scroll the page Horizontally till the element is found
        js.executeScript("arguments[0].scrollIntoView();", chooseFile);

       act.moveToElement(chooseFile).click().perform();
       Thread.sleep(2000);

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
