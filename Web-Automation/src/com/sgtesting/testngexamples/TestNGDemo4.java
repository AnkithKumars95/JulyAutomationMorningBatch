package com.sgtesting.testngexamples;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDemo4 {
	
	public static WebDriver oBrowser=null;
	public static Logger log=Logger.getLogger("Loop Output");
	
	@Test(priority=1)
	static void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver","G:\\ExampleAutomation\\Automation\\Web-Automation\\Library\\drivers\\chromedriver.exe");
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
	static void navigate()
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
	
	@Test(priority=3,dataProvider="getLoginData")
	static void login(String x,String y)
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys(x);
			oBrowser.findElement(By.name("pwd")).sendKeys(y);
			oBrowser.findElement(By.xpath("//*[@id=\'loginButton\']/div")).click();
			Thread.sleep(4000);
			log.info("login...");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=4)
	static void minimizeFlyoutWindow()
	{
		try
		{
			oBrowser.findElement(By.id("gettingStartedShortcutsPanelId")).click();
			Thread.sleep(2000);
			log.info("minimizeFlyoutWindow...");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=5,dataProvider="getCustomerData")
	static void createCustomer(String x,String y)
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr/td[3]/a")).click();
			oBrowser.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[1]/div[2]/div")).click();
			oBrowser.findElement(By.xpath("/html/body/div[14]/div[1]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.id("customerLightBox_nameField")).sendKeys(x);
			oBrowser.findElement(By.id("customerLightBox_descriptionField")).sendKeys(y);
			oBrowser.findElement(By.id("customerLightBox_commitBtn")).click();
			Thread.sleep(2000);
			log.info("createCustomer...");
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	@Test(priority=6,dataProvider="getModifyCustomerData")
	static void modifyCustomer(String m)
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[4]")).click();
			Thread.sleep(4000);
			oBrowser.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[2]/div[1]/div[3]/div/div[1]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[2]/div[1]/div[3]/div/div[2]/input")).clear();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[2]/div[1]/div[3]/div/div[2]/input")).sendKeys(m);
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[2]/div[1]/div[1]")).click();
			Thread.sleep(2000);
			log.info("modifyCustomer...");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=7)
	static void deleteCustomerser()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[4]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[2]/div[1]/div[4]/div/div")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[2]/div[4]/div/div[3]")).click();
			oBrowser.findElement(By.id("customerPanel_deleteConfirm_submitTitle")).click();
			Thread.sleep(2000);
			log.info("deleteCustomerser...");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=8)
	static void logout()
	{
		try
		{
			oBrowser.findElement(By.id("logoutLink")).click();
			Thread.sleep(2000);
			log.info("logout...");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=9)
	static void close()
	{
		oBrowser.close();
		log.info("close...");
	}
	
	@DataProvider
	public Object[][] getLoginData()
	{
		return new Object[][] {{"admin","manager"}};
	}
	
	@DataProvider
	public Object[][] getCustomerData()
	{
		return new Object[][] {{"usercustomer","Infosys"}};
	}
	
	@DataProvider
	public Object[][] getModifyCustomerData()
	{
		return new Object[][] {{"newusername"}};
	}
}
