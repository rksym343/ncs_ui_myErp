package kr.or.dgit.ncs_ui.content;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import erp_myframework.TextFieldPanel;

public class DepartmentContent extends JPanel {
	
	private TextFieldPanel pDNo;
	private TextFieldPanel pDName;
	private TextFieldPanel pDFloor;

	public DepartmentContent() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		pDNo = new TextFieldPanel();
		pDNo.setTitle("번호");
		add(pDNo);
		
		pDName = new TextFieldPanel();
		pDName.setTitle("부서명");
		add(pDName);
		
		pDFloor = new TextFieldPanel();
		pDFloor.setTitle("위치");
		add(pDFloor);

	}
	
	public void clearAll(){
		pDNo.setTfValue("초기값");
		pDName.setTfValue("");
		pDFloor.setTfValue("");
	}
	
	

}
