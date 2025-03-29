package com.system.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ScoreOperation extends Bg {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// ScoreOperation frame = new ScoreOperation();
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
	public ScoreOperation(String a) {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		// contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane.setLayout(new BorderLayout(0, 0));
		// setContentPane(contentPane);
		super(a);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(166, 53, 751, 494);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("成绩模块基本操作");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(254, 33, 239, 39);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("查询成绩");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				new ScoreSelect(a).setVisible(true);
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton.setBounds(187, 101, 110, 39);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("添加成绩");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (a.equals("学生")) {
					JOptionPane.showMessageDialog(null, "没有权限！");
				} else {
					setVisible(true);
					new ScoreAdd(a).setVisible(true);
				}

			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setBounds(439, 101, 110, 39);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("修改成绩");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (a.equals("学生")) {
					JOptionPane.showMessageDialog(null, "没有权限！");
				} else {
					setVisible(false);
					new ScoreUpdate(a).setVisible(true);
				}

			}
		});
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setBounds(187, 210, 110, 39);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("删除成绩");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (a.equals("学生")) {
					JOptionPane.showMessageDialog(null, "没有权限！");
				} else {
					setVisible(false);
					new ScoreDelect(a).setVisible(true);
				}

			}
		});
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton_3.setBackground(SystemColor.activeCaption);
		btnNewButton_3.setBounds(439, 210, 110, 39);
		panel.add(btnNewButton_3);
	}

}
