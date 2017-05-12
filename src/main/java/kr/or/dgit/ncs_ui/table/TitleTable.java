package kr.or.dgit.ncs_ui.table;

import javax.swing.SwingConstants;

import kr.or.dgit.dto.Department;
import kr.or.dgit.dto.Title;

public class TitleTable extends AbsTable<Title> {

	@Override
	protected void cellWith() {
		tableSetWidth(80, 100);
	}

	@Override
	protected void CellAlign() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1);
	}

	@Override
	protected Object[][] getRowData() {
		return new Object[][]{
			{"T001","사장"},
			{"T002","부장"},
			{"T003","과장"},
			{"T004","대리"},
			{"T005","사원"},
		};
	}

	@Override
	protected Object[] getColumn() {
		return new Object[] { "번호", "직책"};
	}

	@Override
	protected Title getSelectedObject() {
		int selectedIdx = table.getSelectedRow();
		if (selectedIdx == -1) {
			return null;
		}
		String tcode = (String) table.getValueAt(selectedIdx, 0);
		String tname = (String) table.getValueAt(selectedIdx, 1);
		return new Title(tcode, tname);
	}

}
