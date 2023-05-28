package com.emp.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.emp.controller.empEntity;

public class empRepository 
{
	public static void saveEmployee(empEntity empEntity)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/realm_db";
			Connection connection = DriverManager.getConnection(url,"root","root");
			String query="insert into emp_table(id,name,age,salary,work) values(?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, empEntity.getId());
			statement.setString(2, empEntity.getName());
			statement.setInt(3,empEntity.getAge());
			statement.setDouble(4, empEntity.getSalary());
			statement.setString(5, empEntity.getWork());
			int i = statement.executeUpdate();
			System.out.println(i+" row added");
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static empEntity getById(int id)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/realm_db";
			Connection connection = DriverManager.getConnection(url,"root","root");
			String query="select * from emp_table where id=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet set = statement.executeQuery();
			empEntity entity = new empEntity();
			if(set.next()) 
			{
				entity.setId(set.getInt(1));
				entity.setName(set.getString(2));
				entity.setAge(set.getInt(3));
				entity.setSalary(set.getDouble(4));
				entity.setWork(set.getString(5));
			}
			connection.close();
			System.out.println(entity.toString());
			return entity;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return new empEntity();
		}
	}
}
