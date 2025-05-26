package com.es.pw1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NthElement {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.amazon.com/b?node=283155");
		
		Locator ele_1 = page.locator("div.navFooterLinkCol li a >> nth=0");
		String ele1 = ele_1.textContent();
		System.out.println(ele1);
		
		Locator ele_2 = page.locator("div.navFooterLinkCol li a >> nth=1");
		String ele2 = ele_2.textContent();
		System.out.println(ele2);
		
		Locator ele_last = page.locator("div.navFooterLinkCol li a >> nth=-2");
		String elee = ele_last.textContent();
		System.out.println(elee);
	}

}
