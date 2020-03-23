package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

}
