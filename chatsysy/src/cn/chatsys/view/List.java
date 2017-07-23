package cn.chatsys.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import cn.chatsys.bean.UserInfo;
import cn.chatsys.dao.GroupDao;
import cn.chatsys.dao.GroupMemDao;
import cn.chatsys.dao.UserDao;
import cn.chatsys.dao.UserInfoDao;
import cn.chatsys.dao.impl.GroupDaoImpl;
import cn.chatsys.dao.impl.GroupMemDaoImpl;
import cn.chatsys.dao.impl.UserDaoImpl;
import cn.chatsys.dao.impl.UserInfoDaoImpl;


public class List extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTree flockList;
	
	/**
	 * pro.du
	 * 常量
	 * @param uid
	 */
	private int FINAL_UID;
	private List FINAL_LIST;

	public JPanel getMyContentPane() {
		return contentPane;
	}

	public void setMyContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public List(final int uid) {
		FINAL_UID = uid;
		FINAL_LIST = this;
		final UserDao userdao = new UserDaoImpl();
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
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton headButton = new JButton("");                                         //头像按钮
		headButton.setIcon(new ImageIcon(userinfo.getAvatarpath()));
		headButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new UserInfoWin(uid, List.this);
			}
		});
		headButton.setBounds(14, 13, 48, 48);
		contentPane.add(headButton);
		
		
		
		JLabel nameLable = new JLabel(userinfo.getNickname());
		nameLable.setBounds(76, 13, 152, 37);
		contentPane.add(nameLable);
		
		flockList = new JTree();
		flockList.setBounds(14, 313, 214, 227);
		contentPane.add(flockList);
		int groupnum=groupdao.findGroupByUid(uid).size();
		
		
		//创建节点
		DefaultMutableTreeNode node1=new DefaultMutableTreeNode("好友列表");

		//创建对象接受节点
		JTree friendList = new JTree(node1);
		//设置大小
		friendList.setBounds(14, 100, 214, 200);
		//布局接收树对象
		contentPane.add(friendList);
		//JTree jtree=new JTree(node3);
		for(int i=1;i<=groupnum;i++)
		{
			DefaultMutableTreeNode group = new DefaultMutableTreeNode(groupdao.findGroupByUid(uid).get(i-1).getGroupname());
			node1.add(group);
			int gid = groupdao.findGroupByUid(uid).get(i-1).getId();
			int gnum=groupmemdao.findAllGroupMemByGid(gid).size();
			//List<DefaultMutableTreeNode> groupmem=new ArrayList<DefaultMutableTreeNode>();
			if(gnum>0)
			{
				for(int j=1;j<=gnum;j++)
				{
					
					final DefaultMutableTreeNode groupmem = new DefaultMutableTreeNode(groupmemdao.findAllGroupMemByGid(gid).get(j-1).getLoginName());
					group.add(groupmem);
				}
			}
		}
		friendList.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				//TreePath path = flockList.getPathForLocation(b, a);
				TreeNode node=(TreeNode)e.getPath().getLastPathComponent();
				//System.out.println(e.getPath().getPathCount());
				if(node.isLeaf() && e.getPath().getPathCount()>2)
				{
					int fid=userdao.findUserbyLoginName(node.toString()).getId();
					new ChatWin(fid);
				}
			}
		});
		JScrollPane scrollPane = new JScrollPane(friendList);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(14, 100, 214, 200);
		contentPane.add(scrollPane);
		
		
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		UserInfo userinfo = new UserInfo();
		UserInfoDao userinfodao = new UserInfoDaoImpl();
		userinfo=userinfodao.findUserInfoByUid(FINAL_UID);
		Component[] components = FINAL_LIST.getMyContentPane().getComponents();
		for(Component c : components)
		{
			if(c instanceof JButton)
			{
				((JButton) c).setIcon(new ImageIcon(userinfo.getAvatarpath()));
			}
		}
		
	}
	
}
