package com.sgtesting.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesDemo {
	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		identifyElements();
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
			oBrowser.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void identifyElements()
	{
		try
		{
			oBrowser.switchTo().frame(0);
			oBrowser.findElement(By.xpath("//a[text()='org.openqa.selenium' and @target='packageFrame']")).click();
			Thread.sleep(2000);
			oBrowser.switchTo().defaultContent();
			Thread.sleep(2000);
			oBrowser.switchTo().frame("packageFrame");
			oBrowser.findElement(By.xpath("//span[text()='WebDriver']")).click();
			Thread.sleep(2000);
			oBrowser.switchTo().defaultContent();
			Thread.sleep(2000);
			WebElement oEle=oBrowser.findElement(By.xpath("//iframe[@title='Package, class and interface descriptions']"));
			oBrowser.switchTo().frame(oEle);
			String content=oBrowser.findElement(By.xpath("/html/body/main/div[2]")).getText();
			System.out.println(content);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
