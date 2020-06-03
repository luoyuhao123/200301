package com.hqyj.SpringBootDemo.modules.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.SpringBootDemo.modules.test.vo.ApplicationTest;

@Controller
public class TestController {

	@Value("${server.port}")
	private int port;
	@Value("${com.luo.name}")
	private String name;
	@Value("${com.luo.age}")
	private int age;
	@Value("${com.luo.desc}")
	private String desc;
	@Value("${com.luo.random}")
	private String random;

	@Autowired
	private ApplicationTest applicationTest;

	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

	@RequestMapping("/test/log")
	@ResponseBody
	public String logTest() {
		LOGGER.trace("This is trace log");
		LOGGER.debug("This is DEBUG log");
		LOGGER.info("This is INFO log");
		LOGGER.warn("This is WARN log");
		LOGGER.error("This is ERROR log");
		return "This is log test";
		
	}
	
	
	@RequestMapping("/test/config")
	@ResponseBody
	public String configInfo() {

		StringBuffer sb = new StringBuffer();
		sb.append(port).append("-----").append(name).append("-----").append(age).append("-----").append(desc)
				.append("-----").append(random).append("-----").append("<br>");

		sb.append(applicationTest.getName1()).append(applicationTest.getAge1()).append(applicationTest.getDesc1())
				.append(applicationTest.getRandom1()).append("<br>");

		return sb.toString();

	}

}
