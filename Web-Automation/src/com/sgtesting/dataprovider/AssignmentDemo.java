package com.sgtesting.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AssignmentDemo {

	public static WebDriver oBrowser=null;
	
	@Test(priority=1)
	public static void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "G:\\ExampleAutomation\\Automation\\Web-Automation\\Library\\drivers\\chromedriver.exe");
			oBrowser=new ChromeDriver();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=2)
	public static void navigate()
	{
		try
		{
			oBrowser.get("http://localhost:82/login.do");
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority=3,dataProvider="getLoginData")
	public static void login(String user,String pass)
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys(user);
			oBrowser.findElement(By.name("pwd")).sendKeys(pass);
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	@Test(priority=4)
	public static void logout()
	{
		try
		{
			oBrowser.findElement(By.linkText("Logout")).click();
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@DataProvider
	public Object[][] getLoginData()
	{
		return new Object[][] {{"admin","manager"},{"admin","manager"},{"admin","manager"}};
	}
}
