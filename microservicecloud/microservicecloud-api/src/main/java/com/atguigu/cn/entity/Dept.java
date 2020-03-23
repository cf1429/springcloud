package com.atguigu.cn.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/*@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)  //链式结构
*/public class Dept implements Serializable {
    private int deptno ;
    private String dname;
    private String db_source;
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDb_source() {
		return db_source;
	}
	public void setDb_source(String db_source) {
		this.db_source = db_source;
	}
	public Dept(int deptno, String dname, String db_source) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.db_source = db_source;
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", db_source=" + db_source + "]";
	}
	
	/*
	 * public static void main(String[] args) { Random random = new Random(); List
	 * list = new ArrayList<>(); list.add(1); list.add(1); list.add(1); list.add(1);
	 * System.out.println(random.nextInt(list.size()));
	 * 
	 * }
	 */
	
	
    
    
}