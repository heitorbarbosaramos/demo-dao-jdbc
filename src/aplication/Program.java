package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import db.DbException;
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
		Department dep = new Department(1, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		
		
		list.forEach(l->{
			System.out.println(l);
		});
		
		System.out.println("\n\n=== teste 3 : seller update ===");
		Seller seller2 = sellerDao.findById(1);
		seller2.setName("Bobs Browns");
		seller2.setEmail("bobs@email.com");
		sellerDao.update(seller2);
		Seller seller3 = sellerDao.findById(1);
		
		System.out.println(seller3);
		
		System.out.println("\n\n=== teste 4 : seller insert ===");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Seller seller4 = new Seller(0, "Heitor Ramos", "heitorhfbr@gmail.com", sdf.parse("06/07/1988"), 1500.0, new Department(1, null));
			sellerDao.insert(seller4);
		} catch (ParseException e) {
			throw new DbException(e.getMessage());
		}
		
		
		
		
	}
	

}
