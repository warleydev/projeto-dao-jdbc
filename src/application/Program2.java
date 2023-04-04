package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		
		System.out.println("------ TESTE 1: department insert ------"); 
		System.out.println("Digite os dados do departamento que deseja inserir: ");
		System.out.print("Id: ");
		int id = sc.nextInt();
		System.out.print("Nome: ");
		sc.nextLine();
		String name = sc.nextLine();
		Department department = new Department(id, name);
		departmentDao.insert(department);
		System.out.println("Inserido departamendo " + department.getName() );

		System.out.println("------ TESTE 2: department findById ------");
		Department newDepartment = departmentDao.findById(2);
		System.out.println(newDepartment);

		System.out.println("------ TESTE 3: department update ------");
		newDepartment.setName("Eletricidade");
		departmentDao.update(newDepartment);
		System.out.println(newDepartment);

		System.out.println("------ TESTE 4: department delete ------");
		System.out.print("Digite o Id do departamento que deseja deletar: ");
		int id2 = sc.nextInt();
		if (id2 == 0) {
			System.out.println("Nenhum id foi deletado!");
		} else {
			System.out.println("Deletando departamento " + departmentDao.findById(id2).getName() + "...");
			departmentDao.deleteById(id2);
			System.out.println("Deletado com sucesso!");
		}

		System.out.println("------ TESTE 5: department findAll ------");
		List<Department> list = departmentDao.findAll();
		for (Department dep : list) {
			System.out.println(dep);
		}
		sc.close();
	}
}
