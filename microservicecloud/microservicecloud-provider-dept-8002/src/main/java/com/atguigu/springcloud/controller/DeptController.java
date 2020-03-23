package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.cn.entity.Dept;
import com.atguigu.springcloud.service.DeptService;

@RestController
public class DeptController {
	@Autowired
	private DeptService deptService;
	//服务发现
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping(value="/dept/add",method=RequestMethod.GET)
	public boolean add(@RequestBody Dept dept) {
		return deptService.addDept(dept);
	}
	
	@RequestMapping(value="/dept/findByDeptno",method=RequestMethod.GET)
	public Dept findByDeptno(@RequestParam(value="deptno",required=true) Long deptno) {
		return deptService.findById(deptno);
	}
	
	@RequestMapping(value="/dept/findAll",method=RequestMethod.GET)
	public List<Dept> findAll() {
		List<Dept> list = deptService.findAll();
		return list;
	}
	
	  @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
	  public Object discovery() { 
		  List<String> list = discoveryClient.getServices();
		  System.out.println(list);
		  List<ServiceInstance> serviceList = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
		  for(ServiceInstance element : serviceList) {
			  System.out.println(element.getServiceId() + "///"+element.getHost()+"///"+element.getPort() +"///"+element.getUri());
		  }
		  return this.discoveryClient;
	  
	  }
	 
	
	

}