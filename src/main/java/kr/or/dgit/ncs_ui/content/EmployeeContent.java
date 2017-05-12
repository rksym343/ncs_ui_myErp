package kr.or.dgit.ncs_ui.content;

import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JPanel;

import erp_myframework.ComboPanel;
import erp_myframework.RadioButtonPanel;
import erp_myframework.SpinnerPanel;
import erp_myframework.TextFieldPanel;

public class EmployeeContent extends JPanel {

	public TextFieldPanel pNo;
	public TextFieldPanel pName;
	public ComboPanel<String> pTitle;
	public SpinnerPanel pSalary;
	public RadioButtonPanel pGender;
	public ComboPanel<String> pDepartment;
	public TextFieldPanel pJoinDate;

	public EmployeeContent() {
		setLayout(new GridLayout(0, 1, 0, 0));

		pNo = new TextFieldPanel();
		pNo.setTitle("번호");
		pNo.gettF().setEnabled(false);
		pNo.setTfValue("E017005");
		add(pNo);

		pName = new TextFieldPanel();
		pName.setTitle("사원명");
		add(pName);

		pTitle = new ComboPanel();
		pTitle.setTitle("직책");
		Vector<String> items = new Vector<>();
		items.add("사장");
		items.add("부장");
		items.add("과장");
		items.add("대리");
		items.add("사원");
		pTitle.setComboDate(items);
		add(pTitle);

		pSalary = new SpinnerPanel();
		pSalary.setTitle("급여");
		pSalary.setValues(1500000, 1000000, 5000000, 100000);
		add(pSalary);

		pGender = new RadioButtonPanel();
		pGender.setTitle("성별");
		pGender.setRadioItems("남", "여");
		pGender.setSelectedItem("남");
		add(pGender);

		pDepartment = new ComboPanel();
		pDepartment.setTitle("부서");
		Vector<String> items2 = new Vector<>();
		items2.add("마케팅(10층)");
		items2.add("개발(9층)");
		items2.add("경영(4층)");
		pDepartment.setComboDate(items2);
		add(pDepartment);

		pJoinDate = new TextFieldPanel();
		pJoinDate.setTitle("입사일");

		pJoinDate.setTfValue(nowDate());
		add(pJoinDate);

	}

	public void clearAll() {
		pNo.setTfValue("초기값");
		pName.setTfValue("");
		pTitle.setSelectedIndex(0);
		pSalary.setValue(1500000);
		pGender.setSelectedItem(0);
		pDepartment.setSelectedIndex(0);
		pJoinDate.setTfValue(nowDate());
	}

	public String nowDate() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(cal.YEAR);
		int month = cal.get(cal.MONTH) + 1;
		int date = cal.get(cal.DATE);
		return String.format("%d-%02d-%d", year, month, date);
	}

}
