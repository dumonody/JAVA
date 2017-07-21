package cn.chatsys.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChatWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textChat;
	private JTextField textMySend;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatWindow frame = new ChatWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChatWindow() {
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 619, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textChat = new JTextField();
		textChat.setBounds(14, 13, 416, 270);
		contentPane.add(textChat);
		textChat.setColumns(10);
		
		textMySend = new JTextField();
		textMySend.setBounds(14, 328, 416, 173);
		contentPane.add(textMySend);
		textMySend.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("要不这里换成几个按钮");
		lblNewLabel.setBounds(14, 289, 254, 26);
		contentPane.add(lblNewLabel);
		
		JLabel friendHeadImg = new JLabel("这里放图片地址");
		friendHeadImg.setBounds(444, 49, 143, 234);
		contentPane.add(friendHeadImg);
		
		JLabel myHeadImg = new JLabel("也是图片地址");
		myHeadImg.setBounds(444, 328, 143, 213);
		contentPane.add(myHeadImg);
		
		JButton btnSend = new JButton("发送");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//这里写发送信息所实现的东西
				
				//发送完消息后销毁textMySend里面的东西
				
				//功能我不怎么会，晚上写
				
			}
		});
		btnSend.setBounds(317, 514, 113, 27);
		contentPane.add(btnSend);
		
		JButton btnClose = new JButton("关闭");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ChatWindow.this.dispose();
				//这里写整个窗口的关闭
			}
		});
		btnClose.setBounds(190, 514, 113, 27);
		contentPane.add(btnClose);
		
		JLabel lblFriendLook = new JLabel("好友形象");//也可以写成loginName+"的形象";
		//lblFriendLook.setIcon("这个也是放图片地址的");
		lblFriendLook.setBounds(444, 13, 143, 23);
		contentPane.add(lblFriendLook);
		
		JLabel lblMineLook = new JLabel("我的形象");//加个图片地址
		//lblMineLook.setIcon("这个是放图片地址的");
		lblMineLook.setBounds(444, 289, 143, 26);
		contentPane.add(lblMineLook);
		
		JButton btnHistory = new JButton("历史记录");
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//这里放新建的窗口，显示历史记录
			}
		});
		btnHistory.setBounds(298, 289, 132, 27);
		contentPane.add(btnHistory);
	}
}
