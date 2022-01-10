import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {



    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        /* ---------------------------- Locator Strategies  ------------------------------

        1) By.id("firstname"))
        2) By.name("firstname"))
        3) By.className("ancAsb"))
        4) By.tagName("asder")
        5) By.linkText("Sign in"))
        6) By.partialLinkText("How to pick")
        7) By.cssSelector("#address1"))
        8) By.xpath("//*[@id='firstname']"))
        9) Relative Locators --> Selenium 4 new feature --> https://www.selenium.dev/documentation/webdriver/elements/locators/

        -- xPath strategies --

            ** tagname -----------------------------

            //htmlTagname[@attributename='value']

            //tagname[ NOT(@attributeName =‘attributeValue’)

            //htmlTagname[@attributename='value' and @attributename='value']

            //button[@type='button' and @class='btn']

            //tagName[@AN1=’AV1’][ @AN2=’AV2’]

            //tagName[@AN1=’AV1’] | //tagName[@AN2=’AV2’]

            //div[@class='dropdown']//button[@type='button' and @class='btn btn-secondary dropdown-toggle' and @id='dropdownMenuButton']

            //button[@id='dropdownMenuButton']



            ** link: -----------------------------------

                //a[text()='text value of the element']  first option
                //a[contains(text(),'text value of the element')] --recommended
                //tagName[contains(@attributeName,’attributeValue’)]
                //tagName[.=’text value of the element’] --not recommend
                //input[starts-with(@id,'test_')]
                //input[ends-with(@id,'_test_t')]


            ** Group Index: ----------------------------

            //div[@class='popup_menu_label'])[1]


            ** Axes

            ---- html codes -----------------
            <select id"day" title="Day" multiple>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
            </select>
            ---------------------------------

                * Child (/) ------------------> traverses to the immediate child element same as

                           /html/body/select/option[5] ----> html/body/select/child::option[5]

                                    return --> 5 th day

                * descendant (//) ------------> traverses to any child element same as

                            //option[5] ----> descendant::option[5]

                                    return --> 5 th day

                * parent(/..)  ---------------> traverses to the immediate parent element same as

                            //option[5]/..   ----> descendant::option[5]/..

                                    return --> it will highlight SELECT tag

                * ancestor  ------------------> traverses to any parent element

                             //option[5]/ancestor::html

                                    return --> it will highlight HTML tag

                * preceding-sibling   --------> traverses within the siblings in upward direction

                        descendant::option[5]/preceding-sibling::option     return --> 1 2 3 4
                        descendant::option[5]/preceding-sibling::option[1]  return --> 4
                        descendant::option[5]/preceding-sibling::option[2]  return --> 3
                        descendant::option[5]/preceding-sibling::option[3]  return --> 2
                        descendant::option[5]/preceding-sibling::option[4]  return --> 1
                        descendant::option[5]/preceding-sibling::option[last()] return --> 1
                        descendant::option[5]/preceding-sibling::option[last()-1] return --> 2
                        descendant::option[5]/preceding-sibling::option[position()=1] return --> 4
                        descendant::option[5]/preceding-sibling::option[position()=last()] return --> 1

                * following-sibling  ---------> traverses within the siblings in downward

                         //option[5]/following-sibling::option[1]       return --> 6
                         //option[5]/following-sibling::option[2]       return --> 7
                         //option[5]/following-sibling::option[3]       return --> 8
                         //option[5]/following-sibling::option[4]       return --> 9
                         //option[5]/following-sibling::option[last()]  return --> 10
                         //option[5]/following-sibling::option[position()=last()] return --> 10




        -----------------------------------------------------------------------------------------------------------------*/









    }
    }
