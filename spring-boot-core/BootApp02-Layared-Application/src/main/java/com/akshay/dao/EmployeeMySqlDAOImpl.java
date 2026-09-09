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

@Repository("empMysqlDao")
public class EmployeeMySqlDAOImpl implements IEmployeeDAO{
	
	// SQL Quries 
	private static final String GET_EMP_BY_DESG_QUERY = "SELECT EMPNO, ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(?,?,?)";
	private static final String INSERT_EMPLOYEE_QUERY = "INSERT INTO EMP(ENAME,SAL,JOB,DEPTNO) VALUES(?,?,?,?)";
	
	@Autowired
	private DataSource pooled;

	@Override
	public List<Employee> getEmployeesByDesg(String desg1, String desg2, String desg3) throws Exception {
		System.out.println("EmployeeMySqlDAOImpl.getEmployeesByDesg()");
		// get the JDBC connection
		List<Employee> list = null;
		Connection con = pooled.getConnection();
		try(con;){
			// prepared statement
			PreparedStatement ps = con.prepareStatement(GET_EMP_BY_DESG_QUERY);
			
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

	@Override
	public int insertEmployee(Employee emp) throws Exception {
		Connection con = pooled.getConnection();
		//prepared statement
		PreparedStatement ps = con.prepareStatement(INSERT_EMPLOYEE_QUERY);
		int result = 0;
		try(con;ps;){
			
			// set values
			ps.setString(1, emp.getEname());
			ps.setDouble(2, emp.getSalary());
			ps.setString(3, emp.getJob());
			ps.setInt(4, emp.getDeptNo());
			
			// execute query 
			result = ps.executeUpdate();
			
			
		}
		catch(SQLException se) {
			System.out.println("EmployeeMySqlDAOImpl.insertEmployee()");
			se.printStackTrace();
			throw se;
		}
		catch(Exception e) {
			System.out.println("EmployeeMySqlDAOImpl.insertEmployee()");
			e.printStackTrace();
			throw e;
		}
		return result;
	}

}
