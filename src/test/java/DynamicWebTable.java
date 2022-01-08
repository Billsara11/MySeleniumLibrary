import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {



    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


         /* ---------------------------- Dynamic Web Table Issues -----------------------------------------

                How to handle dynamic WebTable In Selenium. There are two types of HTML tables published on the web-
                Static tables: Data is static i.e. Number of rows and columns are fixed.
                Dynamic tables: Data is dynamic i.e. Number of rows and columns are NOT fixed.
                Handling static table is easy, but handling dynamic tables in Selenium is a little bit difficult
                as rows and columns are not constant.

                There are two ways of handling WebTable:

                Method – 1:
                • Iterate row and column and get the cell value.
                • Using for loop
                • Get total rows and iterate table
                • Put if(string matches) then select the respective checkbox
                • Lengthy method

                Method – 2:
                • Using custom XPath
                • Using parent and preceding-sibling tags
                • No need to write for loop
                • No full iteration of table
                • Single line statement
                • More dynamic
                • Efficient and fast


        --------------------------------------------------------------------------------------------*/

        driver.get("https://demo.guru99.com/test/web-table-element.php");


//        //Method-1: bu method baska bir sayfa icin yapilmis sayfa degismis oldugu ve bu metot cok dynamic olmadigi icin ugrasmadim
//        String before_xpath = "//*[@id='vContactsForm']/table/tbody/tr[";
//        String after_xpath = "]/td[2]/a";
//
//        for(int i=4; i<=7; i++){
//            String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
//            System.out.println(name);
//            if(name.contains("test2 test2")){ //i=6
//                //*[@id='vContactsForm']/table/tbody/tr[6]/td[1]/input
//                driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr["+i+"]/td[1]/input")).click();
//            }
//        }



        //Method-2:
        // Burada tricky olay su, her refresh edildiginde farkli satir bilgileri yukleyen bir table var.
        // Burada oyle bir locator yapiyoruz ki, tablonun degismeyen bir elemanindan (Company) asagi dogru traverse ediyoruz
        // ve textini aliyoruz. hangi text e sahip olan bir eleman ararsak sadece locator da bir ayarlama yapiyoruz.
        // sayet elementi bulamazsa NoSuchElementException hatasi firlatacagi ve program sonlanacagi icin de bu elementi
        // try catch bloguna koyup bulabilecegimiz bir method yapiyoruz. Bu method u main clasta bir donguye sokup elementi bulana kadar sayfayi refresh ettiroyoruz.

        Thread.sleep(2000);

        //driver.findElement(By.xpath("//th[contains(text(),'Company')]/parent::tr/parent::thead/following-sibling::tbody/tr/td/a[contains(text(),'HDIL')]"));
        // elementimizi firmaya gore dynamic hale getirmek icin yukardaki locator imizi parcalara ayiriyoruz.

        String beforeXpath = "//th[contains(text(),'Company')]/parent::tr/parent::thead/following-sibling::tbody/tr/td/a[contains(text(),'";
        String afterXpath ="')]";
        String companyName = "HDIL";


        while (!existsElement(By.xpath(beforeXpath + companyName + afterXpath), driver)){

            driver.navigate().refresh();


        }

    }

    public static boolean existsElement(By locator, WebDriver driver) {
        try {
            driver.findElement(locator).click();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
