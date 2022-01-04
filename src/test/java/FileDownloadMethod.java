import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FileDownloadMethod {

        WebDriver driver;
        File folder;

        @BeforeMethod
        public void setUp(){

            folder= new File(UUID.randomUUID().toString());
            folder.mkdir();

            //chrome
            WebDriverManager.chromedriver().setup();

            ChromeOptions options=new ChromeOptions();

            Map<String, Object> prefs= new HashMap<String, Object>();
            prefs.put("profile.default_content_settings.popups", 0);
            prefs.put("download.default_directory", folder.getAbsolutePath());

            options.setExperimentalOption("prefs", prefs);
            DesiredCapabilities cap=DesiredCapabilities.chrome();
            cap.setCapability(ChromeOptions.CAPABILITY, options);

            driver = new ChromeDriver(cap);

        }

        @Test
        public void downloadFileTest() throws InterruptedException {

            driver.get("https://demoqa.com/upload-download");
            driver.findElement(By.id("downloadButton")).click();

            // wait for to download file
            Thread.sleep(3000);

            File listOfFiles[] = folder.listFiles();
            // make sure the directory is not empty
            Assert.assertTrue(listOfFiles.length>0);

            for(File file :listOfFiles){
                //make sure that download file is not empty
                Assert.assertTrue(file.length()>0);

            }




        }


        @AfterMethod
        public void tearDown(){

            driver.quit();
            for (File file: folder.listFiles()){
                file.delete();
            }
            folder.delete();



        }


}
