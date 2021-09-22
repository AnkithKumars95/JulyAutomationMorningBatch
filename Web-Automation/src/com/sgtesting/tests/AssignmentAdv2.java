package com.sgtesting.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentAdv2 {

	public static void main(String[] args) {
		createUsers();
		passwordModify();
		deleteUsers();
		close();
	}
	
	public static WebDriver oBrowser=null;
	
	static void createUsers()
	{
		try
		{
			launchBrowser();
			navigate();
			login("admin","manager");
			minimizeFlyoutWindow();
			usersBar();
			createUser("useronefirst","useronelast","userone@gmail.com","adam","Adam@1");
			logout();
			login("adam","Adam@1");
			handleWelcomeNote();
			usersBar();
			createUser("usertwofirst","usertwolast","usertwo@gmail.com","eva","Eva@1");
			logout();
			login("eva","Eva@1");
			handleWelcomeNote();
			usersBar();
			createUser("userthreefirst","userthreelast","userthree@gmail.com","noha","Noha@1");
			logout();
			login("noha","Noha@1");
			handleWelcomeNote();
			logout();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void passwordModify()
	{
		try
		{
			login("eva","Eva@1");
			usersBar();
			selectUser("userthreefirst");
			modifyUser("Noha@12");
			logout();
			login("noha","Noha@12");
			logout();
			login("adam","Adam@1");
			usersBar();
			selectUser("usertwofirst");
			modifyUser("Eva@12");
			logout();
			login("eva","Eva@12");
			logout();
			login("admin","manager");
			usersBar();
			selectUser("useronefirst");
			modifyUser("Adam@12");
			logout();
			login("adam","Adam@12");
			logout();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void deleteUsers()
	{
		try
		{
			login("eva","Eva@12");
			usersBar();
			Thread.sleep(4000);
			selectUser("userthreefirst");
			deleteUser();
			logout();
			login("adam","Adam@12");
			usersBar();
			Thread.sleep(4000);
			selectUser("usertwofirst");
			Thread.sleep(4000);
			deleteUser();
			logout();
			login("admin","manager");
			usersBar();
			Thread.sleep(4000);
			selectUser("useronefirst");
			Thread.sleep(4000);
			deleteUser();
			logout();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
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
	
	static void login(String x,String y)
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys(x);
			oBrowser.findElement(By.name("pwd")).sendKeys(y);
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
	
	static void createUser(String m,String n,String o,String p,String q)
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\'createUserDiv\']/div")).click();
			oBrowser.findElement(By.id("userDataLightBox_firstNameField")).sendKeys(m);
			oBrowser.findElement(By.id("userDataLightBox_lastNameField")).sendKeys(n);
			oBrowser.findElement(By.id("userDataLightBox_emailField")).sendKeys(o);
			oBrowser.findElement(By.id("userDataLightBox_usernameField")).sendKeys(p);
			oBrowser.findElement(By.id("userDataLightBox_passwordField")).sendKeys(q);
			oBrowser.findElement(By.id("userDataLightBox_passwordCopyField")).sendKeys(q);
			oBrowser.findElement(By.id("userDataLightBox_commitBtn")).click();
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	static void modifyUser(String m)
	{
		try
		{
			oBrowser.findElement(By.id("userDataLightBox_passwordField")).sendKeys(m);
			oBrowser.findElement(By.id("userDataLightBox_passwordCopyField")).sendKeys(m);
			oBrowser.findElement(By.id("userDataLightBox_commitBtn")).click();
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void deleteUser()
	{
		try
		{
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
			Thread.sleep(4000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void selectUser(String userfirstname)
	{
		try
		{
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//span[contains(text(),'"+userfirstname+"')]")).click();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void close()
	{
		oBrowser.close();
	}
	
	static void handleWelcomeNote()
	{
		oBrowser.findElement(By.xpath("//*[@id=\'welcomeScreenBoxId\']/div[3]/div/span[1]")).click();
	}
	
	static void usersBar()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='topnav']/tbody/tr[1]/td[5]/a/div[2]")).click();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
