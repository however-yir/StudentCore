package com.system.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CourseOperation extends Bg {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// CourseOperation frame = new CourseOperation();
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
	public CourseOperation(String a) {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		// contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane.setLayout(new BorderLayout(0, 0));
		// setContentPane(contentPane);
		super(a);

		JLabel lblNewLabel = new JLabel("课程相关操作");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel.setBounds(370, 94, 352, 43);
		getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("查询课程");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				new CourseSelect().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
		btnNewButton.setBounds(353, 174, 148, 37);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("添加课程");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (a.equals("学生")) {
					JOptionPane.showMessageDialog(null, "没有权限！");
				} else {
					setVisible(false);
					new CourseAdd(a).setVisible(true);
				}

			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		btnNewButton_1.setBounds(622, 174, 148, 37);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("修改课程");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (a.equals("学生")) {
					JOptionPane.showMessageDialog(null, "没有权限！");
				} else {
					setVisible(false);
					new CourseUpdate(a).setVisible(true);
				}

			}
		});
		btnNewButton_2.setFont(new Font("微软雅黑", Font.BOLD, 16));
		btnNewButton_2.setBounds(353, 274, 148, 37);
		getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("删除课程");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (a.equals("学生")) {
					JOptionPane.showMessageDialog(null, "没有权限！");
				} else {
					setVisible(false);
					new CourseDelect(a).setVisible(true);
				}

			}
		});
		btnNewButton_3.setFont(new Font("微软雅黑", Font.BOLD, 16));
		btnNewButton_3.setBounds(622, 274, 148, 37);
		getContentPane().add(btnNewButton_3);
	}

}
