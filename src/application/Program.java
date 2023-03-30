package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		//interface SellerDao sendo criada a partir da fábrica (DaoFactory)
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("------ TESTE 1: seller findById -----");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
	}
}
