package com.es.pw1;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Locatorss {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		BrowserContext browserContext = browser.newContext();
		Page page= browserContext.newPage();
		page.navigate("https://www.orangehrm.com/en/contact-sales/");
//		Locator locator = page.locator("text =Contact Sales");
//		int count= locator.count();
//		System.out.println(count);	
//		locator.hover();
//		locator.first().click();
		Locator country = page.locator("select#Form_getForm_Country option");
		System.out.println(country.count());
		
//		for(int i=0; i<country.count(); i++){
//			String str= country.nth(i).textContent();
//			System.out.println(str);
//		}
		
		List<String> allcountry= country.allTextContents();
		for(String e: allcountry) {
			System.out.println(e);
		}
	}

}
