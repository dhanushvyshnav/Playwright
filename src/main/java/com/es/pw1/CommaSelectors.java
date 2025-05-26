package com.es.pw1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CommaSelectors {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://academy.naveenautomationlabs.com/");
		page.locator("a:has-text('SignIn'), " +"a:has-text('LogIn'), "
		            +"a:has-text('Signin'), "+"a:has-text('Login'),"+ "a:has-text('signin')").click();
	      page.frameLocator("#microfe-popup-login").locator("#loginPopupCloseBtn svg").click();
		
//		Locator locator = page.locator("a:has-text('Courses'), " + "a:has-text('Demo Site'), "+ "a:has-text('EXPLORE COURSES')");
//		System.out.println(locator.count());
	}
}
