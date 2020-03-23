package com.atguigu.myRule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class MySelfRule {
	@Bean
	public IRule myRule() {
		//return new RandomRule();  // 默认是轮询，可以自定义
		return new RandomRule_CF();
	}

}
