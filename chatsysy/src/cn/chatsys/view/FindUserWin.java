package cn.chatsys.view;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.chatsys.bean.UserInfo;
import cn.chatsys.dao.UserInfoDao;
import cn.chatsys.dao.impl.UserInfoDaoImpl;

public class FindUserWin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public FindUserWin(int uid,final int fid) {
		UserInfo userinfo = new UserInfo();
		UserInfoDao uind = new UserInfoDaoImpl();
		userinfo=uind.findUserInfoByUid(fid);
		
		this.setVisible(true);
		setBounds(100, 100, 400, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JLabel lblHead = new JLabel("头像设置：");
		//lblHead.setBounds(173, 29, 75, 33);
		//contentPane.add(lblHead);
		
		JLabel lblInfo = new JLabel("基本信息：");
		lblInfo.setForeground(Color.BLACK);
		lblInfo.setBounds(14, 29, 83, 33);
		contentPane.add(lblInfo);
		
		JButton btnHead = new JButton();
		btnHead.setIcon(new ImageIcon(userinfo.getAvatarpath()));
		btnHead.setBounds(255, 13, 48, 48);
		contentPane.add(btnHead);
		
		JLabel labelLogin = new JLabel("昵称："+userinfo.getNickname());
		labelLogin.setBounds(14, 93, 166, 33);
		contentPane.add(labelLogin);
		
		JLabel lblAge = new JLabel("年龄："+userinfo.getAge());
		lblAge.setBounds(14, 139, 166, 41);
		contentPane.add(lblAge);
		
		JLabel lblSex = new JLabel("性别："+userinfo.getSex());
		lblSex.setBounds(14, 195, 166, 33);
		contentPane.add(lblSex);
		
		JLabel lblDate = new JLabel("生日："+userinfo.getBirthday());
		lblDate.setBounds(14, 256, 166, 33);
		contentPane.add(lblDate);
		
		JLabel lblAddress = new JLabel("地址："+userinfo.getAddress());
		lblAddress.setBounds(14, 312, 154, 40);
		contentPane.add(lblAddress);
		
		JLabel lblStar = new JLabel("星座："+userinfo.getStar());
		lblStar.setBounds(14, 365, 166, 33);
		contentPane.add(lblStar);
		
		JButton btnNewButton = new JButton("加为好友");
		btnNewButton.setBounds(234, 365, 134, 33);
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		contentPane.add(btnNewButton);
	}
}

