package com.system.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Bg extends JFrame {

	private JPanel contentPane;
	private JPanel panel_2; // 学生模块
	private JPanel panel_3; // 成绩模块
	private JPanel panel_4; // 课程模块

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// BgAdmin frame = new BgAdmin();
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
	public Bg(String flag) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 586);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 917, 53);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("学生信息管理系统");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("微软雅黑", Font.BOLD, 16));
		label.setBounds(371, 10, 213, 33);
		panel.add(label);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1.setBounds(0, 52, 166, 495);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("学生模块");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (flag.equals("admin")) {
					// 管理员端
					setVisible(false);
					new StudentOpetion("admin").setVisible(true);
				} else {
					// 学生端
					setVisible(false);
					new StudentOpetion("学生").setVisible(true);
				}

			}
		});
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 166, 58);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("成绩模块");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (flag.equals("admin")) {
					// 管理员端
					setVisible(false);
					new ScoreOperation("admin").setVisible(true);
				} else {
					// 学生端
					setVisible(false);
					new ScoreOperation("学生").setVisible(true);
				}
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_1.setBounds(0, 63, 166, 58);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("课程模块");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (flag.equals("admin")) {
					// 管理员端
					setVisible(false);
					new CourseOperation("admin").setVisible(true);
				} else {
					// 学生端
					setVisible(false);
					new CourseOperation("学生").setVisible(true);
				}

			}
		});
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_2.setBounds(0, 131, 166, 58);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("退出系统");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_3.setBounds(0, 199, 166, 58);
		panel_1.add(lblNewLabel_3);


	}

}
