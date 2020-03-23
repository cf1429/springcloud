package com.atguigu.springcloud.service;

import java.util.List;

import com.atguigu.cn.entity.Dept;

public interface DeptService {
	
    public boolean addDept(Dept dept);
	
	public Dept findById(Long id);
	
	public List<Dept> findAll();
	

}
