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

import cn.chatsys.bean.Group;


import cn.chatsys.dao.GroupDao;

import cn.chatsys.dao.impl.GroupDaoImpl;


public class DelGroupWin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7659681364568562888L;
	private JPanel contentPane;
	private JTextField textGRoupName;
	
	private Group group;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public DelGroupWin(final int uid) {
		setVisible(true);
		
		setBounds(100, 200, 260,100);
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
				group = new Group();
				
				GroupDao groupDao = new GroupDaoImpl();
				
				String s = textGRoupName.getText();
				if(groupDao.findGroupByGroupName(s)==null)
				{
					JOptionPane.showMessageDialog(null, "未找到该好友", "提示",JOptionPane.ERROR_MESSAGE);
				}
				Group g=groupDao.findGroupByGroupName(s);
				boolean isFlag=groupDao.delGroup(g.getId());
				
										
				if(isFlag) {
					JOptionPane.showMessageDialog(null, "删除成功", "提示",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnAddGroup.setBounds(164, 5, 60, 30);
		contentPane.add(btnAddGroup);
		
		
	}
	
}


