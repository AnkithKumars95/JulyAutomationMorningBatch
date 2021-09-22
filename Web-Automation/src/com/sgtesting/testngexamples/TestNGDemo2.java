package com.sgtesting.testngexamples;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDemo2 {
	
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
	
	@Test(priority=5,dataProvider="getUserData")
	static void createUser(String x,String y,String z,String a,String b)
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='topnav']/tbody/tr[1]/td[5]/a/div[2]")).click();
			oBrowser.findElement(By.xpath("//*[@id=\'createUserDiv\']/div")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.id("userDataLightBox_firstNameField")).sendKeys(x);
			oBrowser.findElement(By.id("userDataLightBox_lastNameField")).sendKeys(y);
			oBrowser.findElement(By.id("userDataLightBox_emailField")).sendKeys(z);
			oBrowser.findElement(By.id("userDataLightBox_usernameField")).sendKeys(a);
			oBrowser.findElement(By.id("userDataLightBox_passwordField")).sendKeys(b);
			oBrowser.findElement(By.id("userDataLightBox_passwordCopyField")).sendKeys(b);
			oBrowser.findElement(By.id("userDataLightBox_commitBtn")).click();
			log.info("createUser...");
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=6)
	static void modifyUser()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[2]/td[1]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.id("userDataLightBox_firstNameField")).clear();
			oBrowser.findElement(By.id("userDataLightBox_firstNameField")).sendKeys("newuserfirst");
			oBrowser.findElement(By.id("userDataLightBox_passwordField")).sendKeys("User@1234");
			oBrowser.findElement(By.id("userDataLightBox_passwordCopyField")).sendKeys("User@1234");
			oBrowser.findElement(By.id("userDataLightBox_commitBtn")).click();
			log.info("modifyUser...");
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=7)
	static void deleteUser()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[2]/td[1]")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.id("userDataLightBox_deleteBtn")).click();
			Thread.sleep(2000);
			Alert obj=oBrowser.switchTo().alert();
			Thread.sleep(2000);
			obj.accept();
			log.info("deleteUser...");
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
	public Object[][] getUserData()
	{
		return new Object[][] {{"userfirst","userdemolast","user@gmail.com","user","User@123"}};
	}
}
