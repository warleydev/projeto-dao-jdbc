package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("------ TESTE 1: department insert -----");
		Department department = new Department(7, "Academia"); 
		departmentDao.insert(department);
		
		System.out.println("------ TESTE 2: department findById -----");
		Department newDepartment = departmentDao.findById(2);
		System.out.println(newDepartment);
		
		System.out.println("------ TESTE 3: department update -----");
		newDepartment.setName("Eletricidade");
		departmentDao.update(newDepartment);
		System.out.println(newDepartment);
		
		System.out.println("------ TESTE 4: department delete -----");
		System.out.print("Digite o Id do departamento que deseja deletar: ");
		int id = sc.nextInt();
		System.out.println("Deletando departamento " + departmentDao.findById(id).getName() + "...");
		departmentDao.deleteById(id);
		System.out.println("Deletado com sucesso!");
		
		sc.close();
	}
}
