package com.tima;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {
		System.out.println("rownumber: " + rownumber);
		Employee e = null;
		// while (rs.next()) {
		e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3));
		// }
		return e;
	}

}
