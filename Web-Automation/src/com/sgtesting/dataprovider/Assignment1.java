package com.sgtesting.dataprovider;

import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1{

	public static void main(String[] args) {
		launchBrowser();
		navigate();
		enterDetails("John","John@gmail.com","9876543210","kindly send quote");
		checkResponseCode();
		closeApplication();
	}
	
	public static WebDriver oBrowser=null;
	
	static void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "G:\\ExampleAutomation\\Automation\\Web-Automation\\Library\\drivers\\chromedriver.exe");
			oBrowser=new ChromeDriver();
			oBrowser.manage().window().maximize();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void navigate()
	{
		try
		{
			oBrowser.get("http://test.boxigo.in/contact-us");
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	static void enterDetails(String m,String n,String o,String p)
	{
		try
		{
			oBrowser.findElement(By.xpath("//input[@id='name'][@type='text']")).sendKeys(m);
			oBrowser.findElement(By.xpath("//input[@id='email'][@class='form-control']")).sendKeys(n);
			oBrowser.findElement(By.xpath("//input[@id='phone'][@type='number']")).sendKeys(o);
			oBrowser.findElement(By.xpath("//textarea[@id='message'][@placeholder='Message']")).sendKeys(p);
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//input[@value='Send Enquiry']")).submit();
			
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void checkResponseCode()
	{
		try
		{
			HttpURLConnection cont=(HttpURLConnection)new URL("http://test.boxigo.in/home/thank_you_for_contacting_us").openConnection();
			cont.setRequestMethod("HEAD");
			cont.connect();
			int res = cont.getResponseCode();
			System.out.println(res);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void closeApplication()
	{
		try
		{
			oBrowser.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
