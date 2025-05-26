package com.es.pw1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HasElements {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.amazon.com/b?node=283155");
//		Locator locator = page.locator("select#Form_getForm_Country:has(option[value='india'])");
//		locator.allInnerTexts().forEach(e-> System.out.println(e));
		
		//locators having some more locators inside it
		Locator locator = page.locator("div.navFooterLinkCol:has(a[href='https://www.amazon.jobs'])"); //(parent tag:specific child element)
		locator.allInnerTexts().forEach(e-> System.out.println(e));
	}
}
