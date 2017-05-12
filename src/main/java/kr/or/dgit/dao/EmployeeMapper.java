package kr.or.dgit.dao;

import java.util.List;

import kr.or.dgit.dto.Employee;

public interface EmployeeMapper {
	List<Employee> selectByAll();

	Employee selectEmployee(Employee employee);

	int insertEmployee(Employee employee);

	int updateEmployee(Employee employee);

	int deleteEmployee(Employee employee);
}
