package com.es.pw1;

import java.util.Iterator;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VisibleElements {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.amazon.com/b?node=283155");
		//button:visible
		List<String> links = page.locator("a:visible").allInnerTexts();

		for(int i=0; i<links.size(); i++) {
			System.out.println(links.get(i));

			//button>>visible=true
//			int count = page.locator(" xpath=//img >> visible=true").count();
//			System.out.println(count);
		}
		int count = page.locator("xpath=//img >> visible=true").count();
		System.out.println(count);
	}

}
