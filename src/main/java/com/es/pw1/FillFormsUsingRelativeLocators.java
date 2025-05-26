package com.es.pw1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FillFormsUsingRelativeLocators {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
		page.locator("input:below(:text('FullName'))").first().fill("Mahendra GL");
		page.locator("input:below(:text('Email'))").first().fill("amarendrabahubali17@gmail.com");

	}

}
