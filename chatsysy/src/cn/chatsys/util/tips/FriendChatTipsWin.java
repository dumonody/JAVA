package cn.chatsys.util.tips;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.chatsys.bean.UserInfo;
import cn.chatsys.dao.UserInfoDao;
import cn.chatsys.dao.impl.UserInfoDaoImpl;
import cn.chatsys.util.win.WindowUtil;
import cn.chatsys.view.ChatWin;
import cn.chatsys.view.FindUserWin_2;

public class FriendChatTipsWin extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static JFrame frame = new JFrame("消息提示");
	
	private JButton avatar;//头像按钮
	private JButton yes;
	private JLabel name;//用户账号名
	private JTextArea hisChat;//好友发送的消息
	private JScrollPane rollpane;
	
	private UserInfoDao userInfoDao;
	private UserInfo userInfo;
	
	public static void main(String[] args) {
		int uid = 1;
		int fid = 1;
		new FriendChatTipsWin(uid,fid, null);
	}
	
	public FriendChatTipsWin(final int uid,final int fid, final NewChatRequestMgr newChatRequestMgr)
	{
		userInfo = new UserInfo();
		userInfoDao = new UserInfoDaoImpl();
		userInfo=userInfoDao.findUserInfoByUid(fid);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);//添加面板
		frame.setSize(260, 150);//窗口的大小
		frame.setLocation(100, 550);//设置窗口左上角的坐标
		frame.setVisible(true);//参数为true时设置窗口可见
		frame.setResizable(false);//设置框架为不可调整大小
		
		avatar = new JButton();
		avatar.setIcon(new ImageIcon(userInfo.getAvatarpath()));
		avatar.setBounds(12, 12, 48, 48);
		
		yes = new JButton("查看消息");
		yes.setBounds(12, 90, 236, 24);
		
		name = new JLabel(userInfo.getNickname());
		name.setBounds(12, 60, 48, 24);
		
		hisChat = new JTextArea();
		hisChat.setText("");
		hisChat.setLineWrap(true);
		hisChat.setEditable(false);
		hisChat.setBounds(72, 12, 176, 72);
		rollpane = new JScrollPane(hisChat);
		rollpane.setBounds(72, 12, 176, 72);
		
		
		
		panel.add(avatar);
		panel.add(yes);
		panel.add(name);
		panel.add(rollpane);
		frame.setVisible(true);//组件加载完才能设置窗体可见，不然组件无法显示（加载错误）。
		frame.repaint();//解决组件显示异常（非加载错误）。
		
		
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WindowUtil.setTextArea(new ChatWin(fid, uid), FriendChatTipsWin.this.hisChat.getText());
				// 更新新消息提示窗口管理类中的集合
				newChatRequestMgr.getChatObjectSet().remove(fid);
				newChatRequestMgr.getFriendChatWinMap().remove(fid);
				System.out.println("已经运行额");
				frame.dispose();
			}
		});

		
	}

	public JTextArea getHisChat() {
		return hisChat;
	}

	public void setHisChat(JTextArea hisChat) {
		this.hisChat = hisChat;
	}
}
