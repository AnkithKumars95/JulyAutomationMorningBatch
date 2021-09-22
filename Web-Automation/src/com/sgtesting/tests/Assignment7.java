package com.sgtesting.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {
	public static WebDriver oBrowser=null;
	
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		login();
		minimizeFlyoutWindow();
		createCustomer();
		createProject();
		createTask();
		deleteTask();
		deleteProject();
		deleteCustomerser();
		logout();
		close();
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
	
	static void createCustomer()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr/td[3]/a")).click();
			oBrowser.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[1]/div[2]/div")).click();
			oBrowser.findElement(By.xpath("/html/body/div[14]/div[1]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.id("customerLightBox_nameField")).sendKeys("usercustomer");
			oBrowser.findElement(By.id("customerLightBox_descriptionField")).sendKeys("Infosys");
			oBrowser.findElement(By.id("customerLightBox_commitBtn")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	static void createProject()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[1]/div[2]/div")).click();
			Thread.sleep(4000);
			oBrowser.findElement(By.xpath("/html/body/div[14]/div[2]")).click();
			Thread.sleep(2000);
		    oBrowser.findElement(By.id("projectPopup_projectNameField")).sendKeys("Educational website");                          
		    Thread.sleep(2000);
		    oBrowser.findElement(By.id("projectPopup_projectDescriptionField")).sendKeys("online training website");
		    Thread.sleep(2000);
		    oBrowser.findElement(By.id("projectPopup_commitBtn")).click();
		    Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void createTask()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='taskListBlock']/div[1]/div[1]/div[3]/div")).click();
			Thread.sleep(4000);
			oBrowser.findElement(By.xpath("/html/body/div[13]/div[1]")).click();
			Thread.sleep(4000);
			oBrowser.findElement(By.xpath("//*[@id='createTasksPopup_createTasksTableContainer']/table/tbody/tr[1]/td[1]/input")).sendKeys("GUI");
			Thread.sleep(4000);
			oBrowser.findElement(By.xpath("//*[@id=\"createTasksPopup_commitBtn\"]")).click();
			Thread.sleep(4000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void deleteTask()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='taskListBlock']/div[1]/div[2]/div[1]/table[1]/tbody/tr/td[2]")).click();
			Thread.sleep(4000);
			oBrowser.findElement(By.xpath("//*[@id='taskListBlock']/div[3]/div[1]/div[2]/div[3]/div/div")).click();
			Thread.sleep(4000);
			oBrowser.findElement(By.xpath("//*[@id='taskListBlock']/div[3]/div[4]/div/div[3]/div")).click();
			Thread.sleep(4000);
			oBrowser.findElement(By.xpath("//*[@id='taskPanel_deleteConfirm_submitTitle']")).click();
			Thread.sleep(4000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void deleteProject()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[3]/div[3]")).click();
		    Thread.sleep(2000);
		    oBrowser.findElement(By.xpath("//*[@id='taskListBlock']/div[4]/div[1]/div[2]/div[3]/div/div")).click();
		    Thread.sleep(2000);
		    oBrowser.findElement(By.xpath("//*[@id='taskListBlock']/div[4]/div[4]/div/div[3]/div")).click();
		    Thread.sleep(2000);
		    oBrowser.findElement(By.xpath("//*[@id='projectPanel_deleteConfirm_submitBtn']/div")).click();
		    Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
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
