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
import cn.chatsys.dao.GroupDao;
import cn.chatsys.dao.GroupMemDao;
import cn.chatsys.dao.UserDao;
import cn.chatsys.dao.impl.FriendListDaoImpl;
import cn.chatsys.dao.impl.GroupDaoImpl;
import cn.chatsys.dao.impl.GroupMemDaoImpl;
import cn.chatsys.dao.impl.UserDaoImpl;

public class DeleteFriendWin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7659681364568562888L;
	private JPanel contentPane;
	private JTextField textFriendLoginName;
	private JButton lblFriendLoginName;
	private JButton btnAddFriend;
	private FriendListDao friendListDao;
	private GroupMemDao groupMemDao;
	private GroupDao groupDao;
	
	//private UserDao userDao;
	private User user;
	private UserInfo userInfo;
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public DeleteFriendWin(final int uid) {
		final int uidflag =  uid;
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 600, 260,100);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		 
		
		textFriendLoginName = new JTextField();
		textFriendLoginName.setBounds(14, 5, 150, 30);
		contentPane.add(textFriendLoginName);
		textFriendLoginName.setColumns(10);
		
		JButton btnSearch = new JButton("删除");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = new User();
				userInfo = new UserInfo();
				groupDao = new GroupDaoImpl();
				groupMemDao = new GroupMemDaoImpl();
				UserDao userDao = new UserDaoImpl();
				friendListDao = new FriendListDaoImpl();
				String s = textFriendLoginName.getText();
				if(s==null)
				{
					JOptionPane.showMessageDialog(null, "不能为空", "提示",JOptionPane.ERROR_MESSAGE);
				}
				else if(userDao.findUserbyLoginName(s)==null)
				{	
					JOptionPane.showMessageDialog(null, "未找到该用户", "提示",JOptionPane.ERROR_MESSAGE);
				}	
				else if(friendListDao.findFriendByUidAndFid(userDao.findUserbyLoginName(s).getId(), uid)==null)
				{
					JOptionPane.showMessageDialog(null, "该用户不是你的好友", "提示",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					boolean a=friendListDao.delFriendListById(uid, userDao.findUserbyLoginName(s).getId());
					System.out.println(a);
					boolean b=friendListDao.delFriendListById(userDao.findUserbyLoginName(s).getId(), uid);
					System.out.println(b);
					//查找用户的所有分组
					System.out.println(groupDao.findGroupByUid(uid));
					for(int i = 0 ;i<groupDao.findGroupByUid(uid).size();i++)
					{	
						//查找用户分组内的所有成员
						for(int j = 0 ;j<groupMemDao.findAllGroupMemByGid(groupDao.findGroupByUid(uid).get(i).getId()).size();i++)
						
							{
								//获得当前成员的groupmem的uid
								int gmuid=groupMemDao.findAllGroupMemListByGid(groupDao.findGroupByUid(uid).get(i).getId()).get(j).getUser().getId();
								//如果gmuid=fid,则删除
								if(gmuid==userDao.findUserbyLoginName(s).getId())
								{
									boolean flag=groupMemDao.delGroupMem(groupDao.findGroupByUid(uid).get(i).getId(), gmuid);
									System.out.println(flag);
									break;
								}
							}
						
					}
					//集成上面方法
					deluser(userDao.findUserbyLoginName(s).getId(),uid);
				}
				
			}
		});
		btnSearch.setBounds(164, 5, 60, 30);
		contentPane.add(btnSearch);
		
		
	}
	
	public boolean deluser(int uid,int fid)
	{
		boolean isFlag = false;
		//查找用户的所有分组
		for(int i = 0 ;i<groupDao.findGroupByUid(uid).size();i++)
		{	
			//查找用户分组内的所有成员
			System.out.println(groupDao.findGroupByUid(uid).size());
			if(groupDao.findGroupByUid(uid).size()>0)
			{
				for(int j = 0 ;j<groupMemDao.findAllGroupMemByGid(groupDao.findGroupByUid(uid).get(i).getId()).size();j++)
			
					{
						//获得当前成员的groupmem的uid
						int gmuid=groupMemDao.findAllGroupMemListByGid(groupDao.findGroupByUid(uid).get(i).getId()).get(j).getUser().getId();
						//如果gmuid=fid,则删除
						if(gmuid==fid)
						{
							isFlag=groupMemDao.delGroupMem(groupDao.findGroupByUid(uid).get(i).getId(), gmuid);
							System.out.println("集成"+isFlag);
							break;
						}
					}
			}
		}
		return isFlag;
	}

	protected void AddFriendWin(int uidflag) {
		// TODO Auto-generated method stub
		
	}
}
