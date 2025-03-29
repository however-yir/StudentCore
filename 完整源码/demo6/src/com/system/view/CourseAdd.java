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

public class CourseAdd extends Bg {

	private JPanel contentPane;
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
	// CourseAdd frame = new CourseAdd();
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
	public CourseAdd(String a) {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		// contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane.setLayout(new BorderLayout(0, 0));
		// setContentPane(contentPane);
		super(a);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(165, 52, 752, 495);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("添加课程");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(263, 47, 217, 37);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("课程号：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(216, 94, 83, 37);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("课程名：");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(216, 161, 83, 37);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("学分：");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(216, 229, 83, 37);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("学时：");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_1_2_1.setBounds(216, 292, 83, 37);
		panel.add(lblNewLabel_1_2_1);

		cnoField = new JTextField();
		cnoField.setBounds(297, 94, 271, 37);
		panel.add(cnoField);
		cnoField.setColumns(10);

		cnameField = new JTextField();
		cnameField.setColumns(10);
		cnameField.setBounds(297, 161, 271, 37);
		panel.add(cnameField);

		ccreditField = new JTextField();
		ccreditField.setColumns(10);
		ccreditField.setBounds(297, 229, 271, 37);
		panel.add(ccreditField);

		ctimeField = new JTextField();
		ctimeField.setColumns(10);
		ctimeField.setBounds(297, 292, 271, 37);
		panel.add(ctimeField);

		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
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
						istrue = courseDao.insert(cno, cname, ccredit, ctime);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (istrue) {
						JOptionPane.showMessageDialog(null, "增加课程成功！");
					} else {
						JOptionPane.showMessageDialog(null, "增加课程失败，该课程号已存在！");
					}
				}
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton.setBounds(216, 374, 93, 37);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cnoField.setText("");
				cnameField.setText("");
				ccreditField.setText("");
				ctimeField.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton_1.setBounds(514, 374, 93, 37);
		panel.add(btnNewButton_1);
	}

}
