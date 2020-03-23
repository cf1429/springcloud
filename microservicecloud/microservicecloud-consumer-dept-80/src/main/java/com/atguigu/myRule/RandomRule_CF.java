package com.atguigu.myRule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class RandomRule_CF extends AbstractLoadBalancerRule{
    
	private int total = 0;
	private int currentIndex = 0;
	
	public Server choose(ILoadBalancer lb,Object key) {
		if(lb == null ) {
			return null;
		}
		Server server = null;
		while(server == null ) {
			if(Thread.interrupted()) {
				return null;
			}
			List<Server> upList = lb.getReachableServers();
			List<Server> allList = lb.getAllServers();
			if(allList.size() == 0) {
				return null;
			}
			if(total<5) {
				server = upList.get(currentIndex);
				total++;
			}else {
				total = 0;
				currentIndex ++;
				if(currentIndex >= upList.size()) {
					currentIndex = 0;
				}
			}
			
			if(server == null ) {
				Thread.yield();
				continue;
			}
			
			if(server.isAlive()) {
				return (server);
			}
		}
		return server;
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(),key);
		
	}

	

}
