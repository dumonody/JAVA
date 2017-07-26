package cn.chatsys.view;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.chatsys.dao.UserDao;
import cn.chatsys.dao.impl.UserDaoImpl;
import cn.chatsys.service.RegisterDao;
import cn.chatsys.service.RegisterDaoImpl;
import cn.chatsys.util.tips.Between;


public class Register {
	private static JFrame frame = new JFrame("注册");
	private UserDao userdao = new UserDaoImpl();
	public Register()
	{
		
		JPanel panel = new JPanel();
		frame.add(panel);//添加面板
		placeComponents(panel);//调用用户定义的方法并添加组件到面板
		frame.setSize(380, 250);//窗口的大小
		frame.setLocation(520, 280);//设置窗口左上角的坐标
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗口后的默认操作
		frame.setVisible(true);//参数为true时设置窗口可见
		frame.setResizable(false);//设置框架为不可调整大小
		/**
		 * 加的东西
		 */
		Image title=new ImageIcon("avatar\\111.jpg").getImage();
		frame.setIconImage(title);
	}
	
	private void placeComponents(final JPanel panel) {
		panel.setLayout(null);//布局为空
        JLabel userLabel = new JLabel("账         号:");// 创建 JLabel
		userLabel.setBounds(70, 50, 80, 25);//(User离左边框的距离,User离上边框的距离,,)
		panel.add(userLabel);
			
		// 创建文本域用于用户输入
		final JTextField userText = new JTextField(20);
		userText.setBounds(130, 50, 165, 25);//定义组件的位置（离左的距离，离上的距离，，）
		panel.add(userText);

		
		// 输入密码的文本域
		JLabel passwordLabel = new JLabel("密         码:");
		passwordLabel.setBounds(70,80,80,25);//(,,密码文本域的长度,密码文本域的高度)
		panel.add(passwordLabel);	
		
		// 输入的文本域，但输入信息会以点代替，用来保护密码的安全性
		final JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(130,80,165,25);
		panel.add(passwordText);
		// 输入确认密码的文本域
		JLabel passwordLabel2 = new JLabel("确认密码:");
		passwordLabel2.setBounds(70,110,80,25);//(,,密码文本域的长度,密码文本域的高度)
		panel.add(passwordLabel2);	
		
		// 输入的文本域，但输入信息会以点代替，用来保护密码的安全性
		final JPasswordField passwordText2 = new JPasswordField(20);
		passwordText2.setBounds(130,110,165,25);
		panel.add(passwordText2);
	
		// 创建注册按钮
        JButton registerButton = new JButton("注册");
        registerButton.setBounds(150, 150, 80, 25);
        panel.add(registerButton);
        ActionListener al = new ActionListener()
        {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				RegisterDao rd = new RegisterDaoImpl();
				String loginName = userText.getText();
				char[] a= passwordText.getPassword();
				char[] b= passwordText2.getPassword();
				
				String password = new String (a);
				String password2 = new String (b);
				Between bt = new Between();
				if(loginName==null || a.length==0)
				{
					JOptionPane.showMessageDialog(panel, "账号或密码不能为空", "错误",JOptionPane.WARNING_MESSAGE); 
				}
				else if(!bt.between(password, password2))
				{
					JOptionPane.showMessageDialog(panel, "两次密码输入不一致", "错误",JOptionPane.WARNING_MESSAGE); 
				}
				else if(rd.register(loginName, password, password2))
				{
					int uid=userdao.findUserbyLoginName(loginName).getId();
					frame.dispose();
					//LoginWin.frame.setVisible(true);
					//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					new AddUserInfoWin(uid);
				}
				else
				{
					JOptionPane.showMessageDialog(panel, "账号已存在", "错误",JOptionPane.WARNING_MESSAGE); 
				}
				
			}
		};
		registerButton.addActionListener(al);
		panel.add(registerButton);
		/**
		 * 改动部分
		 */
		ImageIcon background=new ImageIcon("avatar\\111.jpg");
		JLabel lblBackGround = new JLabel(background);
		lblBackGround.setBounds(0, 0, 395, 270);
		panel.add(lblBackGround);//背景图片
	}
	
}

