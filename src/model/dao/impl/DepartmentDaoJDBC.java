package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{

	private Connection conn;	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("insert into department (Id,Name) "
										+ "values "
										+ "(?,?)",Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, obj.getId());
			st.setString(2, obj.getName());
			
			Integer rowsAffcted = st.executeUpdate();
			
			if(rowsAffcted > 0) {
				
				rs = st.getGeneratedKeys();
				while(rs.next()) {
					System.out.println("ID INSERT DEPARTMENT: "+rs.getInt(1));
				}
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;
		
		try {
		st = conn.prepareStatement("UPDATE department SET "
									+ "Name = ? "
									+ "WHERE "
									+ "Id = ?");
		st.setString(1, obj.getName());
		st.setInt(2, obj.getId());
		
		int rowsAffcted = st.executeUpdate();
		
		if(rowsAffcted > 0 ) {System.out.println("\n\n\t update success");}else{System.out.println("\n\n\t update failed");}
		
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}