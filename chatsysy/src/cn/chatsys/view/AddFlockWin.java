package cn.chatsys.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.chatsys.bean.Flock;

import cn.chatsys.dao.FlockDao;

import cn.chatsys.dao.impl.FlockDaoImpl;



public class AddFlockWin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7659681364568562888L;
	private JPanel contentPane;
	private JTextField textGRoupName;
	
	private Flock flock;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AddFlockWin(final int uid) {
		setVisible(true);
		
		setBounds(100, 600, 260,100);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 
		
		textGRoupName = new JTextField();
		textGRoupName.setBounds(14, 5, 150, 30);
		contentPane.add(textGRoupName);
		textGRoupName.setColumns(10);
		
		JButton btnAddGroup = new JButton("添加");
		btnAddGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flock = new Flock();
				
				FlockDao flockDao = new FlockDaoImpl();
				
				String s = textGRoupName.getText();
				
				boolean isFlag=flockDao.doFlock(uid, s);
				
										
				if(isFlag) {
					JOptionPane.showMessageDialog(null, "添加成功", "提示",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnAddGroup.setBounds(164, 5, 60, 30);
		contentPane.add(btnAddGroup);
		
		
	}
	
}

