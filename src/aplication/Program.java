package aplication;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		System.out.println("=== teste 1 : seller findById ===");
		
		SellerDao sellerDao = DaoFactory.createSellerDao();		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n\n=== teste 2 : seller findByIdDepartment ===");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		
		list.forEach(l->{
			System.out.println(l);
		});
	}
	

}
