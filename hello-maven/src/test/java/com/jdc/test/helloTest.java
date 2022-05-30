package com.jdc.test;

import org.junit.jupiter.api.Test;

import com.jdc.maven.Course;
import com.jdc.maven.CourseInsert;
import com.mysql.cj.jdbc.MysqlDataSource;

public class helloTest {

	private static final String pass = "";
	private static final String user = "root";
	private static final String url = "jdbc:mysql://localhost:3306/hello_maven";
	
	@Test
	void test() {
		
		var c = new Course();
		c.setName("Full Stack");
		c.setFees(250000);
		c.setDuration(6);
		
		var mysql = new MysqlDataSource();
		mysql.setUrl(url);
		mysql.setUser(user);
		mysql.setPassword(pass);
		
		var dataInsert = new CourseInsert(mysql);	
		dataInsert.insert(c);
		
	}
}
