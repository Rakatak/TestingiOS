package com.thalia.xca.ios;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.google.common.annotations.VisibleForTesting;
import com.thalia.xca.ios.prop.AbstractExcAction;
import com.thalia.xca.ios.prop.IOSCapabilities;

public class BookTest {
	
	private IOSDriver<MobileElement> wd; 
	IOSCapabilities iCap;
	
	@Before
	public void setUp() throws Exception {
		iCap = new IOSCapabilities(); 
		wd = iCap.setCap();
	}
    
	@VisibleForTesting
    private MobileElement openSearch() throws Exception {
		MobileElement elementSearch = null;
    	if (iCap.screenHeight >= 1024){
            elementSearch = wd.findElementByClassName("UIASearchBar");  //iPad                 
    	}else {
    		elementSearch = wd.findElement(By.name("Suche"));
    	}
    	return elementSearch;
	}
    
    @Test
    public void bookSwipeTest() throws Exception {
    	   
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {		
				char elementIndex = '2';
			
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				
				eName = "Sortiment";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
				
				eName = "Fantasy & Science Fiction";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
		        					
				eName = "First book in Listview";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]");
				element.click();
				Thread.sleep(8000);
				
				wd.swipe((int)(iCap.screenWidth*0.8), 400, (int)(iCap.screenWidth*0.12), 400, 500);
	    		Thread.sleep(6000);
									
	    		eName = "Book Number Display 2";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]");
				String result = element.getAttribute("name");
				
				assertTrue("Using the Next-Button or Swipe didn't change the index on top of page", result.charAt(0) == elementIndex);
				
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void detailPageTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
		    	String check = null;
		    	String result = null;
		    	String result2 = null;
		    	MobileElement element2;
		    	

		    	eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);

				eName = "Sortiment";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(2000);

				eName = "Krimis & Thriller";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(3000);
		        
				eName = "Book Price in List View";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]");
				check = element.getAttribute("name");
				element.click();					
				Thread.sleep(4000);
				
				if (iCap.screenHeight < 1024) {

					eName = "Book Price in Detail View";
					element = wd.findElementByName(check);
					element2 = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAStaticText[5]");
					result = element.getAttribute("name");
					result2 = element2.getAttribute("name");
					Thread.sleep(2000);

				} else {
					
					eName = "Book Price in Detail View";
					element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAStaticText[4]");
					element2 = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAStaticText[6]");
					result = element.getAttribute("name");
					result2 = element2.getAttribute("name");
					Thread.sleep(2000);
				}
		               
				assertTrue("Detail Page content is not consistent. Expected price: " + check + ", Result: " + result + " / " + result2, result2.contains(check) || result.contains(check));
			}
    	};
    	action.performAction();
    }
    
    @Test @Ignore
    public void bookExtractTest() throws Exception {
  
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
		    	String check = "Leseprobe";
		    	String result;

		    	eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Sortiment";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(3000);
				
				eName = "Romane & Erzählungen";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1500);		
				
				eName = "Book Price in List View";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]");
				element.click();					
				Thread.sleep(1000);
				
				if (iCap.screenHeight >= 1024) {
					eName = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAStaticText[6]";
					element = wd.findElementByXPath(eName);
					element.click();
				}
				Thread.sleep(3000);	    
				
				eName = "Probelesen";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(3000);	
		
		        eName = "Page Header (Leseprobe)";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]");
				element.click();
		        result = element.getAttribute("name");
		        
				assertTrue("Detail Page content is not consistent. Expected header: " + check + ", Result: " + result , result.contains(check));
			}
    	};
    	action.performAction();
    }
}