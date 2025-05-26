package com.es.pw1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelectors {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		Page page = browser.newPage();
		
		page.navigate("https://beebom.com/");
//		Thread.sleep(6000);
//		String content = page.locator("div.container h1:has-text('Log in to your OpenCart account')").textContent();
//		System.out.println(content);
		
		String str = page.locator("#main > div.popular-posts-hero__container.non-default-links > div.hero-topper-section > div.sub-section-down.topper > div:nth-child(1) > div > h2 > a").textContent();
		System.out.println(str);

		String content = page.locator("div.trending-tags-title:has-text('Trending')").textContent();
		System.out.println(content);
		
		String content2 = page.locator("div.trending-tags-list a[title='Minecraft']").textContent();
		System.out.println(content2);
	}

}
