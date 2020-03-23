package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.cn.entity.Dept;
import com.atguigu.springcloud.cfgbeans.ConfigBean;

@RestController
public class DeptController_Consumer {
	
	//private static final String REST_URL_PREFIX = "http://localhost:8001";
	//通过服务面服务名称调用
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";
	
	@Autowired
	private RestTemplate restTemplate;

	
	@RequestMapping(value="/consumer/dept/add")
	public boolean add(Dept dept) {
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
	}
	

	@RequestMapping(value="/consumer/dept/get{id}")
	public Dept get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
	}
	

	@RequestMapping(value="/consumer/dept/findAll")
	public List<Dept> findAll() {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/findAll", List.class);
	}
	@RequestMapping(value="/consumer/dept/discovery")
	public Object discovery() {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
	}
	
}
