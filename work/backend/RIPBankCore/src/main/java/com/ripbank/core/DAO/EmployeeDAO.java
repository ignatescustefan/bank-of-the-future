package com.ripbank.core.DAO;

import java.util.List;
import com.ripbank.core.Employee;

public interface EmployeeDAO {
	public List <Employee> findEmployeeByEmailAndPass(String email, String pass);
	public boolean deleteEmloyee(String email);
}
