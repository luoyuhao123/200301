package com.hqyj.SpringBootDemo.modules.test.controller;

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
