package com.es.pw1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Basics {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.office.com/");
		
		String title = page.title();
		System.out.println("page title is: "+ title);
		
		String url = page.url();
		System.out.println("url is: "+url);
		
		browser.close();
		playwright.close();
		
	}

}
