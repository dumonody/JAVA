package cn.chatsys.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import cn.chatsys.bean.LoginInfo;
import cn.chatsys.bean.UserInfo;
import cn.chatsys.dao.FlockDao;
import cn.chatsys.dao.GroupDao;
import cn.chatsys.dao.GroupMemDao;
import cn.chatsys.dao.LoginInfoDao;
import cn.chatsys.dao.UserDao;
import cn.chatsys.dao.UserInfoDao;
import cn.chatsys.dao.impl.FlockDaoImpl;
import cn.chatsys.dao.impl.GroupDaoImpl;
import cn.chatsys.dao.impl.GroupMemDaoImpl;
import cn.chatsys.dao.impl.LoginInfoDaoImpl;
import cn.chatsys.dao.impl.UserDaoImpl;
import cn.chatsys.dao.impl.UserInfoDaoImpl;
import cn.chatsys.util.eventListener.GetAddFriendRequestListener;
import cn.chatsys.util.eventListener.GetNewChatRequestListener;
/**
 * 
 * @author LH
 *
 */
public class List extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5103931107052823761L;
	private JTree friendList;
	private JTree flockList;
	private JPanel jp1;// NORTH 使用FlowLayout布局 嵌套jp11 jp12
	private JPanel jp11;//GridLayout 1*1 放头像
	private JPanel jp12;//FlowLayout 2*1 昵称 签名
	private JPanel jp2;//CENTER  CardLayout 3层  好友 群 最近联系人
	private JPanel jp21;
	private JPanel jp22;
	private JPanel jp23;//好友 群 最近联系人 的面板
	private JPanel jp3;//添加好友
	private JPanel jp4;//添加群组
	
	private JLabel jl1;//标签1 
	//private JLabel jl2;//标签2
	//private JLabel jl3;//标签3
	//private JLabel jl4;
	
	private JButton jb1;//按钮1 存放头像
	private JButton jb2;//添加好友
	private JButton jb3;//添加群
	private JButton jb4;//新建群
	private JButton jb5;//删除好友 
	private JButton jb6;//创建分组
	private JButton jb7;//删除分组
	
	private JTextField sign;// 文本 签名
	private UserDao userdao;
	private UserInfo userinfo;
	private List FINAL_LIST;
	private int FINAL_UID;

	//0724_moy_update
	private LoginInfoDao loginInfoDao;
	private FlockDao flockdao;
	

	
	public JPanel getJp11() {
		return jp11;
	}

	public List(int uid){
		FINAL_UID = uid;
		FINAL_LIST = this;
		userdao = new UserDaoImpl();
		userinfo = new UserInfo();
		UserInfoDao userinfodao = new UserInfoDaoImpl();
		
		userinfo=userinfodao.findUserInfoByUid(uid);
		this.setTitle("星聊");// 设置窗口标题
        init(uid);// 窗体组件初始化
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLayout(null);// 设置布局方式 
        this.setBounds(1100, 100, 260, 600);//窗体位置
        Image image = new ImageIcon("e:/001.jpg").getImage();// 设置窗体的标题图标
        this.setIconImage(image);
        this.setResizable(true);// 窗体大小不能改变
        this.setVisible(true);// 窗体可见
        //this.setMaximumSize(new Dimension(400, 200));//设置最大值
        this.setMinimumSize(new Dimension(260, 400));//设置最小值
        
        this.addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowClosing(WindowEvent e) {
        		
        		LoginInfoDao lid = new LoginInfoDaoImpl();
        		LoginInfo li = lid.findLoginInfoByUid(FINAL_UID);
        		lid.updateLoginInfo(li.getAddress(), li.getIp(), li.getTime(), false, li.getUser().getId());
        		// 窗口关闭之前更新数据库
        		super.windowClosing(e);
        	}
		});
        
        
        // 给List添加一个好友新会话请求事件监测
        Thread gncrl = new Thread(new GetNewChatRequestListener(this.FINAL_UID));
        gncrl.start();
        // 设置成后台线程
        //gncrl.setDaemon(true);
        
        // 给List添加一个添加好友请求事件监测
        Thread gafrl = new Thread(new GetAddFriendRequestListener(this.FINAL_UID));
        gafrl.start();
        // 设置成后台线程
       // gncrl.setDaemon(true);
	}
	
	public void init(final int uid){
		GroupDao groupdao = new GroupDaoImpl();
		GroupMemDao groupmemdao = new GroupMemDaoImpl();
		Container con = this.getContentPane();//创建一个容器 
		con.setLayout(new BorderLayout());//容器布局
		/**
		 * 0或FlowLayout.lEFT ，控件左对齐
			1或FlowLayout.CENTER ，居中对齐			
			2或FlowLayout.RIGHT ，右对齐			
			3或FlowLayout.LEADING，控件与容器方向开始边对应			
			4或FlowLayout.TRAILING，控件与容器方向结束边对应			
			如果是0、1、2、3、4之外的整数，则为左对齐
		 */
		jp1 = new JPanel(new FlowLayout(3,4,4));//jp1使用FlowLayout布局(3,4,4)对齐方式 ，水平间隙，垂直间隙
		jp1.setPreferredSize(new Dimension(260, 80));
		jp2 = new JPanel(new CardLayout());//jp2使用CardLayout布局
		jp2.setPreferredSize(new Dimension(260, 380));
		
		
		jp11 = new JPanel(new GridLayout(1,1));
		jp11.setPreferredSize(new Dimension(48, 48));//设置头像的大小
		
		jp12 = new JPanel(new FlowLayout(3,4,5));
		jp12.setPreferredSize(new Dimension(160, 50));
		
		ImageIcon img = new ImageIcon(userinfo.getAvatarpath());//创建图片对象
		jb1 = new JButton();
		jb1.setIcon(img);//将图片添加进jl1
		jp11.add(jb1);//把jb1添加进jp11
		jb1.addActionListener(new ActionListener()//点击头像跳转至个人信息界面事件
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new UserInfoWin(userinfo.getUser().getId(), List.this);
			}
		});
		
		jl1 = new JLabel(userinfo.getNickname());//显示昵称
		jl1.setPreferredSize(new Dimension(80, 13));
		sign = new JTextField();
		sign.setPreferredSize(new Dimension(150, 20));
		jp12.add(jl1);
		jp12.add(sign);
		
		
		String name1 = " 好      友   ";
		String name2 = "    群        ";
		String name3 = " 最近联系人";
		jp21 = new JPanel(new BorderLayout());	  
		jp21.setBackground(Color.WHITE);
		jp22 = new JPanel(new BorderLayout());
		jp22.setBackground(Color.WHITE);
		jp23 = new JPanel(new FlowLayout(3));
		jp23.setBackground(Color.WHITE);
		
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP); 
		
		int groupnum=groupdao.findGroupByUid(uid).size();
		DefaultMutableTreeNode node1=new DefaultMutableTreeNode("我的好友");
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
					
					loginInfoDao = new LoginInfoDaoImpl();
					int fid = groupmemdao.findAllGroupMemByGid(gid).get(j-1).getId();
					boolean state = loginInfoDao.findLoginInfoByUid(fid).isState();
					final DefaultMutableTreeNode groupmem = new DefaultMutableTreeNode(groupmemdao.findAllGroupMemByGid(gid).get(j-1).getLoginName()+(state?"（在线）":"（离线）"));
					group.add(groupmem);
				}
			}
		}
		DefaultTreeModel jMode = new DefaultTreeModel(node1);
		friendList= new JTree(jMode);
		//jt1.setRootVisible(false);// 设置根节点为不可见；
		friendList.putClientProperty("JTree.lineStyle", "Horizontal");// 将树设为水平分隔风格
		friendList.setBounds(0, 0, 150, 20);
		friendList.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				//TreePath path = flockList.getPathForLocation(b, a);
				TreeNode node=(TreeNode)e.getPath().getLastPathComponent();
				//System.out.println(e.getPath().getPathCount());
				if(node.isLeaf() && e.getPath().getPathCount()>2)
				{
					int fid=userdao.findUserbyLoginName(node.toString().substring(0, node.toString().indexOf("（"))).getId();
					new ChatWin(fid, uid);
				}
			}
		});
		
		
		jp21.add(friendList);
		
		//改动的部分2
		
		//群树
		flockdao = new FlockDaoImpl();
		int flockNum = flockdao.findFlocksByUid(uid).size();
		DefaultMutableTreeNode node3=new DefaultMutableTreeNode("我的群组");
		if(flockNum>0)
		{	
			for(int i = 0;i<flockNum;i++)
			{
				DefaultMutableTreeNode flockName = new DefaultMutableTreeNode(flockdao.findFlocksByUid(uid).get(i).getName());
				node3.add(flockName);
			}
		}
		
		
		DefaultTreeModel Mode = new DefaultTreeModel(node3);
		JTree jt = new JTree(Mode);
		jt.setRootVisible(false);// 设置根节点为不可见；
		//jt.putClientProperty("JTree.lineStyle", "Horizontal");// 将树设为水平分隔风格
		jt.setBounds(0, 0, 150, 20);
		jt.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				//TreePath path = flockList.getPathForLocation(b, a);
				TreeNode node=(TreeNode)e.getPath().getLastPathComponent();
				//System.out.println(e.getPath().getPathCount());
				if(node.isLeaf() && e.getPath().getPathCount()>1)
				{
					int flockId=flockdao.findFlocksByFlockName(node.toString()).get(0).getId();
					
					/**
					 * new ChatWin(flockId, uid);
					 * 加群聊窗口
					 */
				}
			}
		});
		jp22.add(jt);
		
		//改动的部分2
		jp3 = new JPanel(new FlowLayout(1,4,4));
		jp3.setPreferredSize(new Dimension(260, 60));
		jp21.add(jp3,BorderLayout.SOUTH);
		
		jb2 = new JButton("添加好友");
		jb2.setPreferredSize(new Dimension(100, 20));
		jp3.add(jb2);
		jb2.addActionListener(new ActionListener()//点击头像跳转至个人信息界面事件
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new SearchUserWin(uid);
			}
		});
		jb5 = new JButton("删除好友");
		jb5.setPreferredSize(new Dimension(100, 20));
		jp3.add(jb5);
		jb5.addActionListener(new ActionListener()//点击头像跳转至个人信息界面事件
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new SearchUserWin(uid);
			}
		});
		jb6 = new JButton("添加分组");
		jb6.setPreferredSize(new Dimension(100, 20));
		jp3.add(jb6);
		jb6.addActionListener(new ActionListener()//点击头像跳转至个人信息界面事件
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new AddGroupWin(uid);
			}
		});
		jb6 = new JButton("删除分组");
		jb6.setPreferredSize(new Dimension(100, 20));
		jp3.add(jb6);
		jb6.addActionListener(new ActionListener()//点击头像跳转至个人信息界面事件
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new SearchUserWin(uid);
			}
		});
		
		jp4 = new JPanel(new FlowLayout(1,4,4));
		jp4.setPreferredSize(new Dimension(260, 40));
		jp22.add(jp4,BorderLayout.SOUTH);
		
		jb4 = new JButton("新建群组");
		jb4.setPreferredSize(new Dimension(100, 20));
		jp4.add(jb4);
		
		jb3 = new JButton("添加群组");
		jb3.setPreferredSize(new Dimension(100, 20));
		jp4.add(jb3);
		jb3.addActionListener(new ActionListener()//点击头像跳转至个人信息界面事件
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new SearchUserWin(uid);
			}
		});
		
		tab.add(name1,jp21);//方法将组件c添加到JTabbedPane窗格中;
		tab.add(name2,jp22);
		tab.add(name3,jp23);
		jp2.add(tab);
		
		jp1.add(jp11);
		jp1.add(jp12);
		con.add(jp1,BorderLayout.NORTH);	
		con.add(jp2,BorderLayout.CENTER);
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		UserInfo userinfo = new UserInfo();
		UserInfoDao userinfodao = new UserInfoDaoImpl();
		userinfo=userinfodao.findUserInfoByUid(FINAL_UID);
		Component[] components = FINAL_LIST.getJp11().getComponents();
		for(Component c : components)
		{
			if(c instanceof JButton)
			{
				((JButton) c).setIcon(new ImageIcon(userinfo.getAvatarpath()));
			}
		}
		
	}
}
