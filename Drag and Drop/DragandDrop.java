package com.DragandDrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragandDrop {
	WebDriver driver;
	String url = "https://jqueryui.com/droppable/";

	@Test
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(url);
		
		driver.switchTo().frame(0); //switch to frame if  its present
		
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.xpath("//*[@id=\"draggable\"]/p"))).moveToElement(driver.findElement(By.xpath("//*[@id=\"droppable\"]"))).release().build().perform();
	}

}
