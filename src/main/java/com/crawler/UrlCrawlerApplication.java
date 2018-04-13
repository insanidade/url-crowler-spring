package com.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UrlCrawlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlCrawlerApplication.class, args);
	}
	
//	@RestController 
//	public class ThisWillActuallyRun {
//	  @RequestMapping("/")
//		String home() {
//			return "Hello Worlds!";
//		}
//	}
}
