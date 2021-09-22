package com.sgtesting.popupbrowsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUpBrowsersDemo {
	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		popUpBrowsers();
	}
	static void launchBrowser()
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
	
	static void popUpBrowsers()
	{
		try
		{
			System.out.println("Before Click on the link :"+getPopupCount());
			oBrowser.findElement(By.linkText("actiTIME Inc.")).click();
			System.out.println("After Click on the link :"+getPopupCount());
			if(getPopupCount()>0)
			{
				handlePopups();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static int getPopupCount()
	{
		int count=0;
		try
		{
			count=oBrowser.getWindowHandles().size()-1;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	static void handlePopups()
	{
		try
		{
			String parentBrowser=oBrowser.getWindowHandle();
			System.out.println("Parent Browser:"+parentBrowser);
			Object[] popups=oBrowser.getWindowHandles().toArray();
			for(int i=1;i<popups.length;i++)
			{
				String childBrowser=popups[i].toString();
				System.out.println("child Browser:"+childBrowser);
				Thread.sleep(2000);
				oBrowser.switchTo().window(childBrowser);
				String title=oBrowser.getTitle();
				System.out.println("Child Browser Tilte:"+title);
				oBrowser.findElement(By.linkText("Start Using actiTIME")).click();
				Thread.sleep(2000);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
