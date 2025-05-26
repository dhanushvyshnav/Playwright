package com.es.pw1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MultipleBContext {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context1 = browser.newContext();
		Page page1 = context1.newPage();
		page1.navigate("https://www.orangehrm.com/en/30-day-free-trial");
		page1.fill("#Form_getForm_subdomain", "John");
		System.out.println(page1.title());
		Thread.sleep(3000);
		
		BrowserContext context2= browser.newContext();
		Page page2= context2.newPage();
		page2.navigate("https://www.automationexercise.com");
	//	page2.fill("#search_product", "tshirt");
		System.out.println(page2.title());
	}

}
