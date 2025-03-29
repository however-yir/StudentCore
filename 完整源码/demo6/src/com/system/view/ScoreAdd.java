package com.system.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.system.dao.ScoreDao;

public class ScoreAdd extends JFrame {

	private JPanel contentPane;
	private JTextField snoField;
	private JTextField cnoField;
	private JTextField sscoreField;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// ScoreAdd frame = new ScoreAdd();
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
	public ScoreAdd(String a) {
		setBounds(100, 100, 695, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 679, 396);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("添加学生成绩");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel.setBounds(193, 55, 252, 45);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("学号：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(141, 110, 72, 31);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("课程号：");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(141, 174, 72, 31);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("成绩：");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(141, 229, 72, 31);
		panel.add(lblNewLabel_1_2);

		snoField = new JTextField();
		snoField.setBounds(203, 110, 276, 31);
		panel.add(snoField);
		snoField.setColumns(10);

		cnoField = new JTextField();
		cnoField.setColumns(10);
		cnoField.setBounds(203, 175, 276, 31);
		panel.add(cnoField);

		sscoreField = new JTextField();
		sscoreField.setColumns(10);
		sscoreField.setBounds(203, 230, 276, 31);
		panel.add(sscoreField);

		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sno = snoField.getText();
				String cno = cnoField.getText();
				String sscore = sscoreField.getText();

				// 判断操作
				if (sno.equals("") || cno.equals("") || sscore.equals("")) {
					JOptionPane.showMessageDialog(null, "请将信息填写完整！");
				} else {

					ScoreDao scoreDao = new ScoreDao();
					boolean istrue = false;
					try {
						istrue = scoreDao.insert(sno, cno, sscore);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (istrue) {
						JOptionPane.showMessageDialog(null, "成绩录入成功！");

					} else {
						JOptionPane.showMessageDialog(null, "成绩录入失败，请检查学号与课程号是否正确！");
					}

				}

			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton.setBounds(141, 302, 108, 39);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				snoField.setText("");
				cnoField.setText("");
				sscoreField.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton_1.setBounds(412, 302, 108, 39);
		panel.add(btnNewButton_1);

		JLabel lblNewLabel_2 = new JLabel("请勿重复添加成绩！");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 12));
		lblNewLabel_2.setBounds(203, 259, 276, 22);
		panel.add(lblNewLabel_2);
	}
}
