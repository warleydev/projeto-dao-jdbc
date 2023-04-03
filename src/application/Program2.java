package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	public static void main(String[] args) {
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("------ TESTE 1: department insert -----");
		Department department = new Department(7, "Academia"); 
		departmentDao.insert(department);
		System.out.println(department);
		
		System.out.println("------ TESTE 2: department findById -----");
		Department newDepartment = departmentDao.findById(2);
		System.out.println(newDepartment);
		
		System.out.println("------ TESTE 3: department update -----");
		department.setName("Gym");
		departmentDao.update(department);
		System.out.println(department);
		
		
	}
}
