package Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;

public class MouseActions {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        /* ---------------------------- Mouse actions ------------------------------

            * clickAndHold(WebElement) -->Clicks (without releasing) in the middle of the given element.
                                This is equivalent to: Actions.moveToElement(onElement).clickAndHold()

            * contextClick(WebElement) --> Performs a context-click (right click) at middle of the given element.
                                First performs a mouseMove to the location of the element.

            * doubleClick(WebElement)    --> It will move to the element and performs a double-click
                                            in the middle of the given element.

            * moveToElement(WebElement) --> This method moves the mouse to the middle of the element.
                                           The element is also scrolled into the view on performing this action.

            * dragAndDrop(sourceElement, targetElement) --> performs click-and-hold at the location of the source element,
                                                           moves to the location of the target element, then releases the mouse.

            * dragAndDropBy(sourceElement1, targetEleXOffset, targetEleYOffset) --> This method moves the mouse from
                                                                    its current position (or 0,0) by the given offset. duzgun calismiyour

            * release().build().perform();  --> Releases the depressed left mouse button at the current mouse location.

        -----------------------------------------------------------------------------------------*/

        driver.get("https://demoqa.com/sortable");

        WebElement gridElement= driver.findElement(By.id("demo-tab-grid"));

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(2)).
                withMessage("This is my message");

        wait.until(ExpectedConditions.elementToBeClickable(gridElement)).click();


        // Store 'google search' button web element
        WebElement gridButtonOne = driver.findElement(By.xpath("//div[@class='create-grid']/div[1]"));
        WebElement gridButtonTwo = driver.findElement(By.xpath("//div[@class='create-grid']/div[2]"));
        WebElement gridButtonNine = driver.findElement(By.xpath("//div[@class='create-grid']/div[9]"));
        WebElement gridButtonFive = driver.findElement(By.xpath("//div[@class='create-grid']/div[5]"));



        Actions actionProvider = new Actions(driver);

        // This method moves the mouse from its current position (or 0,0) by the given offset.
        int xOffset = gridButtonFive.getRect().getX();
        int yOffset = gridButtonFive.getRect().getY();
        System.out.println(xOffset + " " + yOffset);
        actionProvider.moveByOffset(xOffset,yOffset).build().perform();

        //Moves the mouse to an offset from the top-left corner of the element. The element is scrolled
        // actionProvider.moveToElement(gridElement,25,35).build().perform();

        // moves the mouse to the middle of the element
        actionProvider.moveToElement(gridButtonNine).build().perform();

        // Perform click-and-hold action on the element
        actionProvider.clickAndHold(gridButtonOne).build().perform();

        // Perform double click to elemet
        actionProvider.doubleClick(gridButtonTwo).build().perform();


         // perform right click to element
         actionProvider.contextClick(gridButtonOne).build().perform();

        driver.get("https://demoqa.com/droppable");

        // Performs drag and drop action of sourceEle onto the targetEle
        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droppable"));

        actionProvider.dragAndDrop(sourceElement, targetElement).build().perform();


        // releases the depressed left mouse button
        driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
        // Store 'box A' as source element
        WebElement sourceEle = driver.findElement(By.id("draggable"));
        // Store 'box B' as source element
        WebElement targetEle = driver.findElement(By.id("droppable"));

        actionProvider.clickAndHold(sourceEle).moveToElement(targetEle).build().perform();

        // Performs release event
        actionProvider.release().build().perform();



    }
    }
