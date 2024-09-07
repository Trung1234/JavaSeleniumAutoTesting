package com.example.factory;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsFactory implements BrowserOptionsFactory {

	public Object createOptions() {
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        // Add any additional Chrome options here
        return options;
	}
	
}

