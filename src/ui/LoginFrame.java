package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.Operate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField text_name;
	private JPasswordField passwordField;

	int count=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lab_name = new JLabel("用户：");
		lab_name.setFont(new Font("宋体", Font.PLAIN, 25));
		lab_name.setBounds(83, 48, 75, 30);
		contentPane.add(lab_name);
		
		JLabel lab_psw = new JLabel("密码：");
		lab_psw.setFont(new Font("宋体", Font.PLAIN, 25));
		lab_psw.setBounds(83, 132, 75, 30);
		contentPane.add(lab_psw);
		
		text_name = new JTextField();
		text_name.setFont(new Font("宋体", Font.PLAIN, 20));
		text_name.setBounds(195, 50, 184, 30);
		contentPane.add(text_name);
		text_name.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(195, 132, 184, 32);
		contentPane.add(passwordField);
		
		JButton btn_login = new JButton("登录");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Operate.getLogin(text_name.getText(), new String(passwordField.getPassword()))==1){
					count=0;
					RecordsFrame rd = new RecordsFrame();
					rd.setVisible(true);
					LoginFrame.this.setVisible(false);
				}else{
					text_name.setText("");
					passwordField.setText("");
					JOptionPane.showMessageDialog(LoginFrame.this, "密码错误!","提示",JOptionPane.INFORMATION_MESSAGE);
					count++;
					if(count==3){
						//JOptionPane.showMessageDialog(LoginFrame.this, “你选择的角色是：	"+selectRole, "提示",JOptionPane.INFORMATION_MESSAGE);
						JOptionPane.showMessageDialog(LoginFrame.this, "错误次数已达三次!","提示",JOptionPane.INFORMATION_MESSAGE);
						LoginFrame.this.setVisible(false);
					}
				}
			}
		});
		btn_login.setFont(new Font("宋体", Font.PLAIN, 20));
		btn_login.setFocusPainted(false);
		btn_login.setBounds(65, 212, 130, 38);
		contentPane.add(btn_login);
		
		JButton btn_register = new JButton("注册");
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Register register = new Register();
				register.setVisible(true);
				LoginFrame.this.setVisible(false);
				
			}
		});
		btn_register.setFont(new Font("宋体", Font.PLAIN, 20));
		btn_register.setFocusPainted(false);
		btn_register.setBounds(249, 212, 130, 38);
		contentPane.add(btn_register);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
	}
}
