package kr.or.dgit.dao;

import java.util.List;

import kr.or.dgit.dto.Department;

public interface DepartmentMapper {
	List<Department> selectByAll();

	Department selectDepartment(Department department);

	int insertDepartment(Department department);

	int updateDepartment(Department department);

	int deleteDepartment(Department department);
}
