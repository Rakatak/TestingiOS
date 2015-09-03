package com.thalia.xca.ios.prop;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

public class IOSCapabilities {
	
	public String username; 
	public String password;	
    public double screenWidth;
    public double screenHeight;

	public IOSDriver<MobileElement> setCap() throws MalformedURLException, UnknownHostException, InterruptedException {
		
		String computername = InetAddress.getLocalHost().getHostName();
		
		IOSDriver<MobileElement> wd = null;

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("bundleId", AppiumSetup.bundleId);

		if (computername.equals("Reserve2-iMac.local")) {

			capabilities.setCapability("udid", AppiumSetup.udid);
			capabilities.setCapability("app", AppiumSetup.localPath);
			capabilities.setCapability("deviceName", AppiumSetup.deName);

			wd = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			wd.manage().timeouts().implicitlyWait(AppiumSetup.timeOut, TimeUnit.SECONDS);

		} else {

			String version = System.getProperty("VERSION");
			String port = System.getProperty("PORT");
			String udid = System.getProperty("UDID");
			String name = System.getProperty("NAME");

			capabilities.setCapability("app", AppiumSetup.jenkinsPath);
			capabilities.setCapability("platformVersion", version);
			capabilities.setCapability("udid", udid);
			capabilities.setCapability("deviceName", name);

			wd = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:" + port + "/wd/hub"), capabilities);
			wd.manage().timeouts().implicitlyWait(AppiumSetup.timeOut, TimeUnit.SECONDS);
		}
		
		password = "hummel123";
    	username = "xcabasicde@thqa.de";
    	
		String[] dimensions = wd.manage().window().getSize().toString().split("\\D");
		screenWidth = Integer.parseInt(dimensions[1]);
		screenHeight = Integer.parseInt(dimensions[3]);
		Thread.sleep(10000);
		return wd;
	}
	
	public void selectStatic(IOSDriver<MobileElement> wd, Double screenHeight) {
		try{
			MobileElement select = null;
			
			select = wd.findElementByName("Mehr");
			select.click();
			Thread.sleep(2000);
			
			select = wd.findElementByName("Test/Debug");
			select.click();
			Thread.sleep(3000);
			
			if ( screenHeight < 1024) {
				wd.tap(1, 164, 480, 500);
			} else {
				wd.tap(1, 388, 480, 500);
			}
			Thread.sleep(5000);
			
			select = wd.findElementByName("Select & Reset App");
			select.click();
			Thread.sleep(2000);
			
		} catch (Exception ex){
        		wd.quit();	
			assertTrue("selectStatic() failed, no Internet Connection or REST-Api available", false);
		}
	} 
	
	public void selectLive(IOSDriver<MobileElement> wd, Double screenHeight) {
		try{
			MobileElement select = null;
			select = wd.findElementByName("Mehr");
			select.click();
			Thread.sleep(2000);
			
			select = wd.findElementByName("Test/Debug");
			select.click();
			Thread.sleep(3000);
			
			if ( screenHeight < 1024) {
				wd.tap(1, 164, 423, 500);
			} else {
				wd.tap(1, 388, 420, 500);
			}
			Thread.sleep(3000);
			
			select = wd.findElementByName("Select & Reset App");
			select.click();
			Thread.sleep(3000);
			
		} catch (Exception ex){
        	wd.quit();	
			assertTrue("selectLive() failed, no Internet Connection or REST-Api available", false);
		}
	} 
	
	public String hitGoButton(IOSDriver<MobileElement> wd, String eName){
		MobileElement element;
		eName = "Go Button";
		
		if (screenHeight >= 1024) {
			element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[2]/UIAKeyboard[1]/UIAButton[1]");
			element.click();
			
		} else {
			element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[2]/UIAKeyboard[1]/UIAButton[4]");
			element.click();
		}
		return eName;
	}
	
	public void tapFirstElement(IOSDriver<MobileElement> wd){
		if (screenHeight < 1024) {
			wd.tap(1 ,64, 184, 500);
		} else {
			wd.tap(1 ,345, 174, 500);
		}
//		 eName = "First Article";
//			element = wd.findElementByXPath(UIElements.firstArticleX);
//			element.click();
//	        Thread.sleep(2000);
	}
	
	public static void checkInet(){
		try {
			URL url = new URL("http://www.google.com");
			URLConnection con = url.openConnection();
			con.connect();
    
		} catch (Exception e) {
			System.out.println("Test was not executed due to failing Internet connectivity \n");

			e.printStackTrace();
		  	System.exit(0);
		} 
	}
	
	public MobileElement putInCart(IOSDriver<MobileElement> wd, String eName) throws InterruptedException{
		wd.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		Thread.sleep(3330);
		int limit = 0;
		List<MobileElement> temps = wd.findElementsByName(eName);
		while (temps.size() == 0 && limit < 5){
			wd.swipe((int)(screenWidth*0.8), 400, (int)(screenWidth*0.12), 400, 500);
			Thread.sleep(3000);
			temps = wd.findElementsByName(eName);
			Thread.sleep(3330);
			limit++;
		}
		wd.manage().timeouts().implicitlyWait(AppiumSetup.timeOut, TimeUnit.SECONDS);
		return temps.get(0);
	}

}
