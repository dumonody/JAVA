package cn.chatsys.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;

import cn.chatsys.bean.UserInfo;
import cn.chatsys.dao.GroupDao;
import cn.chatsys.dao.GroupMemDao;
import cn.chatsys.dao.UserInfoDao;
import cn.chatsys.dao.impl.GroupDaoImpl;
import cn.chatsys.dao.impl.GroupMemDaoImpl;
import cn.chatsys.dao.impl.UserInfoDaoImpl;

public class List extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTree friendList;
	private JTree flockList;

	public List(int uid) {
		UserInfo userinfo = new UserInfo();
		UserInfoDao userinfodao = new UserInfoDaoImpl();
		GroupDao groupdao = new GroupDaoImpl();
		GroupMemDao groupmemdao = new GroupMemDaoImpl();
		userinfo=userinfodao.findUserInfoByUid(uid);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton headButton = new JButton("");                                         //头像按钮
		headButton.setIcon(new ImageIcon(userinfo.getAvatarpath()));
		headButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		headButton.setBounds(14, 13, 48, 48);
		contentPane.add(headButton);
		
		
		
		JLabel nameLable = new JLabel(userinfo.getNickname());
		nameLable.setBounds(76, 13, 152, 37);
		contentPane.add(nameLable);
		
		flockList = new JTree();
		flockList.setName("好友列表");
		flockList.setToolTipText("好友列表");
		flockList.setBounds(14, 313, 214, 227);
		contentPane.add(flockList);
		int groupnum=groupdao.findGroupByUid(uid).size();
		
		
		//创建节点
		DefaultMutableTreeNode node1=new DefaultMutableTreeNode("好友列表");
		//DefaultMutableTreeNode node2=new DefaultMutableTreeNode("朋友");
		//DefaultMutableTreeNode node3=new DefaultMutableTreeNode("好友列表");
		//DefaultMutableTreeNode node4=new DefaultMutableTreeNode("好友");
		//DefaultMutableTreeNode node5=new DefaultMutableTreeNode("同学");
		//DefaultMutableTreeNode node6=new DefaultMutableTreeNode("亲戚");
		//将节点添加至根节点node3
		//node1.add(node2);
		//创建对象接受节点
		for(int i=1;i<=groupnum;i++)
		{
			DefaultMutableTreeNode group = new DefaultMutableTreeNode(groupdao.findGroupByUid(uid).get(i-1).getGroupname());
			node1.add(group);
			int gid = groupdao.findGroupByUid(uid).get(i-1).getId();
			int gnum=groupmemdao.findAllGroupMemByGid(gid).size();
			if(gnum>0)
			{
				for(int j=1;j<=gnum;j++)
				{
					DefaultMutableTreeNode groupmem = new DefaultMutableTreeNode(groupmemdao.findAllGroupMemByGid(gid).get(j-1).getLoginName());
					group.add(groupmem);
				}
			}
		}
		JTree friendList = new JTree(node1);
		//设置大小
		friendList.setBounds(14, 100, 214, 200);
		//布局接收树对象
		contentPane.add(friendList);
		//JTree jtree=new JTree(node3);
		
	}
}
