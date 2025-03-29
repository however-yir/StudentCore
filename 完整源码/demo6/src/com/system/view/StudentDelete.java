package com.system.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.system.dao.UserDao;

public class StudentDelete extends Bg {

	private JPanel contentPane;
	private JTextField keyField;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// StudentDelete frame = new StudentDelete();
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
	public StudentDelete(String a) {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		// contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane.setLayout(new BorderLayout(0, 0));
		// setContentPane(contentPane);
		super(a);

		JLabel lblNewLabel = new JLabel("删除学生信息");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel.setBounds(442, 113, 227, 37);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("输入学号：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_1.setBounds(402, 197, 81, 27);
		getContentPane().add(lblNewLabel_1);

		keyField = new JTextField();
		keyField.setBounds(485, 193, 184, 37);
		getContentPane().add(keyField);
		keyField.setColumns(10);

		JButton btnNewButton = new JButton("删除");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = keyField.getText();
				if (key.equals("")) {
					JOptionPane.showMessageDialog(null, "学号不能为空！");
				} else {
					UserDao user = new UserDao();
					try {
						if (user.delete(key)) {
							JOptionPane.showMessageDialog(null, "删除学生成功！");
						} else {
							JOptionPane.showMessageDialog(null, "删除学生失败，请检查该学号是否正确！");
						}
					} catch (Exception e1) {

					}

				}
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton.setBounds(696, 193, 102, 37);
		getContentPane().add(btnNewButton);
	}

}
