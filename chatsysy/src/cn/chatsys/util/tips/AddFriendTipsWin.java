package cn.chatsys.util.tips;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.chatsys.bean.UserInfo;
import cn.chatsys.dao.UserInfoDao;
import cn.chatsys.dao.impl.UserInfoDaoImpl;
import cn.chatsys.view.FindUserWin_2;

public class AddFriendTipsWin extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static JFrame frame = new JFrame("好友请求");
	
	private JButton yes;//确认按钮
	private JButton no;//拒绝按钮
	private JButton avatar;//头像按钮
	private JLabel name;//用户账号名
	private JTextField remark;
	
	private UserInfoDao userInfoDao;
	private UserInfo userInfo;
	
	public static void main(String[] args) {
		int uid = 1;
		int fid = 1;
		new AddFriendTipsWin(uid,fid);
	}
	
	public AddFriendTipsWin(final int uid,final int fid)
	{
		userInfo = new UserInfo();
		userInfoDao = new UserInfoDaoImpl();
		userInfo=userInfoDao.findUserInfoByUid(fid);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);//添加面板
		frame.setSize(260, 150);//窗口的大小
		frame.setLocation(1100, 550);//设置窗口左上角的坐标
		frame.setVisible(true);//参数为true时设置窗口可见
		frame.setResizable(false);//设置框架为不可调整大小
		
		avatar = new JButton();
		avatar.setIcon(new ImageIcon(userInfo.getAvatarpath()));
		avatar.setBounds(12, 12, 48, 48);
		
		yes = new JButton("同意");
		yes.setBounds(12, 92, 112, 24);
		
		no = new JButton("拒绝");
		no.setBounds(136, 92, 112, 24);
		
		name = new JLabel(userInfo.getNickname());
		name.setBounds(72, 12, 188, 24);
		
		remark = new JTextField();
		remark.setBounds(72, 48, 176, 24);
		
		panel.add(avatar);
		panel.add(yes);
		panel.add(no);
		panel.add(name);
		panel.add(remark);
		
		avatar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FindUserWin_2(uid,fid);
			
			}
		});
	}
}
