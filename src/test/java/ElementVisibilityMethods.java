import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ElementVisibilityMethods {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies

        /*----------------------- Element Visibility Methods ---------------------------------

        Difference between isDisplayed(), isEnabled() and isSelected() Methods in Selenium WebDriver:

        1. isDisplayed() is the method used to verify the presence of a web element within the web page.
        The method returns a “true” value if the specified web element is present on the web page and a “false” value
        if the web element is not present on the webpage.
        2. isDisplayed() is capable to check for the presence of all kinds of web elements available.
        3. isEnabled() is the method used to verify if the web element is enabled or disabled within the web page.
        4. isEnabled() is primarily used with buttons.
        5. isSelected() is the method used to verify if the web element is selected or not.
        6. isSelected() method is predominantly used with radio buttons, dropdowns and checkboxes.

        ---------------------------------------------------------------------------------------*/


/*

        //1. isDisplayed() method: applicable for all the elements. Elementin sayfada gorunur olup olmadigini belirler
        // <div id="myDIV" style="display: none;">This is my DIV element.</div>

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_style_display"); // enter URL
        driver.switchTo().frame("iframeResult");
        boolean a1 = driver.findElement(By.id("myDIV")).isDisplayed();
        System.out.println("is displayed: tr " + a1); //true

        //2. isEnabled() method: Elementin sayfada kullanici ile etkilesime acik olup olmadigini belirler. Button tiklanabilr durumda mi yani
        // <button type="button" enabled="">Click Me!</button>
        // <button type="button" disabled="">Click Me!</button>

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_button_disabled"); // enter URL
        driver.switchTo().frame("iframeResult");
        boolean b1 = driver.findElement(By.xpath("//button[contains(text(), 'Click Me')]")).isEnabled();
        System.out.println("is enabled - tr: "+b1); //false

*/

        //3. isSelected() method: only applicable for checkbox, dropdown, radiobutton. elementin secili olup olmadigini belirler

        driver.get("https://demoqa.com/checkbox");
        Thread.sleep(3000);
        boolean isSelected = driver.findElement(By.id("tree-node-home")).isSelected();
        System.out.println("is selected - fl: "+ isSelected); //false

        // after select
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[@for='tree-node-home']/span")).click();
        boolean isSelected2 = driver.findElement(By.id("tree-node-home")).isSelected();
        System.out.println("is selected - tr: "+ isSelected2); //true




        //4. is exist --> Selenium da boyle bir method yok ama kendi yaptigim main method disindaki
        // bu metodla sayfada boyle bir element var mi yokmu yu anlayabilirim
        driver.get("https://demo.guru99.com/test/web-table-element.php");

        String beforeXpath = "//th[contains(text(),'Company')]/parent::tr/parent::thead/following-sibling::tbody/tr/td/a[contains(text(),'";
        String afterXpath ="')]";
        String companyName = "NCC";

        while (!isElementExist(By.xpath(beforeXpath + companyName + afterXpath), driver)){

            driver.navigate().refresh();
        }


    }
    //4. is exist --> Selenium da boyle bir method yok ama kendi yaptigim bu metodla sayfada boyle bir element var mi yokmu yu anlayabilirim
    public static boolean isElementExist(By locator, WebDriver driver) {
        try {
            driver.findElement(locator).click();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
