package com.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.repository.empRepository;

@WebServlet("/save")
public class empcontroller extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id = Integer.parseInt(req.getParameter("eid"));
		String name = req.getParameter("ename");
		int age = Integer.parseInt(req.getParameter("age"));
		double salary = Double.parseDouble(req.getParameter("salary"));
		String work = req.getParameter("work");
		
		resp.setContentType("text/html");
		
		empEntity entity = new empEntity(id, name, age, salary, work);
		empRepository.saveEmployee(entity);
		
		PrintWriter writer = resp.getWriter();
		writer.write("<body bgcolor=lightpink>");
		writer.write("<h1> Thanks for registration...");
		writer.write("<h2>your id is : "+id+" </h2>");
		writer.write("<h2>your name is : "+name+" </h2>");
		writer.write("<h2>your age is : "+age+" </h2>");
		writer.write("<h2>your salary is : "+salary+" </h2>");
		writer.write("<h2>your work is : "+work+" </h2>");
		writer.write("<h3>please verify your details</h3>");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println("hi");
		empEntity emp = empRepository.getById(id);
		System.out.println("ok");
		System.out.println(emp.toString());
	}
}
