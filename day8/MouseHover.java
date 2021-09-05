package assignment8.day8;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException, IOException  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/mouseOver.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement testLeafCourses = driver.findElement(By.className("btnMouse"));
		Actions builder=new Actions(driver);
		builder.moveToElement(testLeafCourses).perform();
		
		String firstCourseName = driver.findElement(By.xpath("//a[text()='Selenium']")).getText();
		System.out.println("The first course is : " +firstCourseName);
		
		String secondCourseName = driver.findElement(By.xpath("//a[text()='RPA']")).getText();
		System.out.println("The second course is : " +secondCourseName);
		
		String thirdCourseName = driver.findElement(By.xpath("//a[text()='WebServices']")).getText();
		System.out.println("The third course is : " +thirdCourseName);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='RPA']")).click();
		Alert rpaAlert=driver.switchTo().alert();
		Thread.sleep(2000);
		rpaAlert.accept();
		
		
		
		
		
}
}