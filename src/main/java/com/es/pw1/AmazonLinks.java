package com.es.pw1;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AmazonLinks {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		// chrome dev tools
		page.navigate("https://www.amazon.com/b?node=283155");
		List<String> list = page.locator("a:has-text('Amazon')").allInnerTexts();
		list.stream().forEach(e-> System.out.println(e));
	}

}
