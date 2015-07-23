package com.thalia.xca.ios.prop;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
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

		if (computername.equals("Reserve2-iMac-2.local") || computername.equals("Reserve2-iMac.local") || computername.equals("Andreas-MacBook-Pro")) {

			capabilities.setCapability("udid", AppiumSetup.udid);
			capabilities.setCapability("app", AppiumSetup.localPath);
			capabilities.setCapability("deviceName", AppiumSetup.deName);

			wd = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			wd.manage().timeouts().implicitlyWait(AppiumSetup.timeOut, TimeUnit.SECONDS);

	    	password = "hummel123";
	    	username = "xcabasicde@thqa.de";
	    	
	    	if (AppiumSetup.udid.equals("b352be57db9ef2f0ac8497b80b3b2df3a7bd4dc6") || AppiumSetup.udid.equals("70911e2530c8ee3088af7834c0f893c0e77a801f") || AppiumSetup.udid.equals("e15942aced8806109d52237b515ad7c1a97cabba") || AppiumSetup.udid.equals("1874cce495990ad81419c700ecd52ecd20d205d0")){
	    		AppiumSetup.v = "8";
	    	}
	    	
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
			
	    	password = "hummel123";
	    	username = "xcabasicde@thqa.de";

	    	if (udid.equals("b352be57db9ef2f0ac8497b80b3b2df3a7bd4dc6") || udid.equals("70911e2530c8ee3088af7834c0f893c0e77a801f") || udid.equals("e15942aced8806109d52237b515ad7c1a97cabba") || udid.equals("1874cce495990ad81419c700ecd52ecd20d205d0")){
	    		AppiumSetup.v = "8";
	    	}
		}
		String[] dimensions = wd.manage().window().getSize().toString().split("\\D");
		screenWidth = Integer.parseInt(dimensions[1]);
		screenHeight = Integer.parseInt(dimensions[3]);

		Thread.sleep(6000);
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
			if ( screenHeight >= 1024) {
				wd.tap(1, 388, 480, 500);
			} else {
				wd.tap(1, 164, 480, 500);
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
			if ( screenHeight >= 1024) {
				wd.tap(1, 388, 420, 500);

			} else {
				wd.tap(1, 164, 423, 500);
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

}
