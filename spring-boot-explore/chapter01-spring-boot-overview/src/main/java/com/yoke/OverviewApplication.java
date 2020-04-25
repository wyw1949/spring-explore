package com.yoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
// 开启扫描Servlet
@ServletComponentScan(basePackages = {"com.yoke.web.servlet"})
public class OverviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(OverviewApplication.class, args);
	}

}
