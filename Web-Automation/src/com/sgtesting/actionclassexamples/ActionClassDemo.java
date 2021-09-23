package com.sgtesting.actionclassexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassDemo {

	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		mouseOperations();
	}
	static void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", ".\\Library\\drivers\\chromedriver.exe");
			oBrowser=new ChromeDriver();
			oBrowser.manage().window().maximize();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void navigate()
	{
		try
		{
			oBrowser.get("https://www.flipkart.com/");
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void mouseOperations()
	{
		try
		{
			Actions oMouse=new Actions(oBrowser);
			WebElement oClose=oBrowser.findElement(By.xpath("//button[text()='✕']"));
			oMouse.click(oClose).build().perform();
			Thread.sleep(2000);

			WebElement oGrocery=oBrowser.findElement(By.xpath("//img[@alt='Grocery']"));
			oMouse.doubleClick(oGrocery).build().perform();
			Thread.sleep(2000);
			WebElement ofv=oBrowser.findElement(By.xpath("//img[@alt='Fruits & Vegetables']"));
			oMouse.moveToElement(ofv).build().perform();
			Thread.sleep(2000);
			oMouse.contextClick(ofv).build().perform();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
