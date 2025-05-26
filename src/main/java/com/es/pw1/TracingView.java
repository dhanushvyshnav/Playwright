package com.es.pw1;

import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class TracingView {
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();

			// Start tracing before creating / navigating a e.
			context.tracing().start(new Tracing.StartOptions().
					setScreenshots(true).setSnapshots(true).setSources(true));

			Page page = context.newPage();
			page.navigate("https://academy.naveenautomationlabs.com/");
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
			page.frameLocator("#microfe-popup-login").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Continue with email")).click();
			page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").click();
			page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").fill("traineees123@gmail.com");
			page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").click();
			page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").fill("Trainee123");
			page.frameLocator("#microfe-popup-login").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Next")).click();
			page.navigate("https://academy.naveenautomationlabs.com/t/u/activeCourses");
			page.frameLocator("#collabIframe").getByRole(AriaRole.LINK, new FrameLocator.GetByRoleOptions().setName("Go To Store")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Interview Preparation - Weekend Workshop - Part 1 cover Interview Preparation")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Log Out")).click();

			// Stop tracing and export it into a zip archive.
			context.tracing().stop(new Tracing.StopOptions()
					.setPath(Paths.get("trace.zip")));
		}

	}
}