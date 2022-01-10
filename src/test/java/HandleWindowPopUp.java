import java.util.Iterator;
import java.util.Set;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopUp {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/popup.php");
		
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		
		Thread.sleep(2000);
		
		Set<String> handler = driver.getWindowHandles();
		
		Iterator<String> it = handler.iterator();
		
		String parentWindowId = it.next();
		System.out.println("parent window id:"+ parentWindowId);
		
		
		String childWindowId = it.next();
		System.out.println("Child window id:"+childWindowId);
		
		driver.switchTo().window(childWindowId);
		
		Thread.sleep(2000);
		
		System.out.println("child window pop up url "+driver.getCurrentUrl());
		
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		
		Thread.sleep(2000);
		
		System.out.println("parent window url "+driver.getCurrentUrl());
		
		
		
	}

}
