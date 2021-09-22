package com.sgtesting.testngexamples;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDemo1 {
	
public static WebDriver oBrowser=null;
public static Logger log=Logger.getLogger("Loop Output");
	
	@Test(priority=1)
	public void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "G:\\ExampleAutomation\\Automation\\Web-Automation\\Library\\drivers\\chromedriver.exe");
			oBrowser=new ChromeDriver();
			Thread.sleep(2000);
			oBrowser.manage().window().maximize();
			log.info("launchBrowser ...");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=2)
	public void navigate()
	{
		try
		{
			oBrowser.get("http://localhost:82/login.do");
			Thread.sleep(4000);
			log.info("navigate...");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=4)
	public void closeApplication()
	{
		try
		{
			oBrowser.close();
			log.info("closeApplication...");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=3,dataProvider="getLoginData")
	public void login(String user,String pwd)
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys(user);
			oBrowser.findElement(By.name("pwd")).sendKeys(pwd);
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(4000);
		//	oBrowser.findElement(By.id("gettingStartedShortcutsPanelId")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.linkText("Logout")).click();
			log.info("login...");
			Thread.sleep(2000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

	@DataProvider
	public Object[][] getLoginData()
	{
		return new Object[][] {{"admin","manager"},
			{"admin","manager"},
			{"admin","manager"}};
	}
}
