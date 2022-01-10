import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.sound.midi.SysexMessage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class JavaScriptExecuter {


    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        /* ---------------------------- JavaScript Executer Methods ----------------------------------





        --------------------------------------------------------------------------------------------*/

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box"); //enter URL
        Thread.sleep(5000);

        //executeScript -- to execute JavaScript code

        WebElement loginBtn = driver.findElement(By.id("submit")); //click button


        flash(loginBtn, driver); //highlight the element

        drawBorder(loginBtn, driver); //draw a border


        //take screenshot:
        // Take screenshot and store as a file format
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // now copy the screenshot to desired location using copyFile //method
        FileUtils.copyFile(src, new File("E:/MyCodeLibrary/MyScreenShot/element.png"));

        //generate Alert
        //generateAlert(driver, "There is an issue with Login button on Login Page");

        //click on any element by using JS executor
        clickElementByJS(loginBtn, driver);

        //refresh the page:
        //1. by using selenium:
        driver.navigate().refresh();

        //2. by using JS executor:
        refreshBrowserByJS(driver);

        //get the tile of the page by JS:
        System.out.println(getTitleByJS(driver));

        //get the page text:
        System.out.println(getPageInnerText(driver));

        //scroll page down:
        //scrollPageDown(driver);

        WebElement forgotPwdLink = driver.findElement(By.xpath("//div[contains(text(),'Book Store Application')]"));
        scrollIntoView(forgotPwdLink, driver);

        String elementposit = getElementPosition(driver,forgotPwdLink);
        System.out.println(elementposit);


    }

    public static void flash(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 10; i++) {
            changeColor("rgb(0,200,0)", element, driver);//1
            changeColor(bgcolor, element, driver);//2
        }
    }

    public static void changeColor(String color, WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
        }
    }


    public static void drawBorder(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='5px dashed red'", element);
    }

    public static void generateAlert(WebDriver driver, String message) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("alert('" + message + "')");

    }

    public static void clickElementByJS(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();", element);

    }

    public static void refreshBrowserByJS(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("history.go(0)");
    }

    public static String getTitleByJS(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String title = js.executeScript("return document.title;").toString();
        return title;
    }

    public static String getPageInnerText(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String pageText = js.executeScript("return document.documentElement.innerText;").toString();
        return pageText;
    }

    public static void scrollPageDown(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public static void scrollIntoView(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }





    public static String getElementPosition(WebDriver driver, WebElement element){

        JavascriptExecutor js = (JavascriptExecutor)driver;
        String left = js.executeScript("return arguments[0].offsetLeft;", element).toString();
        String top = js.executeScript("return arguments[0].offsetTop;", element).toString();
        String both = "LeftPosition; " + left + " TopPosition:  " + top;
        return both;
    }




}


