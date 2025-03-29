package com.system.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.system.dao.UserDao;
import com.system.entity.Student;

public class StudentUpdate extends Bg {

	private JPanel contentPane;
	private JTextField keyField;
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
	// StudentUpdate frame = new StudentUpdate();
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
	public StudentUpdate(String a) {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		// contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane.setLayout(new BorderLayout(0, 0));
		// setContentPane(contentPane);
		super(a);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(166, 54, 751, 493);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("修改学生信息");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel.setBounds(270, 32, 214, 32);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("输入学号：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblNewLabel_1.setBounds(140, 81, 81, 19);
		panel.add(lblNewLabel_1);

		keyField = new JTextField();
		keyField.setBounds(214, 81, 182, 21);
		panel.add(keyField);
		keyField.setColumns(10);

		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = keyField.getText();
				if (key.equals("")) {
					JOptionPane.showMessageDialog(null, "学号不能为空！");
				} else {

					UserDao user = new UserDao();
					Student stu = new Student();
					try {
						stu = user.select(key);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (stu != null) {
						snoField.setText(String.valueOf(stu.getSno()));
						snameField.setText(stu.getName());
						sageField.setText(String.valueOf(stu.getAge()));
						sclassField.setText(stu.getClas());
						smajorField.setText(stu.getMajor());
						sdeptField.setText(stu.getDept());
						comboBox.setSelectedItem(stu.getGender());
					} else {
						JOptionPane.showMessageDialog(null, "查无此生！");
					}
						

				}
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton.setBounds(429, 77, 75, 26);
		panel.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("查询学生是否存在！");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 13));
		lblNewLabel_2.setBounds(224, 110, 172, 19);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("学生基本信息：");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_3.setBounds(140, 151, 182, 19);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("学号：");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblNewLabel_4.setBounds(140, 193, 53, 21);
		panel.add(lblNewLabel_4);

		snoField = new JTextField();
		snoField.setBounds(190, 188, 227, 32);
		panel.add(snoField);
		snoField.setColumns(10);

		JLabel lblNewLabel_4_1 = new JLabel("姓名：");
		lblNewLabel_4_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(140, 239, 53, 21);
		panel.add(lblNewLabel_4_1);

		snameField = new JTextField();
		snameField.setColumns(10);
		snameField.setBounds(190, 235, 227, 32);
		panel.add(snameField);

		JLabel lblNewLabel_4_1_1 = new JLabel("年龄：");
		lblNewLabel_4_1_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblNewLabel_4_1_1.setBounds(140, 284, 53, 21);
		panel.add(lblNewLabel_4_1_1);

		sageField = new JTextField();
		sageField.setColumns(10);
		sageField.setBounds(190, 277, 227, 32);
		panel.add(sageField);

		sclassField = new JTextField();
		sclassField.setColumns(10);
		sclassField.setBounds(190, 319, 227, 32);
		panel.add(sclassField);

		JLabel lblNewLabel_4_1_1_1 = new JLabel("班级：");
		lblNewLabel_4_1_1_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblNewLabel_4_1_1_1.setBounds(140, 327, 53, 21);
		panel.add(lblNewLabel_4_1_1_1);

		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("班级：");
		lblNewLabel_4_1_1_1_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblNewLabel_4_1_1_1_1.setBounds(140, 327, 53, 21);
		panel.add(lblNewLabel_4_1_1_1_1);

		JLabel lblNewLabel_4_1_1_1_2 = new JLabel("专业：");
		lblNewLabel_4_1_1_1_2.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblNewLabel_4_1_1_1_2.setBounds(140, 373, 53, 21);
		panel.add(lblNewLabel_4_1_1_1_2);

		smajorField = new JTextField();
		smajorField.setColumns(10);
		smajorField.setBounds(190, 369, 227, 32);
		panel.add(smajorField);

		JLabel lblNewLabel_4_1_1_1_2_1 = new JLabel("系别：");
		lblNewLabel_4_1_1_1_2_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblNewLabel_4_1_1_1_2_1.setBounds(140, 416, 53, 21);
		panel.add(lblNewLabel_4_1_1_1_2_1);

		sdeptField = new JTextField();
		sdeptField.setColumns(10);
		sdeptField.setBounds(190, 411, 227, 32);
		panel.add(sdeptField);

		JLabel lblNewLabel_4_1_1_1_2_1_1 = new JLabel("性别：");
		lblNewLabel_4_1_1_1_2_1_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblNewLabel_4_1_1_1_2_1_1.setBounds(140, 462, 53, 21);
		panel.add(lblNewLabel_4_1_1_1_2_1_1);

		String[] b = new String[] { "男", "女" };
		comboBox = new JComboBox(b);
		comboBox.setBounds(190, 453, 227, 30);
		panel.add(comboBox);

		JButton btnNewButton_1 = new JButton("保存");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sno = snoField.getText();
				String sname = snameField.getText();
				String sage = sageField.getText();
				String sclass = sclassField.getText();
				String smajor = smajorField.getText();
				String sdept = sdeptField.getText();
				String sex = (String) comboBox.getSelectedItem();

				UserDao userDao = new UserDao();
				try {
					boolean flag = userDao.update(sno, sname, sex, sage, sclass, smajor, sdept);
					if (flag) {
						JOptionPane.showMessageDialog(null, "修改成功！");
					} else {
						JOptionPane.showMessageDialog(null, "修改失败！");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton_1.setBounds(474, 453, 93, 30);
		panel.add(btnNewButton_1);
	}

}
