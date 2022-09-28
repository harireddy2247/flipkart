package Testcases;
import utils.Base;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

public class TC002 extends Base {
	static By searchbox=By.name("q");
	static By searchbtn=By.xpath("//button[@class='L0Z3Pu']");
	static By item=By.xpath("//div[@data-id='MOBG6VF5WA2CZWF2']//child::*//child::a[@class='_1fQZEK']");
	static By notifybtn=By.xpath("//button[contains(text(),'NOTIFY ME')]");
	static By intobtn=By.xpath("//button[@class='_2KpZ6l _2doB4z']");
	static By newitem=By.xpath("//a[contains(text(),'APPLE iPhone 13 Pro Max (Sierra Blue, 256 GB)')]//following::a[contains(text(),'APPLE iPhone 13 Pro Max (Sierra Blue, 1 TB)')]");
	                           @Test
	public static void TC002() {
		try {
		
		Base b=new Base();
		b.openapp();
		b.login("9393729999","hari2247");
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(searchbox)));
		driver.findElement(searchbox).sendKeys("iphone 13 pro max");
		driver.findElement(searchbtn).click();
		Thread.sleep(3000);
		String currentwindow=driver.getWindowHandle();
		driver.findElement(item).click();
		ArrayList<String> handles=new ArrayList<String>(driver.getWindowHandles());
		for(String child:handles) {
		System.out.println(child);
		}
		driver.switchTo().window(handles.get(1));
		b.logout();
		b.closeapp();
		driver.switchTo().window(handles.get(0));
		b.logout();
		Thread.sleep(5000);
		b.closeapp();
		}
	catch (Exception e) {
		System.out.println(e);
	}
}
}


