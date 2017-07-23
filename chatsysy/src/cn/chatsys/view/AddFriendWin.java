package cn.chatsys.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddFriendWin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7659681364568562888L;
	private JPanel contentPane;
	private JTextField textFriendLoginName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFriendWin frame = new AddFriendWin();
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
	public AddFriendWin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 461);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFriendLoginName = new JTextField();
		textFriendLoginName.setBounds(14, 13, 308, 30);
		contentPane.add(textFriendLoginName);
		textFriendLoginName.setColumns(10);
		
		JButton btnSearch = new JButton("New button");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBounds(336, 12, 113, 30);
		contentPane.add(btnSearch);
		
		JLabel lblFriendLoginName = new JLabel("好友名字");
		lblFriendLoginName.setBounds(14, 69, 308, 30);
		contentPane.add(lblFriendLoginName);
		
		JButton btnAddFriend = new JButton("New button");
		btnAddFriend.setBounds(336, 68, 113, 32);
		contentPane.add(btnAddFriend);
	}
}
