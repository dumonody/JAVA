package cn.chatsys.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.chatsys.dao.UserDao;
import cn.chatsys.dao.impl.UserDaoImpl;
import cn.chatsys.service.LoginDao;
import cn.chatsys.service.LoginDaoImpl;
import java.awt.Color;
import java.awt.Font;

public class LoginWin {
	private static LoginWin lo = new LoginWin();
	static JFrame frame = new JFrame("登录");
	private JLabel lblNewLabel = new JLabel();

	public static void main(String[] args) {
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);// 添加面板
		lo.placeComponents(panel);// 调用用户定义的方法并添加组件到面板
		
		
		frame.setSize(395, 270);// 窗口的大小
		frame.setLocation(520, 280);// 设置窗口左上角的坐标
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置关闭窗口后的默认操作
		frame.setVisible(true);// 参数为true时设置窗口可见
		frame.setResizable(false);// 设置框架为不可调整大小
	}

	private void placeComponents(final JPanel panel) {
		lblNewLabel.setFont(new Font("宋体", Font.ITALIC, 18));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(122, 143, 174, 18);
		panel.add(lblNewLabel);
		panel.setLayout(null);// 布局为空
		JLabel userLabel = new JLabel("账     号:");// 创建 JLabel
		userLabel.setBounds(40, 72, 80, 25);// (User离左边框的距离,User离上边框的距离,,)
		panel.add(userLabel);
		// 创建文本域用于用户输入
		final JTextField userText = new JTextField(20);
		userText.setBounds(122, 72, 174, 25);// 定义组件的位置（离左的距离，离上的距离，，）
		panel.add(userText);

		// 输入密码的文本域
		JLabel passwordLabel = new JLabel("密     码:");
		passwordLabel.setBounds(40, 110, 80, 25);// (,,密码文本域的长度,密码文本域的高度)
		panel.add(passwordLabel);

		// 输入的文本域，但输入信息会以点代替，用来保护密码的安全性
		final JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(122, 110, 174, 25);
		panel.add(passwordText);

		// 创建登录按钮
		JButton loginButton = new JButton("登录");
		loginButton.setBounds(122, 174, 80, 25);
		ActionListener l = new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				String loginName = userText.getText();// 获得输入的账号

				char[] pwd = passwordText.getPassword();// 获得输入的密码
				String pw = new String(pwd);
				LoginDao ld = new LoginDaoImpl();
				if (ld.Login(loginName, pw)) 
				{
					UserDao ud = new UserDaoImpl();
					new List(ud.findUserbyLoginName(loginName).getId());
					frame.dispose();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} 
				else
				{
					lblNewLabel.setText("用户名|密码错误");
				}
			}
		};
		loginButton.addActionListener(l);
		panel.add(loginButton);

		// 创建注册按钮
		JButton registerButton = new JButton("注册");
		registerButton.setBounds(216, 174, 80, 25);
		panel.add(registerButton);
		ActionListener re = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("");
				new Register();
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		};
		registerButton.addActionListener(re);
		panel.add(registerButton);
	}
}
