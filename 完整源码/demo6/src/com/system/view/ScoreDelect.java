package com.system.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.system.dao.ScoreDao;

public class ScoreDelect extends Bg {

	private JPanel contentPane;
	private JTextField snoField;
	private JTextField cnoField;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// ScoreDelect frame = new ScoreDelect();
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
	public ScoreDelect(String a) {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 746, 527);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
		super(a);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(166, 52, 751, 495);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("删除成绩");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel.setBounds(234, 54, 214, 42);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("学号：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_1.setBounds(153, 110, 107, 30);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("课程号：");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(153, 170, 107, 30);
		panel.add(lblNewLabel_1_1);

		snoField = new JTextField();
		snoField.setBounds(244, 112, 285, 30);
		panel.add(snoField);
		snoField.setColumns(10);

		cnoField = new JTextField();
		cnoField.setColumns(10);
		cnoField.setBounds(244, 172, 285, 30);
		panel.add(cnoField);

		JButton btnNewButton = new JButton("删除");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sno = snoField.getText();
				String cno = cnoField.getText();

				if (sno.equals("") || cno.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入完整的信息！");
				} else {
					ScoreDao score = new ScoreDao();
					try {
						if (score.delete(sno, cno)) {
							JOptionPane.showMessageDialog(null, "成绩删除成功！");
						} else {
							JOptionPane.showMessageDialog(null, "请检查学号与课程号是否正确，或已被删除！");
						}
					} catch (Exception e1) {

					}

				}
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(289, 252, 124, 36);
		panel.add(btnNewButton);
	}

}
