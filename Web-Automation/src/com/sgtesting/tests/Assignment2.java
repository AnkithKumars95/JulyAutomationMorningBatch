package com.sgtesting.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
	
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		login();
		minimizeFlyoutWindow();
		createUser();
		modifyUser();
		deleteUser();
		logout();
		close();
	}
	public static WebDriver oBrowser=null;
	
	static void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver","G:\\ExampleAutomation\\Automation\\Web-Automation\\Library\\drivers\\chromedriver.exe");
			oBrowser=new ChromeDriver();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void navigate()
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
	
	static void login()
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys("admin");
			oBrowser.findElement(By.name("pwd")).sendKeys("manager");
			oBrowser.findElement(By.xpath("//*[@id=\'loginButton\']/div")).click();
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void minimizeFlyoutWindow()
	{
		try
		{
			oBrowser.findElement(By.id("gettingStartedShortcutsPanelId")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void createUser()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='topnav']/tbody/tr[1]/td[5]/a/div[2]")).click();
			oBrowser.findElement(By.xpath("//*[@id=\'createUserDiv\']/div")).click();
			oBrowser.findElement(By.id("userDataLightBox_firstNameField")).sendKeys("userfirst");
			oBrowser.findElement(By.id("userDataLightBox_lastNameField")).sendKeys("userdemolast");
			oBrowser.findElement(By.id("userDataLightBox_emailField")).sendKeys("user@gmail.com");
			oBrowser.findElement(By.id("userDataLightBox_usernameField")).sendKeys("user");
			oBrowser.findElement(By.id("userDataLightBox_passwordField")).sendKeys("User@123");
			oBrowser.findElement(By.id("userDataLightBox_passwordCopyField")).sendKeys("User@123");
			oBrowser.findElement(By.id("userDataLightBox_commitBtn")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
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
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	static void deleteUser()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[2]/td[1]")).click();
			oBrowser.findElement(By.id("userDataLightBox_deleteBtn")).click();
			Thread.sleep(2000);
			Alert obj=oBrowser.switchTo().alert();
			Thread.sleep(2000);
			obj.accept();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void logout()
	{
		try
		{
			oBrowser.findElement(By.id("logoutLink")).click();
			Thread.sleep(2000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	static void close()
	{
		oBrowser.close();
	}
}
