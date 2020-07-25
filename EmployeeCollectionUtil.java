package com.montran.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.montram.pojo.Employee;


public class EmployeeCollectionUtil {
	
	private List<Employee> employeeList=new ArrayList<Employee>();
	
	public boolean addnewEmployee(Employee employee)		//adding new employee
	{
		
		employeeList.add(employee);
		return false;
	}//end
	
	public boolean addAllEmployees(Employee[] employees)		//adding all employees
	{
		 for (Employee employee : employees) {
			addnewEmployee(employee);
			
		}
		return true;
		
	}//end
	
	public boolean updateEmployeeSalary(int employeeId ,  double newSalary)		//updating employee
	{
		for (Employee employee : employeeList) {
			if (employee.getEmployeeId() == employeeId) {
				employee.setSalary(newSalary);
				return true;
			}
		}
		return false;
	}//end
	
	public boolean deleteEmployee(int employeeId)		//deleting employee
	{
		
		for (Employee employee : employeeList) {
				if(employee.getEmployeeId()==employeeId)
				{
					employee.setEmployeeId(0);
					employee.setName(null);
					employee.setSalary(0.0);
					
					return true;
				}
			}
			return false;
	}//end

	
	public Employee getEmployeeByEmployeeId(int employeeId)		//getting employee by employeeid
	{
		for(Employee employee : employeeList)
		{
			if(employee!=null)
			{
				if(employee.getEmployeeId()==employeeId)
				return employee;
			}
		}
		return null;
	}//end
	
	public List<Employee> getAllEmployees()		//getting all employees
	{
		return employeeList;
	}//end

}
