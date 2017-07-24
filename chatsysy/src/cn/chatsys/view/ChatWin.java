package cn.chatsys.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import cn.chatsys.bean.User;
import cn.chatsys.bean.UserInfo;
import cn.chatsys.dao.UserDao;
import cn.chatsys.dao.UserInfoDao;
import cn.chatsys.dao.impl.UserDaoImpl;
import cn.chatsys.dao.impl.UserInfoDaoImpl;
import cn.chatsys.util.net.Chat;

/**
 * 
 * @author Pro.Du
 *
 */
public class ChatWin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane rollpane;
	
	private UserInfoDao userinfodao;
	
	// 聊天对象
	private Chat chat;
	
	// 是否终止聊天
	private boolean endChat = false;
	
	// 聊天消息发送状态
	private boolean hasSend = false;

	public boolean isHasSend() {
		return hasSend;
	}
	public void setHasSend(boolean hasSend) {
		this.hasSend = hasSend;
	}

	public JPanel getContentPane() {
		return contentPane;
	}
	/**
	 * Create the frame.
	 * @param uid 
	 */
	public ChatWin(int fid, int uid) {
		UserDao ud = new UserDaoImpl();
		userinfodao = new UserInfoDaoImpl();
		UserInfo a = new UserInfo();
		a = userinfodao.findUserInfoByUid(fid);
		
		User friend = new User();	// 好友对象
		friend=ud.findUserById(fid);
		
		User user = new User();	// 用户对象
		user = ud.findUserById(uid);

		/**
		 * pro.du
		 * 创建聊天
		 */
		this.chat = new Chat(friend, user, this);
		// 聊天, 开启聊天线程
		chat.goChat();
		
		
		
		UserInfo useri = new UserInfo();
		UserInfoDao uind= new UserInfoDaoImpl();
		useri=uind.findUserInfoByUid(fid);
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
				ChatWin.this.hasSend = true;
			}
		});
		btnSend.setBounds(317, 514, 113, 27);
		contentPane.add(btnSend);
		
		JButton btnClose = new JButton("关闭");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ChatWin.this.endChat = true;
				ChatWin.this.dispose();
				//这里写整个窗口的关闭
			}
		});
		// 窗口关闭
		addWindowListener(new WindowAdapter() {  
			public void windowClosing(WindowEvent e) {  
				super.windowClosing(e);  
				ChatWin.this.endChat = true;
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
		// 发送区域	
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(14, 328, 416, 173);
		contentPane.add(editorPane);
		//显示区域：添加滚动容器rollpane
		JTextArea textArea = new JTextArea();
		textArea.setBounds(14, 52, 416, 263);
		textArea.setEditable(false);
		rollpane=new JScrollPane(textArea);
		rollpane.setBounds(14, 13, 406, 253);
		contentPane.add(rollpane);
		
		JLabel lblNewLabel_1 = new JLabel("昵称："+friend.getLoginName());
		lblNewLabel_1.setBounds(444, 64, 269, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("年龄："+a.getAge());
		lblNewLabel_2.setBounds(444, 117, 269, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("性别："+a.getSex());
		lblNewLabel_3.setBounds(444, 177, 269, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("生日："+a.getBirthday());
		lblNewLabel_4.setBounds(444, 232, 269, 32);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("地址："+a.getAddress());
		lblNewLabel_5.setBounds(444, 286, 269, 32);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("星座："+a.getStar());
		lblNewLabel_6.setBounds(444, 343, 269, 26);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("邮编："+a.getEmail());
		lblNewLabel_7.setBounds(444, 401, 269, 32);
		contentPane.add(lblNewLabel_7);
	}
	public boolean isEndChat() {
		return endChat;
	}
	public void setEndChat(boolean endChat) {
		this.endChat = endChat;
	}
}

