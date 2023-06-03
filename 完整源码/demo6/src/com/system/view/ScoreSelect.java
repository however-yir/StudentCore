package com.system.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import com.system.dao.ScoreDao;
import com.system.entity.Score;

public class ScoreSelect extends JFrame {

	private JPanel contentPane;
	private JTextField keyField;
	private JTable table;

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
	public ScoreSelect(String a) {
		setBounds(100, 100, 808, 529);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final Vector vector = new Vector();
		Vector tData = new Vector();
		vector.add("学号");
		vector.add("姓名");
		vector.add("课程号");
		vector.add("课程名");
		vector.add("成绩");
		vector.add("补考成绩");

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 792, 47);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("学生成绩");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel.setBounds(305, 10, 134, 27);
		panel.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 90, 792, 400);
		contentPane.add(scrollPane);



		ScoreDao score = new ScoreDao();
		try {
			tData.clear();
			List<Score> list = score.scoreRes("");
			for (int i = 0; i < list.size(); i++) {
				Vector v = new Vector();
				v.add(list.get(i).getSno());
				v.add(list.get(i).getSname());
				v.add(list.get(i).getCno());
				v.add(list.get(i).getCname());
				v.add(list.get(i).getSscore());
				v.add(list.get(i).getRescore());
				tData.add(v);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		table = new JTable(tData, vector);
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 46, 792, 47);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("学号：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(214, 10, 59, 27);
		panel_1.add(lblNewLabel_1);

		keyField = new JTextField();
		keyField.setBounds(267, 14, 170, 23);
		panel_1.add(keyField);
		keyField.setColumns(10);

		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = keyField.getText();
				if (key.equals("")) {
					JOptionPane.showMessageDialog(null, "学号不能为空！");
				} else {
					tData.clear();
					ScoreDao score = new ScoreDao();
					try {
						List<Score> list = score.scoreRes(key);
						for (int i = 0; i < list.size(); i++) {
							Vector v = new Vector();
							v.add(list.get(i).getSno());
							v.add(list.get(i).getSname());
							v.add(list.get(i).getCno());
							v.add(list.get(i).getCname());
							v.add(list.get(i).getSscore());
							v.add(list.get(i).getRescore());
							tData.add(v);
						}
					} catch (Exception a) {
						// TODO Auto-generated catch block
						a.printStackTrace();
					}

					table = new JTable(tData, vector);
					scrollPane.setViewportView(table);

				}
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnNewButton.setBounds(458, 10, 76, 27);
		panel_1.add(btnNewButton);
	}

}
