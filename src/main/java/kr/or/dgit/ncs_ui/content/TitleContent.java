package kr.or.dgit.ncs_ui.content;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import erp_myframework.TextFieldPanel;

public class TitleContent extends JPanel {

	
	private TextFieldPanel pTNo;
	private TextFieldPanel pTName;

	public TitleContent() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		pTNo = new TextFieldPanel();
		pTNo.setTitle("번호");
		add(pTNo);
		
		pTName = new TextFieldPanel();
		pTName.setTitle("직책명");
		add(pTName);

	}
	
	public void clearAll(){
		pTNo.setTfValue("초기값");
		pTName.setTfValue("");
		
	}

}
