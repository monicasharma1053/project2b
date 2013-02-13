package com.company.auth.dao;

import java.util.*;

import com.company.auth.bean.Employee;

public class EmployeeDao {

	private Employee employee = new Employee(); 
	//Set<String> privileges; 
	
	public EmployeeDao(){
		
		employee.setFirstName("monica"); 
		employee.setLastName("sharma"); 
		Set privileges = new HashSet(); 
		privileges.add("ceo");  
		employee.setGid("1053"); 
		
	}
	
	public Employee getEmployee(String gid)
	{
		return employee; 
	}
	
	
	
}
