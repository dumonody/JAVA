package cn.chatsys.view;

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

public class HeadPictureWin extends JFrame {

	
	private static final long serialVersionUID = 7767135252604785539L;
	private JPanel contentPane;
	private UserInfo userinfo;
	private UserInfoDao uind;

	public HeadPictureWin(final int uid, final List list) {
		userinfo = new UserInfo();
		uind = new UserInfoDaoImpl();
		userinfo=uind.findUserInfoByUid(uid);

		setVisible(true);
		setBounds(100, 100, 528, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 7; j++)
			{
				final int ii = i;
				final int jj = j;
				JButton tmpBt = new JButton("");
				tmpBt.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						userinfo.setAvatarpath("avatar/" + (ii*7+jj) + ".png");
						uind.updateUserInfo(userinfo);
						HeadPictureWin.this.dispose();
						new UserInfoWin(uid, list);
					}
				});
				tmpBt.setIcon(new ImageIcon("avatar/" + (ii*7+jj) + ".png"));
				tmpBt.setBounds(49 + 62*jj, 56 + 61*ii, 48, 48);
				contentPane.add(tmpBt);
			}
		}
		
	}

}
