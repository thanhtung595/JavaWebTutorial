package main;

import java.util.List;

import dao.EmployeeDaoImpl;
import entity.Employee;


public class Employee_Select {
	public static void main(String[] args) {
		List<Employee> list = new EmployeeDaoImpl().getAllEmployee();
		if(list == null) 
			return;
		for(Employee item:list) {
			System.out.printf("\n%-10s", item.getEmpId());
		}
	}
}
