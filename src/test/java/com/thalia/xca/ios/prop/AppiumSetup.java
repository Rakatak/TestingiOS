package com.thalia.xca.ios.prop;

import java.io.File;

public final class AppiumSetup {

//	public static final String udid = "38b5c62d8821918e3ce8c10ca5a0ca693bb11d12"; // ipod schwarz
//	public static final String udid = "1874cce495990ad81419c700ecd52ecd20d205d0"; // ipod weiß
//	public static final String udid = "e15942aced8806109d52237b515ad7c1a97cabba"; // ipod liquid
//	public static final String udid = "70911e2530c8ee3088af7834c0f893c0e77a801f"; // dr. robotnik
//	public static final String udid = "126420d2b55a5453f3c14e10f334a4cb4a28a34e"; // iPad Kirsche
//	public static final String udid = "b352be57db9ef2f0ac8497b80b3b2df3a7bd4dc6"; // iPad Orphi
//	public static final String udid = "d1c2a0cdba327d7aac832e20fae22319a527fe6b"; // iPad	
//	public static final String udid = "69cf3bcc0a3826c661384e855682e85bd0e6e8b0"; // iPad mini
//	public static final String udid = "67196aa36be830268c5439560d951bdea5a3b741"; // iPhone Blue
//	public static final String udid = "021835a1db18ac05a2be26119c4fd65e68b59e0b"; // iPhone 3.3 inch
//	public static final String udid = "9c31877bef02f514020db28904844a0de62cf0bb"; // iPad Stern
//	public static final String udid = "28fa4e293f3277ada76b5480483dd230bdfbeb07"; // iPad // Calpi
//	public static final String udid = "fac9a348185f73c99bdefddfc580f020f0d94d11"; // iPhone6
//	public static final String udid = "335bbd1b2f0f100a000be1450be7d5c2cffbfab3"; // iPhone5
//	public static final String udid = "9440f01e6c4e8bd43d8bd6826ec3305321db23d0"; // iPhone5 silber
//	public static final String udid = "80af042d16f227e6564174b20db307e1eac5e416"; // iPad Zidane
	public static final String udid = "33e3e81f706261acf0b40ca2632352acbe8cb7d2"; // iPod Yeööpw
//	public static final String udid = "80af042d16f227e6564174b20db307e1eac5e416"; // iPad new White

	
	
//	public static final String bundleId = "eu.textunes.XCA--Debug-";
	public static final String bundleId = "eu.thalia.app";
	
	public static final int timeOut = 35;
	
	//App path
	static File appDir = new File(System.getProperty("user.dir"), "app");
    static File app = new File(appDir, "XCA (Debug).app");
    static File currentDir = new File(System.getProperty("user.dir"));
    
    public static final String localPath = currentDir + "/app/XCA (Debug).app";
    public static final String jenkinsPath = currentDir + "/build/Debug-iphoneos/Payload/XCA (Debug).app";

	public static final String deName = "iPhone 5"; 
	public static String v = "8";
//	public static final String deName = "iPhone"; 
	
	public static final String articleTitleSmall = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAStaticText[1]";
}

