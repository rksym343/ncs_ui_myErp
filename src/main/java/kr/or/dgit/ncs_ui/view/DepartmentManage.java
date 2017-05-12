package kr.or.dgit.ncs_ui.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.ncs_ui.content.DepartmentContent;
import kr.or.dgit.ncs_ui.content.TitleContent;
import kr.or.dgit.ncs_ui.table.DepartmentTable;
import kr.or.dgit.ncs_ui.table.TitleTable;

import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DepartmentManage extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnCancel;
	private JButton btnAdd;
	private DepartmentContent pContent;

	public DepartmentManage() {
		setTitle("부서 관리");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		pContent = new DepartmentContent();
		contentPane.add(pContent);

		JPanel pBtn = new JPanel();
		contentPane.add(pBtn);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);

		DepartmentTable pTable = new DepartmentTable();
		pTable.loadData();
		contentPane.add(pTable);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		pContent.clearAll();
	}

}
