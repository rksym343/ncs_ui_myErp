package kr.or.dgit.ncs_ui.table;

import javax.swing.SwingConstants;

import kr.or.dgit.dto.Department;
import kr.or.dgit.dto.Employee;
import kr.or.dgit.dto.Title;

public class EmployeeTable extends AbsTable<Employee> {

	@Override
	protected void cellWith() {
		tableSetWidth(80, 100, 80, 150, 80, 100, 100);
	}

	@Override
	protected void CellAlign() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 4, 5, 6);
		tableCellAlignment(SwingConstants.RIGHT, 3);

	}

	@Override
	protected Object[][] getRowData() {
		return new Object[][] { { "E017001", "나사장", "사장", "5,000,000", "남자", "경영(4층)", "2017-03-01" },
				{ "E017002", "나부장", "부장", "4,000,000", "남자", "마케팅(10층)", "2017-03-01" },
				{ "E017003", "너부장", "부장", "4,000,000", "여자", "개발(9층)", "2017-03-01" },
				{ "E017004", "나과장", "과장", "3,500,000", "남자", "마케팅(10층)", "2017-03-01" }, };
	}

	@Override
	protected Object[] getColumn() {
		return new Object[] { "번호", "사원명", "직책", "급여", "성별", "부서", "입사일" };
	}

	@Override
	protected Employee getSelectedObject() {
		int selectedIdx = table.getSelectedRow();
		if (selectedIdx == -1) {
			return null;
		}
		String eno = (String) table.getValueAt(selectedIdx, 0);
		String ename = (String) table.getValueAt(selectedIdx, 1);
		String titleInfo = (String) table.getValueAt(selectedIdx, 2);
		Title title = new Title();
		title.setTname(titleInfo);
		
		int salary = (int) table.getValueAt(selectedIdx, 3);
		
		boolean gender = ((String) table.getValueAt(selectedIdx, 4)).equals("남자")?true:false;
		

		String depInfo = (String) table.getValueAt(selectedIdx, 5);
		int idx = depInfo.indexOf("(");
		String dname = depInfo.substring(0, idx);
		Department dno = new Department();
		dno.setDname(dname);
		
		String joindate = (String) table.getValueAt(selectedIdx, 6);
		
		
		
		return new Employee(eno, ename, salary, dno, gender, joindate, title);
	}

}
