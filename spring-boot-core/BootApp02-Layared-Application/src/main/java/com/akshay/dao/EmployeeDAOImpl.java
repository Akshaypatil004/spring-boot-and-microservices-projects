package com.akshay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.akshay.model.Employee;

@Repository("empDao") // to make java as spring bean cum , DAO class
public class EmployeeDAOImpl implements IEmployeeDAO{
	
	// SQL queries 
	
	private static final String GET_EMP_QUERY = "SELECT EMPNO, ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(?,?,?)";
	
	@Autowired
	private DataSource pooled; // represent's JDBC connection pooled 
 
	@Override
	public List<Employee> getEmployeesByDesg(String desg1, String desg2, String desg3) throws Exception {
		System.out.println("EmployeeDAOImpl.getEmployeesByDesg()");
		// get the JDBC connection
		List<Employee> list = null;
		Connection con = pooled.getConnection();
		try(con;){
			// prepared statement
			PreparedStatement ps = con.prepareStatement(GET_EMP_QUERY);
			
			// set values to query parameter
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			
			// execute query 
			ResultSet rs = ps.executeQuery();
			try(rs){
				list = new ArrayList<>();
				while(rs.next()) {
					Employee e = new Employee();
					
					e.setEno(rs.getInt("EMPNO"));
					e.setEname(rs.getString("ENAME"));
					e.setJob(rs.getString("JOB"));
					e.setSalary(rs.getDouble("SAL"));
					e.setDeptNo(rs.getInt("DEPTNO"));
					
					// add employee to list
					list.add(e);
				}
			}
			
		}
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}

}
