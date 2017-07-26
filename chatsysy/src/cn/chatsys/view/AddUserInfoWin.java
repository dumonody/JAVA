package cn.chatsys.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mkk.swing.JCalendarChooser;

import cn.chatsys.bean.UserInfo;
import cn.chatsys.dao.UserInfoDao;
import cn.chatsys.dao.impl.UserInfoDaoImpl;

public class AddUserInfoWin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1425528227851799218L;
	private JPanel contentPane;
	private JTextField textNicknameEdit;
	private JTextField textAgeEdit;
	private JTextField textBirthEdit;
	private JTextField textAddressEdit;
	private JTextField textStarEdit;
	private JTextField textEmailEdit;
	private JCalendarChooser timechoice;
	private ButtonGroup bg;



	

	/**
	 * Create the frame.
	 */
	public AddUserInfoWin(final int uid) {
		
		final UserInfoDao userinfodao = new UserInfoDaoImpl();
		final UserInfo userinfo = userinfodao.findUserInfoByUid(uid);
		
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEdit = new JLabel("注册信息：");
		lblEdit.setBounds(14, 13, 97, 40);
		contentPane.add(lblEdit);
		
		JLabel lblLoginEdit = new JLabel("昵称：");
		lblLoginEdit.setBounds(14, 89, 72, 32);
		contentPane.add(lblLoginEdit);
		
		JLabel lblAgeEdit = new JLabel("年龄：");
		lblAgeEdit.setBounds(14, 159, 72, 18);
		contentPane.add(lblAgeEdit);
		
		JLabel lblSexEdit = new JLabel("性别：");
		lblSexEdit.setBounds(14, 228, 72, 18);
		contentPane.add(lblSexEdit);
		
		JLabel lblBirthEdit = new JLabel("生日：");
		lblBirthEdit.setBounds(14, 293, 72, 18);
		contentPane.add(lblBirthEdit);
		
		JLabel lblAddressEdit = new JLabel("地址：");
		lblAddressEdit.setBounds(14, 342, 72, 18);
		contentPane.add(lblAddressEdit);
		
		JLabel lblStarEdit = new JLabel("星座：");
		lblStarEdit.setBounds(14, 387, 72, 18);
		contentPane.add(lblStarEdit);
		
		JLabel lblEmailEdit = new JLabel("电子邮件：");
		lblEmailEdit.setBounds(14, 429, 72, 30);
		contentPane.add(lblEmailEdit);
		
		textNicknameEdit = new JTextField();
		textNicknameEdit.setBounds(117, 89, 148, 32);
		contentPane.add(textNicknameEdit);
		textNicknameEdit.setColumns(10);
		
		textAgeEdit = new JTextField();
		textAgeEdit.setBounds(117, 148, 148, 32);
		contentPane.add(textAgeEdit);
		textAgeEdit.setColumns(10);
		
		textBirthEdit = new JTextField();
		textBirthEdit.setBounds(117, 290, 148, 32);
		contentPane.add(textBirthEdit);
		textBirthEdit.setColumns(10);
		
		JButton btnBirthDay = new JButton("选择");
		btnBirthDay.setBounds(265, 290, 64, 32);
		contentPane.add(btnBirthDay);
		btnBirthDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timechoice = new JCalendarChooser(null);
				Calendar cl = timechoice.showCalendarDialog();
				userinfo.setBirthday(cl.getTime());
				
				userinfodao.updateUserInfo(userinfo);
				textBirthEdit.setText(userinfodao.findUserInfoByUid(uid).getBirthday().toString());
			}
		});
		
		textAddressEdit = new JTextField();
		textAddressEdit.setBounds(117, 335, 295, 32);
		contentPane.add(textAddressEdit);
		textAddressEdit.setColumns(10);
		
		textStarEdit = new JTextField();
		textStarEdit.setBounds(117, 380, 148, 32);
		contentPane.add(textStarEdit);
		textStarEdit.setColumns(10);
		
		textEmailEdit = new JTextField();
		textEmailEdit.setBounds(117, 428, 148, 32);
		contentPane.add(textEmailEdit);
		textEmailEdit.setColumns(10);
		
		JButton btnSave = new JButton("添加信息");
		btnSave.setBounds(343, 444, 113, 27);
		contentPane.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = textAgeEdit.getText();
			
				userinfo.setNickname(textNicknameEdit.getText());
				userinfo.setAddress(textAddressEdit.getText());
				userinfo.setStar(textStarEdit.getText());
				userinfo.setEmail(textEmailEdit.getText());
				
				if(!s.equals(" "))
				{
					int i = Integer.parseInt(s);
					userinfo.setAge(i);
				}
				
				userinfodao.updateUserInfo(userinfo);
				AddUserInfoWin.this.dispose();
				LoginWin.frame.setVisible(true);
			}
		});
		
		JRadioButton rdbtnBoy = new JRadioButton("男",true);
		rdbtnBoy.setBounds(117, 224, 137, 27);
		contentPane.add(rdbtnBoy);
		rdbtnBoy.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				userinfo.setSex("男");
				
			}
			
		});
		JRadioButton rdbtnGirl = new JRadioButton("女");
		rdbtnGirl.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				userinfo.setSex("女");
				
			}
			
		});
		rdbtnGirl.setBounds(272, 224, 157, 27);
		contentPane.add(rdbtnGirl);
		
		bg = new ButtonGroup();
		bg.add(rdbtnBoy);
		bg.add(rdbtnGirl);
		
	}

}
