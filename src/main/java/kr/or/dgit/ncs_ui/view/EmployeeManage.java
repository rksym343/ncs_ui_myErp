package kr.or.dgit.ncs_ui.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.ncs_ui.content.EmployeeContent;
import kr.or.dgit.ncs_ui.table.AbsTable;
import kr.or.dgit.ncs_ui.table.EmployeeTable;

public class EmployeeManage extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnAdd;
	private JButton btnCancel;
	private EmployeeContent pContent;
	private JPopupMenu popupMenu;
	private AbsTable pTable;
	
	public EmployeeManage() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		pContent = new EmployeeContent();
		contentPane.add(pContent);
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);
		
		pTable = new EmployeeTable();
		pTable.loadData();
		contentPane.add(pTable);

		(pTable.getTable()).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					popupMenu.show(pTable.getTable(), e.getX(), e.getY());
				}
			}
		});
		add(pTable);
		createPopupMenu();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
	}
	protected void actionPerformedBtnAdd(ActionEvent e) {
		if(pContent.pName.getTfValuse().equals("")){
			JOptionPane.showMessageDialog(null, "사원명을 입력해주세요");
			pContent.pName.gettF().requestFocus();
		}
		//입력동작
		//테이블 갱신
		pContent.clearAll();
		
	}
	protected void actionPerformedBtnCancel(ActionEvent e) {
		pContent.clearAll();
	}
	


}
