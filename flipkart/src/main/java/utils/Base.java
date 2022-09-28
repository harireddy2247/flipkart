package utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Base {
	public static WebDriver driver;
	static String url="https://www.flipkart.com/";
	static By lgn=By.linkText("Login");
	static By unbox=By.xpath("//input[@class='_2IX_2- VJZDxU']");
	static By passbox=By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']");
	static By lgnbtn=By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']");
	static By lgo=By.xpath("//div[contains(text(),'Hari')]//following::*[local-name()='svg' and @class='zZ3yfL']");
	static By lgobtn=By.xpath("//a[@href='#']");
	static By searchbtn=By.xpath("//input[@name='q']");
	




	public static void  openapp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
		driver=new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void login(String un,String pass) throws InterruptedException {
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ofSeconds(3));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(unbox));
		driver.findElement(unbox).sendKeys(un);
		driver.findElement(passbox).sendKeys(pass);
		FluentWait wait1 = new FluentWait(driver);
		wait1.withTimeout(Duration.ofSeconds(30));
		wait1.pollingEvery(Duration.ofSeconds(3));
		wait1.ignoring(NoSuchElementException.class);
		wait1.until(ExpectedConditions.elementToBeClickable(lgnbtn));
		driver.findElement(lgnbtn).click();
		Thread.sleep(4000);
	}

	public static void logout() throws Exception {
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ofSeconds(3));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(lgo));
;		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(lgo)).perform();
		driver.findElement(lgobtn).click();


	}


	public static void closeapp() {
		driver.close();
	}
}

	



