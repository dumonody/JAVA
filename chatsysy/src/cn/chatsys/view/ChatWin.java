package cn.chatsys.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import cn.chatsys.bean.LoginInfo;
import cn.chatsys.bean.User;
import cn.chatsys.bean.UserInfo;
import cn.chatsys.dao.LoginInfoDao;
import cn.chatsys.dao.UserDao;
import cn.chatsys.dao.UserInfoDao;
import cn.chatsys.dao.impl.LoginInfoDaoImpl;
import cn.chatsys.dao.impl.UserDaoImpl;
import cn.chatsys.dao.impl.UserInfoDaoImpl;
import cn.chatsys.util.net.Chat;


public class ChatWin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// 添加一个聊天实例：
	private Chat chat;


	
	public JPanel getContentPane() {
		return contentPane;
	}
	/**
	 * Create the frame.
	 */
	public ChatWin(int fid) {
		User friend = new User();
		UserInfo useri = new UserInfo();
		UserInfoDao uind= new UserInfoDaoImpl();
		UserDao ud = new UserDaoImpl();
		
		
		useri=uind.findUserInfoByUid(fid);
		friend=ud.findUserById(fid);
		setTitle("与"+friend.getLoginName()+"交谈中...");
		setVisible(true);
		setBounds(300, 100, 745, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("要不这里换成几个按钮");
		lblNewLabel.setBounds(14, 289, 254, 26);
		contentPane.add(lblNewLabel);
		
		JButton btnSend = new JButton("发送");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//这里写发送信息所实现的东西
				
				//发送完消息后销毁textMySend里面的东西
				
				//功能我不怎么会，晚上写
				
			}
		});
		btnSend.setBounds(317, 514, 113, 27);
		contentPane.add(btnSend);
		
		JButton btnClose = new JButton("关闭");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ChatWin.this.dispose();
				//这里写整个窗口的关闭
			}
		});
		btnClose.setBounds(190, 514, 113, 27);
		contentPane.add(btnClose);
		
		JLabel lblFriendLook = new JLabel("好友信息");//也可以写成loginName+"的形象";
		//lblFriendLook.setIcon("这个也是放图片地址的");
		lblFriendLook.setBounds(444, 13, 143, 23);
		contentPane.add(lblFriendLook);
		
		JButton btnHistory = new JButton("历史记录");
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//这里放新建的窗口，显示历史记录
			}
		});
		btnHistory.setBounds(298, 289, 132, 27);
		contentPane.add(btnHistory);
		
		JEditorPane editorPane = new JEditorPane();
/**
 * pro.du
 * 添加测试内容
 */
editorPane.setText("呵呵呵呵呵呵呵呵呵呵呵");
		editorPane.setBounds(14, 328, 416, 173);
		contentPane.add(editorPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(14, 13, 416, 263);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("昵称：");
		lblNewLabel_1.setBounds(444, 64, 269, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("年龄：");
		lblNewLabel_2.setBounds(444, 117, 269, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("性别：");
		lblNewLabel_3.setBounds(444, 177, 269, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("生日：");
		lblNewLabel_4.setBounds(444, 232, 269, 32);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("地址：");
		lblNewLabel_5.setBounds(444, 286, 269, 32);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("星座：");
		lblNewLabel_6.setBounds(444, 343, 269, 26);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("邮编：");
		lblNewLabel_7.setBounds(444, 401, 269, 32);
		contentPane.add(lblNewLabel_7);
		
		
		/**
		 * pro.du
		 * 创建聊天
		 */
		LoginInfoDao lid = new LoginInfoDaoImpl();
		LoginInfo mf = lid.findLoginInfoByUid(fid);
		chat = new Chat(mf, this);
		
	}
}

