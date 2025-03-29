package com.system.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.system.dao.UserDao;

public class StudentAdd extends JFrame {

	private JPanel contentPane;
	private JTextField snoField;
	private JTextField snameField;
	private JTextField sageField;
	private JTextField sclassField;
	private JTextField smajorField;
	private JTextField sdeptField;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// StudentAdd frame = new StudentAdd();
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
	public StudentAdd(String admin) {
		setBounds(100, 100, 723, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 707, 467);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("添加学生");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel.setBounds(237, 28, 172, 36);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("学号：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(201, 81, 53, 30);
		panel.add(lblNewLabel_1);

		snoField = new JTextField();
		snoField.setBounds(267, 80, 194, 36);
		panel.add(snoField);
		snoField.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("姓名：");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(201, 129, 53, 30);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("年龄：");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(201, 178, 53, 30);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("班级：");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(201, 231, 53, 30);
		panel.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("专业：");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(201, 277, 53, 30);
		panel.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("系别：");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(201, 330, 53, 30);
		panel.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_6 = new JLabel("性别：");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_6.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblNewLabel_1_6.setBounds(201, 381, 53, 30);
		panel.add(lblNewLabel_1_6);

		snameField = new JTextField();
		snameField.setColumns(10);
		snameField.setBounds(267, 126, 194, 36);
		panel.add(snameField);

		sageField = new JTextField();
		sageField.setColumns(10);
		sageField.setBounds(267, 177, 194, 36);
		panel.add(sageField);

		sclassField = new JTextField();
		sclassField.setColumns(10);
		sclassField.setBounds(267, 230, 194, 36);
		panel.add(sclassField);

		smajorField = new JTextField();
		smajorField.setColumns(10);
		smajorField.setBounds(267, 276, 194, 36);
		panel.add(smajorField);

		sdeptField = new JTextField();
		sdeptField.setColumns(10);
		sdeptField.setBounds(267, 329, 194, 36);
		panel.add(sdeptField);

		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sno = snoField.getText();
				String sname = snameField.getText();
				String sage = sageField.getText();
				String sclass = sclassField.getText();
				String smajor = smajorField.getText();
				String sdept = sdeptField.getText();
				String sex = (String) comboBox.getSelectedItem();
				
				if (sno.equals("") || sname.equals("") || sage.equals("") || sclass.equals("") || smajor.equals("")
						|| sdept.equals("") || sex.equals("")) {
					JOptionPane.showMessageDialog(null, "信息不完整，请填写完整！");
				} else {
					UserDao userDao = new UserDao();
					try {
						boolean istrue = userDao.insert(sno, sname, sex, sage, sclass, smajor, sdept);
							if (istrue) {
								JOptionPane.showMessageDialog(null, "学生信息录入成功！");
							} else{
								JOptionPane.showMessageDialog(null, "学生录入失败，此学号已存在！");
							}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}

		});
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton.setBounds(201, 427, 93, 30);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				snoField.setText("");
				snameField.setText("");
				sageField.setText("");
				sclassField.setText("");
				smajorField.setText("");
				sdeptField.setText("");

			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton_1.setBounds(390, 427, 93, 30);
		panel.add(btnNewButton_1);

		String[] a = new String[] { "男", "女" };
		comboBox = new JComboBox(a);
		comboBox.setBounds(267, 381, 194, 27);
		panel.add(comboBox);



	}
}
