package assignment8.day8;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropByPosition {
	
	public static void main(String[] args) throws InterruptedException, IOException  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drop.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement elementToDrag = driver.findElement(By.id("draggable"));
		WebElement elementToDrop = driver.findElement(By.id("droppable"));
		Point p=elementToDrag.getLocation();
		int x=p.getX();
		int y=p.getY();
		//WebElement elementToDrop = driver.findElement(By.id("droppable"));
		Actions builder=new Actions(driver);
		builder.dragAndDropBy(elementToDrop, x, y).perform();
	}

}
