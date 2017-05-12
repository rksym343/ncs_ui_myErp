package kr.or.dgit.ncs_ui.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.ncs_ui.content.TitleContent;
import kr.or.dgit.ncs_ui.table.TitleTable;

import javax.swing.BoxLayout;
import javax.swing.JButton;

public class TitleManage extends JFrame {

	private JPanel contentPane;

	public TitleManage() {
		setTitle("직책 관리");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		TitleContent pContent = new TitleContent();
		contentPane.add(pContent);
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn);
		
		JButton btnAdd = new JButton("추가");
		pBtn.add(btnAdd);
		
		JButton btnCancel = new JButton("취소");
		pBtn.add(btnCancel);
		
		TitleTable pTable = new TitleTable();
		pTable.loadData();
		contentPane.add(pTable);
	}

}
