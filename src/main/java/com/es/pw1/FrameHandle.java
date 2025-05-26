package com.es.pw1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameHandle {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page= browser.newPage();

		//page.navigate("https://www.londonfreelance.org/courses/frames/index.html");

		//		String str = page.frameLocator("frame[name='main']").locator("h2").textContent();
		//		System.out.println(str);

		//		String str2 = page.frame("main").locator("h2").textContent();
		//		System.out.println(str2);

		//page.locator("img[title='Vehicle-Registration-Forms-and-Examples']").click();

		page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		page.locator("img[title='Vehicle-Registration-Forms-and-Examples']").click();

		page.frameLocator("//iframe[contains(@id,'frame-one')]")
		.locator("#RESULT_TextField-8").fill("John");

		//page.locator("form#FSForm div.form_table input#RESULT_TextField-8").fill("John");
		//page.locator("div#q8 input#RESULT_TextField-8").type("John");
	}

}
