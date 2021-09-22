package com.sgtesting.testngexamples;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDemo7 {
	
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
	
	@Test(priority=6,dataProvider="getProjectData")
	static void createProject(String x,String y)
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[1]/div[2]/div")).click();
			Thread.sleep(4000);
			oBrowser.findElement(By.xpath("/html/body/div[14]/div[2]")).click();
			Thread.sleep(2000);
		    oBrowser.findElement(By.id("projectPopup_projectNameField")).sendKeys(x);                          
		    Thread.sleep(2000);
		    oBrowser.findElement(By.id("projectPopup_projectDescriptionField")).sendKeys(y);
		    Thread.sleep(2000);
		    oBrowser.findElement(By.id("projectPopup_commitBtn")).click();
		    Thread.sleep(2000);
		    log.info("createProject...");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=7,dataProvider="getTaskData")
	static void createTask(String o)
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='taskListBlock']/div[1]/div[1]/div[3]/div")).click();
			Thread.sleep(4000);
			oBrowser.findElement(By.xpath("/html/body/div[13]/div[1]")).click();
			Thread.sleep(4000);
			oBrowser.findElement(By.xpath("//*[@id='createTasksPopup_createTasksTableContainer']/table/tbody/tr[1]/td[1]/input")).sendKeys(o);
			Thread.sleep(4000);
			oBrowser.findElement(By.xpath("//*[@id=\"createTasksPopup_commitBtn\"]")).click();
			Thread.sleep(4000);
			log.info("createTask...");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=8)
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
			log.info("deleteTask...");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=9)
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
		    log.info("deleteProject...");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=10)
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
	
	@Test(priority=11)
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
	
	@Test(priority=12)
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
	public Object[][] getProjectData()
	{
		return new Object[][] {{"Educational website","online training website"}};
	}
	
	@DataProvider
	public Object[][] getTaskData()
	{
		return new Object[][] {{"GUI"}};
	}
}
