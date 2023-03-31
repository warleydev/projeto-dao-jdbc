package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
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
		
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj + "\n");
		}
		
		System.out.println("\n------ TESTE 4: seller insert -----");
		Seller newSeller = new Seller(null, "Orlando Torres", "orlandot@gmail.com", new Date(), 2300.00, department);
		sellerDao.insert(newSeller);
		System.out.println(newSeller);
	}
}
