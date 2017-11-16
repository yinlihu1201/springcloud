package com.tiger.ui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 使用ribbon调用Some Service
 * @author yinlihu
 *
 */
@Service
public class SomeHystrixService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="fallbackSome")
	public String getSome(){
		return restTemplate.getForObject("http://some/getSome", String.class);
	}
	
	public String fallbackSome(){
		return "some service故障";
	}
}
