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

import cn.chatsys.bean.User;
import cn.chatsys.bean.UserInfo;
import cn.chatsys.dao.FriendListDao;
import cn.chatsys.dao.UserDao;
import cn.chatsys.dao.UserInfoDao;
import cn.chatsys.dao.impl.UserDaoImpl;
import cn.chatsys.dao.impl.UserInfoDaoImpl;

public class AddFriendWin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7659681364568562888L;
	private JPanel contentPane;
	private JTextField textFriendLoginName;
	private JButton lblFriendLoginName;
	private JButton btnAddFriend;
	
	
	private FriendListDao friendListDao;
	//private UserDao userDao;
	private User user;
	private UserInfo userInfo;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AddFriendWin(final int uid) {
		final int uidflag =  uid;
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1100, 600, 260,100);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		final String[] names = { "账号", "昵称", "年龄", "性别" };
		 
		
		textFriendLoginName = new JTextField();
		textFriendLoginName.setBounds(14, 5, 150, 30);
		contentPane.add(textFriendLoginName);
		textFriendLoginName.setColumns(10);
		
		JButton btnSearch = new JButton("搜索");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = new User();
				userInfo = new UserInfo();
				UserDao userDao = new UserDaoImpl();
				UserInfoDao userInfoDao = new UserInfoDaoImpl();
				String s = textFriendLoginName.getText();
				if(userDao.findUserbyLoginName(s)!=null)
				{
					//AddFriendWin.this.dispose();
					user=userDao.findUserbyLoginName(s);
					new FindUserWin(uid,user.getId());
					//userInfo = userInfoDao.findUserInfoByUid(user.getId());
					//Object[][] tableuserInfo ={ {"账号",user.getLoginName(),"昵称",userInfo.getNickname()}};
					//JTable table = new JTable(tableuserInfo,names);
					//lblFriendLoginName = new JButton(user.getLoginName());
					//lblFriendLoginName.setName(user.getLoginName());
					//lblFriendLoginName.setBounds(14, 69*i, 308, 32);
					//contentPane.add(lblFriendLoginName);
		
					//btnAddFriend = new JButton("添加");
					//btnAddFriend.setBounds(336, 68, 113, 32);
					//contentPane.add(btnAddFriend);
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "未查到此人", "提示",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnSearch.setBounds(164, 5, 60, 30);
		contentPane.add(btnSearch);
		
		
	}

	protected void AddFriendWin(int uidflag) {
		// TODO Auto-generated method stub
		
	}
}
