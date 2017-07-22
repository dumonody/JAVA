package cn.chatsys.view;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.chatsys.bean.UserInfo;
import cn.chatsys.dao.UserInfoDao;
import cn.chatsys.dao.impl.UserInfoDaoImpl;

public class UserInfoWin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public UserInfoWin(final int uid) {
		UserInfo uinfo = new UserInfo();
		UserInfoDao uind = new UserInfoDaoImpl();
		uinfo=uind.findUserInfoByUid(uid);
		
		this.setVisible(true);

		setBounds(100, 100, 554, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHead = new JLabel("头像设置：");
		lblHead.setBounds(240, 29, 75, 33);
		contentPane.add(lblHead);
		
		JLabel lblInfo = new JLabel("基本信息：");
		lblInfo.setForeground(Color.BLACK);
		lblInfo.setBounds(14, 29, 83, 33);
		contentPane.add(lblInfo);
		
		JButton btnHead = new JButton();
		btnHead.setIcon(new ImageIcon(uinfo.getAvatarpath()));
		btnHead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnHead.setBounds(360, 13,48, 48);
		contentPane.add(btnHead);
		
		JLabel labelLogin = new JLabel("昵称："+uinfo.getId());
		labelLogin.setBounds(14, 111, 166, 33);
		contentPane.add(labelLogin);
		
		JLabel lblAge = new JLabel("年龄："+uinfo.getAge());
		lblAge.setBounds(14, 207, 166, 41);
		contentPane.add(lblAge);
		
		JLabel lblSex = new JLabel("性别："+uinfo.getSex());
		lblSex.setBounds(14, 293, 166, 33);
		contentPane.add(lblSex);
		
		JLabel lblDate = new JLabel("生日："+uinfo.getBirthday());
		lblDate.setBounds(14, 384, 166, 33);
		contentPane.add(lblDate);
		
		JLabel lblAddress = new JLabel("地址："+uinfo.getAddress());
		lblAddress.setBounds(14, 463, 154, 40);
		contentPane.add(lblAddress);
		
		JLabel lblStar = new JLabel("星座："+uinfo.getStar());
		lblStar.setBounds(14, 558, 166, 33);
		contentPane.add(lblStar);
		
		JButton btnEditor = new JButton("编辑资料");
		btnEditor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditor.setForeground(Color.BLUE);
		btnEditor.setBounds(409, 636, 113, 27);
		contentPane.add(btnEditor);
		
		JLabel lblEmail = new JLabel("邮编："+uinfo.getEmail());
		lblEmail.setBounds(262, 467, 233, 33);
		contentPane.add(lblEmail);
	}
}
