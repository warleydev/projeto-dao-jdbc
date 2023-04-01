package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import db.DbException;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//interface SellerDao sendo criada a partir da fábrica (DaoFactory)
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("------ TESTE 1: seller findById -----");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n------ TESTE 2: seller findById -----");
		
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj + "\n");
		}
		
		System.out.println("\n------ TESTE 3: seller findAll -----");
		
		List<Integer> listId = new ArrayList<>();
		
		
		list = sellerDao.findAll();
		for (Seller obj : list) {
			listId.add(obj.getId());
			System.out.println(obj + "\n");
		}
		
		System.out.println("\n------ TESTE 4: seller insert -----");
		Seller newSeller = new Seller(2, "João Carlos", "bob@gmail.com", new Date(), 2300.00, department);
		sellerDao.insert(newSeller);
		System.out.println(newSeller);
		
		System.out.println("\n------ TESTE 5: seller update -----");
		seller = sellerDao.findById(1);
		seller.setName("Joao Carlos");
		sellerDao.update(seller);
		System.out.println(seller);
		
		System.out.println("\n------ TESTE 6: seller delete -----");
		System.out.print("Digite o Id que queira deletar: ");
		int id = sc.nextInt();
		System.out.println("Deletando vendedor " + sellerDao.findById(id).getName() + "...");
		sellerDao.deleteById(id);
		System.out.println("Deletado com sucesso!");
		sc.close();
	}
}
