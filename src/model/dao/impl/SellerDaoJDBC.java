package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{

	private Connection conn;
	public  SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("SELECT "
										+"seller.*,department.Name as DepName  "
										+"FROM "
										+ "seller INNER JOIN department  "
										+ "ON seller.DepartmentId = department.Id  "
										+ "WHERE "
										+ "seller.Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				
				Department dep = instatiationDepartment(rs);
				Seller obj = instatiationSeller(rs,dep);

				return obj;
				
			}
			
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return null;
	}

	private Seller instatiationSeller(ResultSet rs, Department dep) throws SQLException {
		
		Seller obj = new Seller();
		
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setDepartment(dep);
		obj.setEmail(rs.getString("Email"));
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		return obj;
	}

	private Department instatiationDepartment(ResultSet rs) throws SQLException {

		Department dep = new Department();
		
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
