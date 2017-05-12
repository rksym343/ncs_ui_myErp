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

import kr.or.dgit.ncs_ui.table.AbsTable;

public abstract class AbsView<T> extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JPopupMenu popupMenu;
	public JPanel pContent;
	public JButton btnAdd;
	public JButton btnCancel;
	public AbsTable<T> pTable;

	public AbsView() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		pContent = createContent();
		getContentPane().add(pContent);

		JPanel pBtn = new JPanel();
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);
		
		getContentPane().add(pBtn);

		pTable = createTable();

		(pTable.getTable()).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					// MouseEvent.BUTTON1 : 왼쪽 마우스 버튼
					// MouseEvent.BUTTON2 : 중간 마우스 버튼
					// MouseEvent.BUTTON3 : 오른쪽 마우스 버튼
					popupMenu.show(pTable, e.getX(), e.getY());
				}
			}
		});
		getContentPane().add(pTable);
		createPopupMenu();
	}

	protected abstract AbsTable<T> createTable();

	protected abstract JPanel createContent();

	private JPopupMenu createPopupMenu() {
		popupMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				T t = pTable.getSelectedObject();
				if (t == null) {
					JOptionPane.showMessageDialog(null, "데이터를 선택하세요");
					return;
				}
				pContent.setObject(t);
				btnAdd.setText("수정");
			}
		});
		popupMenu.add(updateItem);

		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				T t = pTable.getSelectedObject();
				if (t == null) {
					JOptionPane.showMessageDialog(null, "데이터를 선택하세요");
					return;
				}
				int res = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까");
				if (res != 0) {
					JOptionPane.showMessageDialog(null, "취소하였습니다");
					return;
				}
				dao.deleteItem(t);
				pContent.clear();
				setNoInit();
				pTable.loadData();
				JOptionPane.showMessageDialog(null, "삭제되었습니다");
			}
		});
		popupMenu.add(deleteItem);

		return null;
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
		if (e.getActionCommand().equals("추가")) {
			dao.insertItem(pContent.getObject());
			msg = "추가되었습니다.";
		} else {
			dao.updateItem(pContent.getObject());
			msg = "수정되었습니다.";
			btnAdd.setText("추가");
		}
	}
	protected void actionPerformedBtnCancel(ActionEvent e) {
	}
}
