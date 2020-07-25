package com.montran.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.montram.pojo.Employee;
import com.montran.util.EmployeeCollectionUtil;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int employeeid;
		String name;
		double salary;
		Employee employee;
		List<Employee> employeeList;
		int userChoice;
		int noofemployees;
		String continueChoice;
		Employee allemployees[]=null;
		boolean result;
		EmployeeCollectionUtil emputil=new EmployeeCollectionUtil();
		
		do
		{
			
			
			employeeList = emputil.getAllEmployees();
			for (Employee emp : employeeList) {
				if(emp!=null)
				{
					System.out.println("-----------------------EmployeeDetails--------------------\n");
					System.out.println("Employee No\t\tEmployeeName\t\tSalary\n" );
					System.out.println(emp.getEmployeeId()+"\t\t\t"+emp.getName()+"\t\t\t"+emp.getSalary());
					System.out.println("\n---------------------------------------------------------\n");
				}
				
			}
			
			System.out.println("*******************MENU********************");
			System.out.println("1..Add New Employee");
			System.out.println("2..Add Multiple Employees");
			System.out.println("3..Update Employee");
			System.out.println("4..Delete Employee");
			System.out.println("5..Print Single Employee");
			System.out.println("6.Exit");
			System.out.println("Enter Choice");
			userChoice=sc.nextInt();
			
			switch (userChoice) {
			case 1://add new employee
				
				System.out.println("Enter Id :");
				employeeid=sc.nextInt();
				
				if(employeeid>0)
				{
					System.out.println("Enter name :");
					name=sc.next();
					
					System.out.println("Enter salary:");
					salary=sc.nextDouble();
					
					employee=new Employee(employeeid,name,salary);
					emputil.addnewEmployee(employee);
				}
				
				else
				{
					System.out.println("Invalid EmployeeId");
				}
				
				break;
				
				
			case 2://add all employees
				
				System.out.println("Enter number of employees");
				noofemployees=sc.nextInt();
				allemployees=new Employee[noofemployees];
				for(int i=0;i<noofemployees;i++)
				{
					System.out.println("Enter Id :");
					employeeid=sc.nextInt();

					if(employeeid>0)
					{
						System.out.println("Enter name :");
						name=sc.next();
					
						System.out.println("Enter salary:");
						salary=sc.nextDouble();
						
						employee = new Employee(employeeid, name, salary);
						allemployees[i] = employee;
					}
					else
					{
						System.out.println("Invalid EmployeeId");
					}
					
					
					
				}
				emputil.addAllEmployees(allemployees);
				break;
				
			case 3://update employee
				System.out.println("Enter EmployeeID to Update : ");
				employeeid=sc.nextInt();
				employee=emputil.getEmployeeByEmployeeId(employeeid);
				if(employee!=null)
				{
					System.out.println("Enter new salary:");
					salary=sc.nextDouble();
					result=emputil.updateEmployeeSalary(employeeid, salary);
					if(result)
					{
						System.out.println("Salary updated successfully");
					}
					else
					{
						System.out.println("Failed to update salary");
					}
					
				}
				else
					System.out.println("Employee not Found!!");
				break;
				
			case 4://delete employee
				System.out.println("Enter EmployeeId to delete employee details");
				employeeid=sc.nextInt();
				employee=emputil.getEmployeeByEmployeeId(employeeid);
				if(employee!=null) 
				{
					result=emputil.deleteEmployee(employeeid);
					if(result==true)
					{
						System.out.println("Employee deleted successfully");
					}
					else
					{
						System.out.println("Failed to delete the employee details");
					}
				}
				else
				{
					System.out.println("Employee Not found");
				}
				break;
				
			case 5://employee by employee id
				System.out.println("Enter EmployeeId : ");
				employeeid = sc.nextInt();
				
				employee = emputil.getEmployeeByEmployeeId(employeeid);
				if (employee != null) {
					System.out.println(employee);
				} else
					System.out.println("Employee Not Found !!");
				break;
				
			case 6://exit
				
				break;
				

			default:
				System.out.println("Invalid choice!!");
				break;
			}
			System.out.println("Do you want to continue : ");
			continueChoice=sc.next();	
		}while(continueChoice.contentEquals("yes")|continueChoice.equals("y"));
		
	}
}
		
		
		

	
