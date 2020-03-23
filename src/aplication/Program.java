package aplication;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Department department = new Department(1,"books");
		System.out.println(department);
		
		Seller seller = new Seller(2, "Bob", "bob@email.com", new Date(), 2000.0, department);
		
		System.out.println(seller);
	}

}
