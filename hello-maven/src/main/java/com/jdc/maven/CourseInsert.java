package com.jdc.maven;
import java.sql.SQLException;
import javax.sql.DataSource;

public class CourseInsert {
	private DataSource dataSource;
	
	private static final String sql = "insert into course (name, fees, duration) values (?,?,?)";
	
	public CourseInsert(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insert(Course c) {
		
		try(var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(sql)){
				
				stmt.setString(1, c.getName());
				stmt.setInt(2, c.getFees());
				stmt.setInt(3, c.getDuration());
			
				stmt.executeUpdate();
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
}
