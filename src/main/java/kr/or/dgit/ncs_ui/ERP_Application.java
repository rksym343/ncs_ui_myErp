package kr.or.dgit.ncs_ui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.ncs_ui.view.DepartmentManage;
import kr.or.dgit.ncs_ui.view.EmployeeManage;
import kr.or.dgit.ncs_ui.view.TitleManage;

public class ERP_Application extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnEmployee;
	private JButton btnDepartment;
	private JButton btnTitle;
	private EmployeeManage em;
	private DepartmentManage dm;
	private TitleManage tm;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ERP_Application frame = new ERP_Application();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ERP_Application() {
		setTitle("대구아이티ERP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 20, 0));

		btnEmployee = new JButton("사원관리");
		btnEmployee.addActionListener(this);
		contentPane.add(btnEmployee);

		btnDepartment = new JButton("부서관리");
		btnDepartment.addActionListener(this);
		contentPane.add(btnDepartment);

		btnTitle = new JButton("직책관리");
		btnTitle.addActionListener(this);
		contentPane.add(btnTitle);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnTitle) {
			actionPerformedBtnTitle(e);
		}
		if (e.getSource() == btnDepartment) {
			actionPerformedBtnDepartment(e);
		}
		if (e.getSource() == btnEmployee) {
			actionPerformedBtnEmployee(e);
		}
	}

	protected void actionPerformedBtnEmployee(ActionEvent e) {
		if (em == null) {
			em = new EmployeeManage();
			em.setVisible(true);
		}

	}

	protected void actionPerformedBtnDepartment(ActionEvent e) {
		if (dm == null) {
			dm = new DepartmentManage();
			dm.setVisible(true);
		}

	}

	protected void actionPerformedBtnTitle(ActionEvent e) {
		if (tm == null) {
			tm = new TitleManage();
			tm.setVisible(true);
		}

	}
}
