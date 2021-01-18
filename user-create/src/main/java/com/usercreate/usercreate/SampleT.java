package com.usercreate.usercreate;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleT {

	@RequestMapping("/hello")
	public String test() {


		return "helo";

	}


	@RequestMapping("/hi")
	public void testt() {

		System.out.println("whats up mate 222");

	}



	@RequestMapping(value = "/id")
	public String getIdByValue(@RequestParam("id") String personId) {

		System.out.println("ID is " + personId);

		return "Get ID from query string of URL with value element";

	}

	@RequestMapping(value = "/personId")
	public String getId(@RequestParam String personId) {

		System.out.println("ID is " + personId);

		return "Get ID from query string of URL without value element";

	}

	@RequestMapping(value = "/name")
	String getName(@RequestParam(value = "person", required = false) String personName) {

		return "Required element of request param " + personName;

	}
	

	




}
