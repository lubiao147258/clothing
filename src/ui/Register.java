package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.User;
import util.DBManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JPasswordField text_psw1;
	private JPasswordField text_psw2;
	private JTextField textField;
	private JTextField text_name;
	private JRadioButton rbtn_man;
	private JRadioButton rbtn_woman;
	private JComboBox city;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lab_name = new JLabel("用 户 名：");
		lab_name.setFont(new Font("宋体", Font.PLAIN, 18));
		lab_name.setBounds(51, 9, 107, 29);
		contentPane.add(lab_name);
		
		JLabel lab_psw = new JLabel("密    码：");
		lab_psw.setFont(new Font("宋体", Font.PLAIN, 18));
		lab_psw.setBounds(51, 48, 107, 29);
		contentPane.add(lab_psw);
		
		JLabel lab_psw2 = new JLabel("确认密码：");
		lab_psw2.setFont(new Font("宋体", Font.PLAIN, 18));
		lab_psw2.setBounds(51, 87, 107, 29);
		contentPane.add(lab_psw2);
		
		JLabel lab_sex = new JLabel("性    别：");
		lab_sex.setFont(new Font("宋体", Font.PLAIN, 18));
		lab_sex.setBounds(51, 126, 107, 29);
		contentPane.add(lab_sex);
		
		JLabel lab_city = new JLabel("城    市：");
		lab_city.setFont(new Font("宋体", Font.PLAIN, 18));
		lab_city.setBounds(51, 161, 107, 29);
		contentPane.add(lab_city);
		
		JLabel lab_phone = new JLabel("电    话：");
		lab_phone.setFont(new Font("宋体", Font.PLAIN, 18));
		lab_phone.setBounds(51, 200, 107, 29);
		contentPane.add(lab_phone);
		
		JButton btn_submit = new JButton("提  交");
		btn_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//User user = new User(text_name.getText(),);
				if((new String(text_psw1.getPassword())).equals(new String(text_psw2.getPassword()))){
					String sex = "";
					if(rbtn_man.isSelected()){
						sex="男";
					}else{
						sex="女";
					}					
					String[] user = new String[]{text_name.getText(),new String(text_psw1.getPassword()),sex,(String)city.getSelectedItem() ,textField.getText()};
					boolean re = DBManager.executeUpdate("insert into [user] values(?,?,?,?,?)", user);
					if(re){
						JOptionPane.showMessageDialog(Register.this, "注册成功！！","提示",JOptionPane.INFORMATION_MESSAGE);
						text_name.setText("");
						text_psw1.setText("");
						text_psw2.setText("");
						textField.setText("");
					}
				}else{
					JOptionPane.showMessageDialog(Register.this, "两次密码不一致!","提示",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btn_submit.setFont(new Font("宋体", Font.PLAIN, 20));
		btn_submit.setFocusPainted(false);
		btn_submit.setBounds(51, 253, 130, 38);
		contentPane.add(btn_submit);
		
		JButton btn_canale = new JButton("取   消");
		btn_canale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame register = new LoginFrame();
				register.setVisible(true);
				Register.this.setVisible(false);
			}
		});
		btn_canale.setFont(new Font("宋体", Font.PLAIN, 20));
		btn_canale.setFocusPainted(false);
		btn_canale.setBounds(235, 253, 130, 38);
		contentPane.add(btn_canale);
		
		text_name = new JTextField();
		text_name.setFont(new Font("宋体", Font.PLAIN, 20));
		text_name.setColumns(10);
		text_name.setBounds(193, 9, 184, 30);
		contentPane.add(text_name);
		
		text_psw1 = new JPasswordField();
		text_psw1.setBounds(193, 48, 184, 32);
		contentPane.add(text_psw1);
		
		text_psw2 = new JPasswordField();
		text_psw2.setBounds(193, 88, 184, 32);
		contentPane.add(text_psw2);
		
		rbtn_man = new JRadioButton("男");
		rbtn_man.setSelected(true);
		rbtn_man.setBounds(213, 131, 65, 23);
		contentPane.add(rbtn_man);
		
		rbtn_woman = new JRadioButton("女");
		rbtn_woman.setBounds(312, 131, 65, 23);
		contentPane.add(rbtn_woman);
		
		ButtonGroup jbg = new ButtonGroup();
		jbg.add(rbtn_woman);
		jbg.add(rbtn_man);
		//add(jbg);
		
		
		city = new JComboBox();
		city.setModel(new DefaultComboBoxModel(new String[] {"武汉", "北京", "上海", "深圳", "杭州", "江苏", "香港"}));
		city.setBounds(193, 167, 184, 21);
		contentPane.add(city);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(193, 199, 184, 30);
		contentPane.add(textField);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
	}
}
