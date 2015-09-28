package com.thalia.xca.ios;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.google.common.annotations.VisibleForTesting;
import com.thalia.xca.ios.prop.AbstractExcAction;
import com.thalia.xca.ios.prop.IOSCapabilities;

public class ShopSortFilterTest {
	
	private IOSDriver<MobileElement> wd; 
	IOSCapabilities iCap;
	
	@Before
	public void setUp() throws Exception {
		iCap = new IOSCapabilities(); 
		wd = iCap.setCap();	
	}
	
	@Test @Ignore
    public void ageFilterTest() throws Exception {
		filter("Altersempfehlung");
    }
    
    @Test @Ignore
    public void dateFilterTest() throws Exception {
		filter("Veröffentlichungsdatum");
    }
    
    @Test @Ignore
    public void typeFilterTest() throws Exception {
		filter("Einband");
    }
    
    @Test 
    public void prizeFilterTest() throws Exception {
		filter("Preis");
    }
    
    @Test @Ignore
    public void sellRankSortTest() throws Exception {
    	sort("Verkaufsrang");
    }
    
    @Test @Ignore
    public void latestSortTest() throws Exception {
    	sort("zuletzt erschienen");
    }
    
    @Test 
    public void priceUpSortTest() throws Exception {
    	sort("Preis: aufsteigend");
    }
    
    @Test @Ignore
    public void priceDownSortTest() throws Exception {
    	sort("Preis: absteigend");
    }
    
    @Test @Ignore
    public void azSortTest() throws Exception {
    	sort("Titel: A–Z");
    }
    
    @Test @Ignore
    public void zaSortTest() throws Exception {
		sort("Titel: Z–A");
    }
    
    @VisibleForTesting
    private void sort(final String sorter) throws Exception {

    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
		   		
				eName = "Mehr";
				element = wd.findElementByName(eName);
		   		element.click();
		   		Thread.sleep(1000);
		   		
		   		eName = "Sortiment";
		   		element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
				
				eName = "Jugendbücher";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(4000);
		        
				if (iCap.screenHeight < 1024){ //for iPhone

					eName = "Sort Scope";
					element =  wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]");
					element.click();
					Thread.sleep(1000);
			        
				} else {
					
					eName = "Sort Menu";
					element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[2]");
					element.click();
					Thread.sleep(1500);
					
				}
				
				eName = sorter;
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(6000);
				
				iCap.tapFirstElement(wd);
		        Thread.sleep(3000);
				
		        eName = "Merkzettel";
				element =  wd.findElementByName(eName);
				
				//Check the total number
				assertTrue("Sortmethod " + sorter + " didn't return any results", element.isEnabled());  
			}
    	};
    	action.performAction();
    }
    
    @VisibleForTesting
    private void filter(final String filter) throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
		   		
				eName = "Mehr";
				element = wd.findElementByName(eName);
		   		element.click();
		   		Thread.sleep(1000);
		   		
		   		eName = "Sortiment";
		   		element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
				
				eName = "Comics & Manga";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(4000);
		        
				if (iCap.screenHeight < 1024){ //for iPhone

					eName = "Filter Scope";
					element =  wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[3]");
					element.click();
					Thread.sleep(1000);
			        
					
					eName = filter;
					element = wd.findElementByName(eName);
					element.click();
					Thread.sleep(1000);
					
					eName = "Filter Element";
					element =  wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]");
					element.click();
					Thread.sleep(1000);
					
					eName = "Stopp";
					element = wd.findElementByName(eName);
					element.click();
	 				Thread.sleep(1000);
	 				
				} else {
					

					eName = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAElement[1]";
					element = wd.findElementByXPath(eName);
					element.click();
					Thread.sleep(1500);
					
					
					eName = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[3]";
					element = wd.findElementByXPath(eName);
					element.click();
					Thread.sleep(1500);
					
//					eName = filter;
//					element = wd.findElementByName(eName);
//					element.click();
//					Thread.sleep(1000);
//					
					eName = "Filter Element";
					element =  wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[2]");
					element.click();
					Thread.sleep(1000);
					
				}
				
				iCap.tapFirstElement(wd);
		        Thread.sleep(3000);
				
		        eName = "Merkzettel";
				element =  wd.findElementByName(eName);
				
				//Check the total number
				assertTrue("Filter " + filter + " didn't return any results", element.isEnabled());  
			}
    	};
    	action.performAction();
    }
}