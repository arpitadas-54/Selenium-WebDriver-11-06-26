package com.newwindow;

import java.io.FileReader;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;

public class CSVTestDemo {
	WebDriver driver;
	String url = "https://only-testing-blog.blogspot.com/2014/05/form.html";
	String FilePath = "C:\\Coforge\\Selenium Java Csv.csv";

	@BeforeTest
	public void setUp() throws Exception{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}
		
	@Test
	public void locatorTesting() throws Exception {
		CSVReader reader = new CSVReader(new FileReader(FilePath));
		String[] csvCell;
		while ((csvCell = reader.readNext()) != null) {
			String FName = csvCell[0];
			String LName = csvCell[1];
			String Email = csvCell[2];
			String MNumb = csvCell[3];
			String CName = csvCell[4];
			
			driver.findElement(By.name("FirstName")).sendKeys(FName);
			driver.findElement(By.name("LastName")).sendKeys(LName);
			driver.findElement(By.name("EmailID")).sendKeys(Email);
			driver.findElement(By.name("MobNo")).sendKeys(MNumb);
			driver.findElement(By.name("Company")).sendKeys(CName);
		  
			driver.findElement(By.xpath("//input[@value='Submit']")).click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
				
			}
			
		}
	}
