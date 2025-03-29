package com.system.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.system.dao.CourseDao;
import com.system.entity.Course;

public class CourseUpdate extends Bg {

	private JPanel contentPane;
	private JTextField keyField;
	private JTextField cnoField;
	private JTextField cnameField;
	private JTextField ccreditField;
	private JTextField ctimeField;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// CourseUpdate frame = new CourseUpdate();
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
	public CourseUpdate(String a) {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		// contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane.setLayout(new BorderLayout(0, 0));
		// setContentPane(contentPane);
		super(a);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(166, 52, 751, 495);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("修改课程");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel.setBounds(256, 38, 233, 38);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("课程号：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(162, 89, 94, 28);
		panel.add(lblNewLabel_1);

		keyField = new JTextField();
		keyField.setBounds(254, 86, 224, 37);
		panel.add(keyField);
		keyField.setColumns(10);

		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = keyField.getText();
				if (key.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入课程号！");
				} else {
					CourseDao course = new CourseDao();
					Course c = new Course();
					try {
						c = course.select(key);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (c != null) {
						cnoField.setText(String.valueOf(c.getCno()));
						cnameField.setText(c.getCname());
						ccreditField.setText(c.getCcredit());
						ctimeField.setText(c.getCtime());
					} else {
						JOptionPane.showMessageDialog(null, "课程表里没有此课程的信息，无法修改！");
					}
				}


			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton.setBounds(496, 89, 93, 34);
		panel.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("课程基本信息");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_2.setBounds(162, 156, 170, 28);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("课程号：");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_3.setBounds(162, 211, 73, 28);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("课程名：");
		lblNewLabel_3_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(162, 271, 73, 28);
		panel.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("学分：");
		lblNewLabel_3_2.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_3_2.setBounds(162, 332, 73, 28);
		panel.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("学时：");
		lblNewLabel_3_3.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_3_3.setBounds(162, 389, 73, 28);
		panel.add(lblNewLabel_3_3);

		cnoField = new JTextField();
		cnoField.setBounds(238, 208, 240, 38);
		panel.add(cnoField);
		cnoField.setColumns(10);

		cnameField = new JTextField();
		cnameField.setColumns(10);
		cnameField.setBounds(238, 268, 240, 38);
		panel.add(cnameField);

		ccreditField = new JTextField();
		ccreditField.setColumns(10);
		ccreditField.setBounds(238, 329, 240, 38);
		panel.add(ccreditField);

		ctimeField = new JTextField();
		ctimeField.setColumns(10);
		ctimeField.setBounds(238, 386, 240, 38);
		panel.add(ctimeField);

		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cno = cnoField.getText();
				String cname = cnameField.getText();
				String ccredit = ccreditField.getText();
				String ctime = ctimeField.getText();

				if (cno.equals("") || cname.equals("") || ccredit.equals("") || ctime.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入完整的信息！");
				} else {

					CourseDao courseDao = new CourseDao();
					boolean istrue = false;
					try {
						istrue = courseDao.update(cno, cname, ccredit, ctime);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (istrue) {
						JOptionPane.showMessageDialog(null, "修改成功！");
					} else {
						JOptionPane.showMessageDialog(null, "修改失败，请检查输入信息是否正确！");
					}
				}
			}
		});
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton_1.setBounds(280, 447, 136, 38);
		panel.add(btnNewButton_1);
	}

}
