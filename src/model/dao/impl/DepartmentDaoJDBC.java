package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Statement;

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
	public void insert(Department obj){
		PreparedStatement st = null;
		try{
			st = conn.prepareStatement(
					"INSERT INTO department "
					+ "(Id, Name) "
					+ "VALUES "
					+ "(?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, obj.getId());
			st.setString(2, obj.getName());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0){
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()){
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			}
			else{
				throw new DbException("Erro inesperado! Não foi possível inserir o novo departamento!");
			}
		}
		catch (SQLException e){
			throw new DbException(e.getMessage());
		}
		finally{
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Department obj){
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE department "
					+ "SET Name = ? "
					+ "WHERE Id = ?");
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			
			st.executeUpdate();
		}
		catch (SQLException e){
			throw new DbException(e.getMessage());
		}
		finally{
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id){
		PreparedStatement st = null;
		try{
			st = conn.prepareStatement("DELETE FROM department WHERE Id = ?");
			st.setInt(1, id);
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally{
			DB.closeStatement(st);
		}
		
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			st = conn.prepareStatement("SELECT * FROM department WHERE Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Department department = new Department();
				department.setId(rs.getInt("Id"));
				department.setName(rs.getString("Name"));
				return department;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally{
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		
	}

	@Override
	public List<Department> findAll(){
		// TODO Auto-generated method stub
		return null;
	}

}
