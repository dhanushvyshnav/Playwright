package com.es.pw1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDom {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
//		page.navigate("https://books-pwakit.appspot.com/");
//		page.locator("book-app[apptitle='BOOKS'] #input").fill("java"); //parent shadow-root element //# for id
//		String string = page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent(); //. for class
//		System.out.println(string);
		
		page.navigate("https://selectorshub.com/shadow-dom-in-iframe/");
		page.frameLocator("#pact").locator("div#snacktime #tea").fill("Coffee is Love");
	}

}
