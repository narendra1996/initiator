package com.jpmc.custom.initilizer;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SampleController {
	
	@Autowired
	RestTemplate restTemplate;

	@GetMapping(path = "/hello")
	public String home() {
		return "hello from server";
	}
	
	@GetMapping(path = "/generate")
	public String generateProject(@RequestParam Map<String,String> request) throws IOException {
		String url = "http://localhost:8080/starter.zip?type=maven-project&language=java&bootVersion=2.2.7.RELEASE&baseDir=demo&groupId=com.example&artifactId=demo&name=demo&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example.demo&packaging=jar&javaVersion=1.8";
		System.out.println(request.toString());
        HttpEntity<?> e =null;
		ResponseEntity<byte[]> result = restTemplate.exchange(url, HttpMethod.GET,e, byte[].class);
		Files.write(new File("asserts/demo.zip").toPath(), result.getBody());
		return "hello from server";
	}
}
