package com.system.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.system.dao.UserDao;
import com.system.entity.Student;

public class StudentSelect extends JFrame {

	private JPanel contentPane;
	private JTextField keyField;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// StudentSelect frame = new StudentSelect();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public StudentSelect(String flag) {
		setTitle("学生信息管理系统");
		setBounds(100, 100, 845, 558);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 848, 51);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("学生基本信息");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(325, 10, 222, 31);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 49, 829, 51);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("学号:");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblNewLabel_1.setBounds(225, 10, 54, 31);
		panel_1.add(lblNewLabel_1);

		// 表头
		final Vector vector = new Vector();
		vector.add("学号");
		vector.add("姓名");
		vector.add("性别");
		vector.add("年龄");
		vector.add("班级");
		vector.add("专业");
		vector.add("系别");

		// 表里面的数据
		Vector tData = new Vector();

		keyField = new JTextField();
		keyField.setBounds(273, 10, 190, 31);
		panel_1.add(keyField);
		keyField.setColumns(10);

		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 根据学号查询学生
				String key = keyField.getText();
				if (key.equals("")) {
					JOptionPane.showMessageDialog(null, "学号不能为空！");
				} else {
					try {
						UserDao user = new UserDao();
						List<Student> list = user.Select(key, null);
						tData.clear();
						for (int i = 0; i < list.size(); i++) {
							Vector v = new Vector();
							v.add(list.get(i).getSno());
							v.add(list.get(i).getName());
							v.add(list.get(i).getGender());
							v.add(list.get(i).getAge());
							v.add(list.get(i).getClas());
							v.add(list.get(i).getMajor());
							v.add(list.get(i).getDept());
							tData.add(v);
						}
						table = new JTable(tData, vector);
						scrollPane.setViewportView(table);
						// table = new JTable(tData, vector);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton.setBounds(483, 10, 67, 31);
		panel_1.add(btnNewButton);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 98, 829, 421);
		contentPane.add(scrollPane);

		try {
			UserDao user = new UserDao();
			List<Student> list = user.res();
			tData.clear();
			for (int i = 0; i < list.size(); i++) {
				Vector v = new Vector();
				v.add(list.get(i).getSno());
				v.add(list.get(i).getName());
				v.add(list.get(i).getGender());
				v.add(list.get(i).getAge());
				v.add(list.get(i).getClas());
				v.add(list.get(i).getMajor());
				v.add(list.get(i).getDept());
				tData.add(v);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		table = new JTable(tData, vector);
		scrollPane.setViewportView(table);
	}
}
