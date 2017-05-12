package kr.or.dgit.ncs_ui.table;

import javax.swing.SwingConstants;

import kr.or.dgit.dto.Department;

public class DepartmentTable extends AbsTable<Department> {

	@Override
	protected void cellWith() {
		tableSetWidth(80, 150, 80);
	}

	@Override
	protected void CellAlign() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
	}

	@Override
	protected Object[][] getRowData() {
		return new Object[][]{
			{"D001", "마케팅", 10},
			{"D002", "개발", 9},
			{"D003", "인사", 6},
			{"D004", "총무", 7},
			{"D005", "경영", 4},
		};
	}

	@Override
	protected Object[] getColumn() {
		return new Object[] { "번호", "부서명", "위치" };
	}

	@Override
	protected Department getSelectedObject() {
		int selectedIdx = table.getSelectedRow();
		if (selectedIdx == -1) {
			return null;
		}
		String dcode = (String) table.getValueAt(selectedIdx, 0);
		String dname = (String) table.getValueAt(selectedIdx, 1);
		int floor = (int) table.getValueAt(selectedIdx, 2);
		return new Department(dcode, dname, floor);
	}

}
