package cn.chatsys.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateFlockWin extends JFrame {

	
	private static final long serialVersionUID = -3578310344307774774L;
	private JPanel contentPane;
	private JTextField textFLockName;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateFlockWin frame = new UpdateFlockWin();
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
	public UpdateFlockWin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFLockName = new JTextField();
		textFLockName.setBounds(14, 13, 339, 34);
		contentPane.add(textFLockName);
		textFLockName.setColumns(10);
		
		JButton btnSearchFlock = new JButton("New button");
		btnSearchFlock.setBounds(367, 12, 113, 35);
		contentPane.add(btnSearchFlock);
		
		JLabel lblMyFlock = new JLabel("New label");
		lblMyFlock.setBounds(14, 71, 304, 34);
		contentPane.add(lblMyFlock);
		
		JButton btnNewButton = new JButton("修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(332, 71, 67, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("删除");
		btnNewButton_1.setBounds(413, 71, 67, 34);
		contentPane.add(btnNewButton_1);
		
		JLabel lblOtherFlock = new JLabel("New label");
		lblOtherFlock.setBounds(14, 221, 304, 34);
		contentPane.add(lblOtherFlock);
		
		JButton btnNewButton_2 = new JButton("加入");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(332, 223, 148, 30);
		contentPane.add(btnNewButton_2);
	}
}
