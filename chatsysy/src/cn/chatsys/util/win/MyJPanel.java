package cn.chatsys.util.win;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import cn.chatsys.bean.UserInfo;
import cn.chatsys.dao.UserInfoDao;
import cn.chatsys.dao.impl.UserInfoDaoImpl;
import cn.chatsys.view.List;

public class MyJPanel extends JPanel {

	private final int FINAL_UID;
	private final List FINAL_LIST;

	public MyJPanel(int uid, List list){
		this.FINAL_UID = uid;
		this.FINAL_LIST = list;
	}
	
	// 重画
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("重画----------------");
		UserInfo userinfo = new UserInfo();
		UserInfoDao userinfodao = new UserInfoDaoImpl();
		userinfo=userinfodao.findUserInfoByUid(FINAL_UID);
		Component[] components = FINAL_LIST.getContentPane().getComponents();
		for(Component c : components)
		{
			if(c instanceof JButton)
			{
				System.out.println(userinfo.getAvatarpath());
				((JButton) c).setIcon(new ImageIcon(userinfo.getAvatarpath()));
				FINAL_LIST.setVisible(true);
			}
		}
	}
}
