package com.thalia.xca.ios;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.google.common.annotations.VisibleForTesting;
import com.thalia.xca.ios.prop.AbstractExcAction;
import com.thalia.xca.ios.prop.AppiumSetup;
import com.thalia.xca.ios.prop.IOSCapabilities;

public class SearchTest {
	
	private IOSDriver<MobileElement> wd; 
	IOSCapabilities iCap;
	
	@Before
	public void setUp() throws Exception {
		iCap = new IOSCapabilities(); 
		wd = iCap.setCap();
	}
    
	@VisibleForTesting
    private MobileElement openSearch() {
		MobileElement elementSearch = null;
    	if (iCap.screenHeight >= 1024){
            elementSearch = wd.findElementByClassName("UIASearchBar");  //iPad                 
    	}else {
    		elementSearch = wd.findElementByName("Suche");
    	}
    	return elementSearch;
    }
    
    @Test @Ignore
    public void searchHistoryTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {

		    	String searchInput = "Zebra";		    	
		    	openSearch().click();
				Thread.sleep(2000);
				
				eName = "UIASearchBar";
				element = wd.findElementByClassName(eName);
				element.click();
				Thread.sleep(2000);
				
				eName = "Setting Text";
//				element.sendKeys(searchInput);
				IOSElement el = (IOSElement) element;
				el.setValue(searchInput);
				Thread.sleep(1000);
				
				eName = "Hit Go Button";
//				eName = iCap.hitGoButton(wd, eName);
				Thread.sleep(500);
				
				eName = "Text löschen";
				element = wd.findElementById(eName);
				element.click();
				Thread.sleep(1000);
				
				assertTrue("The input: (" + searchInput + ") wasn't displayed correctly in the history", 1 <= wd.findElementsByName(searchInput).size());
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void searchResultTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {

				List<MobileElement> resultList;
		    	String searchInput = "Hund";
		    	openSearch().click();
				Thread.sleep(2000);
				
				eName = "UIASearchBar";
				element = wd.findElementByClassName(eName);
				element.click();
				Thread.sleep(2000);

				eName = "Setting Text";
//				element.sendKeys(searchInput);
				IOSElement el = (IOSElement) element;
				el.setValue(searchInput);
				Thread.sleep(1000);
				
				eName = "Hit Go Button";
//				eName = iCap.hitGoButton(wd, eName);
		        Thread.sleep(2000);

				eName = "First Article after search";
				resultList = wd.findElementsByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");
				Thread.sleep(2000);
							
				assertTrue("The input: (" + searchInput + ") wasn't displayed correctly in the results", resultList.size() == 1);		
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void searchCategoryTest() throws Exception {

    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				
				MobileElement checkItem;

		    	openSearch().click();
				Thread.sleep(2000);
		    	
		    	if (iCap.screenHeight < 1024){
		    		
		    		eName = "Seach Category Dropdown menu";
					element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]");
					element.click();
					Thread.sleep(500);
		    		
		    		eName = "Bücher";
					element = wd.findElementByName(eName);
					String check = element.getAttribute("name");
					element.click();
					Thread.sleep(2000);
					
					eName = "Search Category Dropdown menu";
					checkItem = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]");
					
					assertTrue("The search category: (" + check + ") wasn't displayed/selected correctly ", checkItem.getAttribute("name").contains(check) );

					
		    	} else {
	
					eName = "Bücher";
					element = wd.findElementByName(eName);
					String check = element.getAttribute("name");
					element.click();
					Thread.sleep(1000);
					
					eName = "Bücher";
					element = wd.findElementByName(eName);
					
					assertTrue("The search category: (" + check + ") wasn't displayed/selected correctly ", element.getAttribute("value").equals("1") );
		    	}
			}	
    	};
    	action.performAction();
    }
    
    @Test
    public void searchOptionsTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {

				MobileElement checkItem;
		    
		    	openSearch().click();
				Thread.sleep(2000);
				
				if ( iCap.screenHeight < 1024.0) {
					eName = "Search Options dropdown Menu";
					element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]");
				} else {
					eName = "Search Options dropdown Menu";
					element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[2]");
				}
				
				element.click();
		        Thread.sleep(2000);

				eName = "Verkaufsrang";
				element = wd.findElementByName(eName);
				String check = element.getAttribute("name");
				element.click();
		        Thread.sleep(3000);
				
				if ( iCap.screenHeight < 1024.0) {
					eName = "Search Options dropdown Menu";
					checkItem = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]");

				} else {
					eName = "Search Options dropdown Menu";
					checkItem = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[2]");
				}
				
				assertTrue("The search option: (" + check + ") wasn't displayed/selected correctly ", checkItem.getAttribute("name").contains(check));
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void checkSearchCategories() throws Exception {

    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {			
		    	int checker = 0; 
		    	ArrayList<String> checkList = new ArrayList<String>();
		    	checkList.add("Alle Kategorien");
		        checkList.add("Bücher");
		        checkList.add("eBooks");
		        checkList.add("Hörbücher");
		        checkList.add("Hörbuch-Downloads");
		        checkList.add("Filme");
		        checkList.add("Musik");
		        checkList.add("Spielwaren");
		        checkList.add("Games");        
		        checkList.add("Software");
		    	
		    	openSearch().click();
				Thread.sleep(2000);
				
				if ( iCap.screenHeight < 1024.0) {
					eName = "Search Category dropdown menu";
					element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]");
					element.click();
					Thread.sleep(2000);
				}
				
				//iterate on categories and checking
				for (int i = 0; i < checkList.size(); i++){
					eName = checkList.get(i);
					if (i==6 && iCap.screenHeight < 550){
						Thread.sleep(1200);
						wd.swipe(105, 400, 123, 177, 500);
						Thread.sleep(1200);
					}
					if (wd.findElementByName(eName).isEnabled()){
						checker++;
					}
				}

				assertTrue("The search categories are incomplete" + checker + " of " + checkList.size(), checker==checkList.size() );
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void checkSearchOptions() throws Exception {

    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {    	
		    	int checker = 0;
		    	ArrayList<String> checkList = new ArrayList<String>();
		    	checkList.add("Beste Treffer");
		    	checkList.add("Verkaufsrang");
		    	checkList.add("zuletzt erschienen");
		    	checkList.add("Preis: aufsteigend");
		    	checkList.add("Preis: absteigend");
		    	checkList.add("Titel: A–Z");
		    	checkList.add("Titel: Z–A");

		    	openSearch().click();
				Thread.sleep(2000);

		    	List<MobileElement> list = wd.findElementsByClassName("UIAButton");
				eName = "Search Options dropdown Menu";
				element = list.get(3);
				element.click();
		        Thread.sleep(2000);

				//iterate on options and checking
				for (int i = 0; i < checkList.size(); i++){
					eName = checkList.get(i);
					if (wd.findElementByName(eName).isDisplayed()){
						checker++;
					}
				}

				assertTrue("The search options are incomplete: " + checker + " of " + checkList.size(), checker==checkList.size() );
			}
    	};
    	action.performAction();
        
    }  
    
    @Test @Ignore
    public void prizeFilterTest() throws Exception {

    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
		   		
				int checker = 0;
				Double filter;
				
				String searchInput = "Hund";
		    	openSearch().click();
				Thread.sleep(2000);
				
				eName = "UIASearchBar";
				element = wd.findElementByClassName(eName);
				element.click();
				
				eName = "Setting Text";
				element.sendKeys(searchInput);
				Thread.sleep(1000);	
		        
				if (iCap.screenHeight < 1024){ //for iPhone
					
					eName = "Go Button";
					element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[2]/UIAKeyboard[1]/UIAButton[4]");
					element.click();
					Thread.sleep(3000);

					eName = "Filter Scope";
					element =  wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[3]");
					element.click();
					Thread.sleep(3000);
			        
					eName = "Preis, beliebig";
					element = wd.findElementByName(eName);
					element.click();
					Thread.sleep(2000);
					
					eName = "Prize <";
					element =  wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]/UIAStaticText[1]");
					String temp = element.getAttribute("name");
					Pattern p = Pattern.compile("\\d*\\.\\d+");
				    Matcher m = p.matcher(temp);
					m.find();
					filter = Double.parseDouble(m.group());
					element.click();
					Thread.sleep(2000);
					
					eName = "Stopp";
					element = wd.findElementByName(eName);
					element.click();
	 				Thread.sleep(2000);
	 				
				} else {
					
					eName = "Go Button";
					element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[2]/UIAKeyboard[1]/UIAButton[1]");
					element.click();
					Thread.sleep(1000);

					eName = "Verfeinern";
					element = wd.findElementByName(eName);
					element.click();
					Thread.sleep(1000);
					
					if (AppiumSetup.v.equals("8")){
						eName = "Preis";
					} else {
						eName = "Preis, :, beliebig ▾";
					}
					element = wd.findElementByName(eName);
					element.click();
					Thread.sleep(1000);
					
					eName = "Prize <";
					element =  wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]");
					String temp = element.getAttribute("name");
					Pattern p = Pattern.compile("\\d*\\.\\d+");
				    Matcher m = p.matcher(temp);
					m.find();
					filter = Double.parseDouble(m.group());
					element.click();
					Thread.sleep(1000);
					
				}
							
				for (int i = 1; i < 6; i++){
					eName = "Prize Element Nr." + i;
					element =  wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[" + i + "]/UIAStaticText[1]");
					String artName = element.getAttribute("name");
					if (Character.isDigit(artName.charAt(0))){
						int check = Integer.parseInt(artName.substring(0, 1));
						if (check < filter){
							checker++;
						}
					} else if (Character.isLetter(artName.charAt(0))){
						checker++;
					}
					
					Thread.sleep(4000);
				}
				
				assertTrue("Articles with higher prize than 5,00 were displayed which is not allowed", checker == 5);  
			}
    	};
    	action.performAction();
    }
}