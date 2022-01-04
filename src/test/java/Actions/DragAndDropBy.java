package Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropBy {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();





        driver.manage().window().maximize();
        driver.get("https://demoqa.com/droppable");

        Actions actionProvider = new Actions(driver);
        // Performs dragAndDropBy onto the  target element offset position
        WebElement sourceElement1 = driver.findElement(By.id("draggable"));
        WebElement targetElement1 = driver.findElement(By.id("droppable"));

        int srcEleXOffset = sourceElement1.getLocation().getX();
        int srcEleYOffset = sourceElement1.getLocation().getY();
        System.out.println("sourceonce " + srcEleXOffset + " " + srcEleYOffset);


        int targetEleXOffset = targetElement1.getLocation().getX();
        int targetEleYOffset = targetElement1.getLocation().getY();
        System.out.println("targetonce " + targetEleXOffset + " " + targetEleYOffset);

        // Performs dragAndDropBy onto the  target element offset position
        actionProvider.dragAndDropBy(sourceElement1, targetEleXOffset-712, targetEleYOffset-302).build().perform();



        int sonrasrcEleXOffset = sourceElement1.getLocation().getX();
        int sonrasrcEleYOffset = sourceElement1.getLocation().getY();
        System.out.println("sourcesonra " + sonrasrcEleXOffset + " " + sonrasrcEleYOffset);

        int sonratargetEleXOffset = targetElement1.getLocation().getX();
        int sonratargetEleYOffset = targetElement1.getLocation().getY();
        System.out.println("targetsonra " + sonratargetEleXOffset + " " + sonratargetEleYOffset);





    }
}
