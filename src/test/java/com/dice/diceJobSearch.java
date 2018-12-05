package com.dice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class diceJobSearch {

	public static void main(String[] args) {
		// setup chrome driver path
		WebDriverManager.chromedriver().setup();
		//invoke selenium webdriver
		WebDriver driver = new ChromeDriver();
		//fullscreen
		driver.manage().window().fullscreen();
		//set universal wait time in case web page is slow
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = "https://dice.com";
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Find Jobs in Tech | Dice.com";
		
//		if (actualTitle.equals(expectedTitle)) {
//			System.out.println("Dice homepage succesfully loaded");
//		}else {
//			System.out.println("Step FAIL");
//			// to make the code execution stops in case we did'nt meet the criteria
//			 throw new RuntimeException("Step FAIL");
//		}
		driver.get(url);
		String keyWord = "java developer";
		driver.findElement(By.id("search-field-keyword")).clear();
		driver.findElement(By.id("search-field-keyword")).sendKeys(keyWord);
		
		String location = "22182";
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys(location);
		
		driver.findElement(By.id("findTechJobs")).click();
		
//		String count = driver.findElement(By.id("posiCountMobileId")).getText();
//		System.out.println(count);
//		int countResult = Integer.parseInt(count.replace(",", ""));
//		if (countResult>0) {
//			System.out.println("step PASS:keyword: "+keyWord +" searchResult "+countResult+" results in "+location);
//		}else {
//			System.out.println("step FAIL :keyword: "+keyWord +" searchResult "+countResult+" results in "+location);
//		}
		
		driver.close();
		
	}

}
