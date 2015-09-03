package com.thalia.xca.ios.prop;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.SessionNotFoundException;

public abstract class AbstractExcAction {

	protected String eName = null;
	protected MobileElement element = null;
	protected IOSDriver<MobileElement> wd;
	
	public AbstractExcAction(IOSDriver<MobileElement> wd){
		this.wd = wd;
	}
	
	public final void performAction() throws InterruptedException {
		
		try {
			actionPerformedWithThrows();
			Thread.sleep(2000);
			
		} catch (NoSuchElementException ex) {
    		assertTrue("Element \"" + eName + "\" could not be located : NoSuchElementException", false);
		} catch (InterruptedException e) {
    		assertTrue("Some Thread interrupted: " + e.getStackTrace(), false);
		} catch (ArrayIndexOutOfBoundsException e) {
    		assertTrue("Element \"" + eName + "\" could not be located : ArrayIndexOutOfBoundsException", false);
		} catch (IndexOutOfBoundsException e) {
    		assertTrue("Element \"" + eName + "\" could not be located : IndexOutOfBoundsException", false);
		} catch (SessionNotFoundException e) {
    		assertTrue("Before clicking Element \"" + eName + "\" the app broke down: SessionNotFoundException", false);
		} finally {
			try {
				wd.removeApp(AppiumSetup.bundleId);
				Thread.sleep(10000);
			} catch (SessionNotFoundException e) {
	    		assertTrue("Before clicking Element \"" + eName + "\" the app broke down: SessionNotFoundException", false);
			} catch (WebDriverException e) {
	    		assertTrue("", true);

			}
		}
	}
	
	public void findByNameShort(String input) {
		eName = input;
		wd.findElementByName(input);
    }
	
	public abstract void actionPerformedWithThrows()
			throws NoSuchElementException, InterruptedException;
}
