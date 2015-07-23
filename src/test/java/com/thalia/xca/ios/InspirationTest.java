package com.thalia.xca.ios;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.thalia.xca.ios.prop.AbstractExcAction;
import com.thalia.xca.ios.prop.IOSCapabilities;

public class InspirationTest {
	
	private IOSDriver<MobileElement> wd; 
	IOSCapabilities iCap;
	
	@Before
	public void setUp() throws Exception {
		iCap = new IOSCapabilities(); 
		if (wd == null){
    		wd = iCap.setCap();
    	}	
	}
    
    @Test
    public void bookWheelTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				Thread.sleep(3000);
				
				eName = "Startseite";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(5000);
				
				eName = "Book in Wheel";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]");
				element.click();
				Thread.sleep(3000);

				eName = "ic merkzettel";
				element = wd.findElementByName(eName);
				Thread.sleep(1000);

				assertTrue("Book Wheel in Inspiration doesn't link to detailPage", element.isEnabled());
			}
    	};
    	action.performAction();
    }
    
    @Test @Ignore
    public void bestsellerSpiegelTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				
				eName = "Startseite";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(5000);
				
				if (iCap.screenHeight < 1024){
					wd.swipe((int)(iCap.screenWidth*0.7), (int)(iCap.screenHeight*0.6), (int)(iCap.screenWidth*0.8), (int)(iCap.screenHeight*0.36), 500);
					Thread.sleep(5000);
				}
				
				eName = "SPIEGEL Bestseller Belletristik";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIATableCell[1]/UIAStaticText[1]");
				element.click();	
				Thread.sleep(5000);
				
				eName = "SPIEGEL Bestseller Belletristik";
				element = wd.findElementByName(eName);
				Thread.sleep(1000);
				
				eName = "First book";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");
				Thread.sleep(1000);
			

				assertTrue("Bestseller Ebooks button doesn't give any Results", element.isEnabled());
			}
    	};
    	action.performAction();
    }
    
    @Test @Ignore
    public void bestsellerThaliaTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				
				eName = "Startseite";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(5000);
				
				if (iCap.screenHeight < 1024){
					wd.swipe((int)(iCap.screenWidth*0.7), (int)(iCap.screenHeight*0.6), (int)(iCap.screenWidth*0.8), (int)(iCap.screenHeight*0.36), 500);
				}
				
				eName = "Thalia Bestseller Belletristik";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]/UIATableCell[1]/UIAStaticText[1]");
				element.click();	
				Thread.sleep(5000);
				
				eName = "Thalia Bestseller Belletristik";
				element = wd.findElementByName(eName);
				Thread.sleep(1000);
				
				eName = "First book";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");
				Thread.sleep(1000);
			

				assertTrue("Bestseller Thalia button doesn't give any Results", true);
			}
    	};
    	action.performAction();
    }
   
    @Test @Ignore
    public void newBooksTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				Thread.sleep(6000);
				
				eName = "Startseite";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(5000);
				
				eName = "mehr Neu und vielversprechend";
				if (iCap.screenHeight < 1024) {
					element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIAButton[5]");
				} else {
					element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIAButton[1]");
				}
				element.click();
				Thread.sleep(5000);
				
				eName = "Neuheiten";
				element = wd.findElementByName(eName);
				Thread.sleep(1000);
				
				eName = "First book";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");
				Thread.sleep(1000);

				assertTrue("Neu und vielversprechend button doesn't give any Results", element.isEnabled());
			}
    	};
    	action.performAction();
    }
    
    @Test @Ignore
    public void favoriteCategoryTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {

				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(5000);
				
				eName = "Sortiment";
				element = wd.findElementByName(eName);
				element.click();	
				Thread.sleep(2000);
				
				eName = "Kalender";
				element = wd.findElementByName(eName);
				element.click();	
				Thread.sleep(2000);
				
				eName = "favicon";
				element = wd.findElementByName(eName);
				element.click();	
				Thread.sleep(6000);
				
				eName = "Startseite";
				element = wd.findElementByName(eName);
				element.click();	
				Thread.sleep(7000);
				
				wd.swipe((int)(iCap.screenWidth*0.7), (int)(iCap.screenHeight*0.8), (int)(iCap.screenWidth*0.8), (int)(iCap.screenHeight*0.36), 500);
				Thread.sleep(5000);
				
				eName = "Kalender";
				element = wd.findElementByName(eName);
				Thread.sleep(2000);

				assertTrue("Favorite Category didn't appear on Inspiration Site", element.isEnabled());
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void deleteFavoriteCategoryTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {

				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(2000);
				
				eName = "Sortiment";
				element = wd.findElementByName(eName);
				element.click();	
				Thread.sleep(2000);
				
				eName = "Krimis & Thriller";
				element = wd.findElementByName(eName);
				element.click();	
				Thread.sleep(2000);
				
				eName = "favicon";
				element = wd.findElementByName(eName);
				element.click();	
				Thread.sleep(2000);
				
				eName = "Favorit entfernen";
				element = wd.findElementByName(eName);
				element.click();	
				Thread.sleep(2000);
				
				eName = "Startseite";
				element = wd.findElementByName(eName);
				element.click();	
				Thread.sleep(4000);
				
				wd.swipe((int)(iCap.screenWidth*0.7), (int)(iCap.screenHeight*0.8), (int)(iCap.screenWidth*0.8), (int)(iCap.screenHeight*0.36), 500);
				wd.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

				wd.getPageSource();
				eName = "Krimis & Thriller";
				List<MobileElement> list = wd.findElementsByName(eName);
				Thread.sleep(2000);

				if (iCap.screenHeight < 1024){
					assertTrue("Favorite Category still appears on Inspiration Site", list.size() == 0);
				} else {
					assertTrue("Favorite Category still appears on Inspiration Site", list.size() < 3);

				}
			}
    	};
    	action.performAction();
    }
    
    @Test @Ignore
    public void bookTipsTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				Thread.sleep(6000);
				
				eName = "Startseite";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(5000);
				
				eName = "mehr Buchhändler";
				if (iCap.screenHeight < 1024) {
					element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIAButton[3]");
				} else {
					element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIAButton[2]");
				}
				element.click();
				Thread.sleep(5000);
				
				eName = "Buchhändler-Tipps";
				element = wd.findElementByName(eName);
				Thread.sleep(1000);
				
				eName = "First book";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");
				Thread.sleep(1000);

				assertTrue("Neu und vielversprechend button doesn't give any Results", element.isEnabled());
			}
    	};
    	action.performAction();
    }
   
}