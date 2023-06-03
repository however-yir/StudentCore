package com.system.view;

import java.awt.EventQueue;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.system.dao.StudentDao;
import com.system.dao.UserDao;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JComboBox comboBox;

	/**
	 * Launch the application. 开发者：码不停手
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("学生信息管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 673, 389);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("学生信息管理系统");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel.setBounds(114, 36, 393, 55);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("用户名：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_1.setBounds(106, 112, 145, 31);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("密码：");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(106, 173, 145, 31);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("身份：");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(106, 242, 145, 31);
		panel.add(lblNewLabel_1_2);

		usernameField = new JTextField();
		usernameField.setBounds(227, 112, 249, 37);
		panel.add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(227, 170, 249, 37);
		panel.add(passwordField);
		
		String[] a = new String[] { "管理员", "学生" };
		comboBox = new JComboBox(a);
		comboBox.setBounds(227, 237, 249, 42);
		panel.add(comboBox);

		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 获取文本框数据
				String username = usernameField.getText();
				String password = passwordField.getText();
				String type = (String) comboBox.getSelectedItem();

				// 判断是否为空
				if (username.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(null, "用户名或密码不能为空！");
				} else {
					if ("管理员".equals(type)) {
						// 管理员登录
						try {
							UserDao log = new UserDao();
							boolean istrue = log.LoginCheck(username, password);
							if (istrue) {
								JOptionPane.showMessageDialog(null, "登录成功！");
								String a = "admin";
								setVisible(false);
								new Bg(a).setVisible(true);
							} else {
								JOptionPane.showMessageDialog(null, "用户名或密码错误！");
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} else {
						// 学生登录
						try {
							StudentDao log = new StudentDao();
							boolean istrue = log.LoginCheck(username, password);
							if (istrue) {
								JOptionPane.showMessageDialog(null, "登录成功！");
								String a = "学生"; // 不可修改，控制权限！
								setVisible(false);
								new Bg(a).setVisible(true);
							} else {
								JOptionPane.showMessageDialog(null, "用户名或密码错误！");
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton.setBounds(132, 308, 108, 37);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				usernameField.setText("");
				passwordField.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton_1.setBounds(399, 308, 108, 37);
		panel.add(btnNewButton_1);
	}
}
