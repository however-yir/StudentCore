package com.system.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.system.dao.CourseDao;
import com.system.entity.Course;

public class CourseSelect extends JFrame {

	private JPanel contentPane;
	private JTextField keyField;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// CourseSelect frame = new CourseSelect();
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
	public CourseSelect() {
		setBounds(100, 100, 780, 486);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final Vector vector = new Vector();
		vector.add("序号");
		vector.add("课程号");
		vector.add("课程名");
		vector.add("学分");
		vector.add("学时");

		Vector tData = new Vector();

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 764, 45);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("课程基本上信息");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblNewLabel.setBounds(263, 10, 191, 25);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 44, 764, 51);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("课程号：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblNewLabel_1.setBounds(177, 10, 79, 31);
		panel_1.add(lblNewLabel_1);

		keyField = new JTextField();
		keyField.setBounds(247, 10, 194, 31);
		panel_1.add(keyField);
		keyField.setColumns(10);

		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = keyField.getText();
				if (key.equals("")) {
					JOptionPane.showMessageDialog(null, "课程号不能为空！");
				} else {
					tData.clear();
					int a = Integer.parseInt(key);
					CourseDao user = new CourseDao();
					try {
						Course course = user.selectByCno(a);
						Vector v = new Vector();
						v.add(course.getCnum());
						v.add(course.getCno());
						v.add(course.getCname());
						v.add(course.getCcredit());
						v.add(course.getCtime());
						tData.add(v);
						table = new JTable(tData, vector);
						scrollPane.setViewportView(table);

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton.setBounds(451, 11, 79, 28);
		panel_1.add(btnNewButton);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 94, 764, 353);
		contentPane.add(scrollPane);




		tData.clear();
		CourseDao user = new CourseDao();
		try {
			List<Course> list = user.courseRes();
			for (int i = 0; i < list.size(); i++) {
				Vector v = new Vector();
				v.add(list.get(i).getCnum());
				v.add(list.get(i).getCno());
				v.add(list.get(i).getCname());
				v.add(list.get(i).getCcredit());
				v.add(list.get(i).getCtime());
				tData.add(v);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		table = new JTable(tData, vector);
		scrollPane.setViewportView(table);



	}
}
