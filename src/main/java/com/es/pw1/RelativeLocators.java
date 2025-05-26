package com.es.pw1;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RelativeLocators {
 static  Page page;
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = browser.newPage();
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		
		selectUsers("Joe.Root");
		selectUsers("Kevin.Mathews");
		
		System.out.println(getUserRole("Joe.Root"));
		System.out.println(getUserRole("John.Smith"));
		
//		
//		String user = page.locator("a:above(:text('Joe.Root'))").first().textContent();
//		System.out.println(user);
		System.out.println(aboveUser("Joe.Root"));
		System.out.println(aboveUser("John.Smith"));
		
		Locator nearElements = page.locator("td:near(:text('Joe.Root'),600)");
		List<String> list = nearElements.allInnerTexts();
		for(String e: list) {
			System.out.println(e);
		}
	}
	public static void selectUsers(String userName) {
		page.locator("input[type='checkbox']:left-of(:text('"+userName+"'))").first().click();
	}

	public static String getUserRole(String role) {
		return role = page.locator("td:right-of(:text('"+role+"'))").first().textContent();
	}
	
	public static String aboveUser(String user) {
		return user = page.locator("a:above(:text('"+user+"'))").first().textContent();
	}
}
