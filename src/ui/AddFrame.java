package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.DBManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFrame frame = new AddFrame();
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
	public AddFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel name = new JLabel("名称");
		name.setBounds(31, 30, 54, 15);
		contentPane.add(name);
		
		JLabel price = new JLabel("单价");
		price.setBounds(31, 86, 54, 15);
		contentPane.add(price);
		
		JLabel vipprice = new JLabel("会员价：");
		vipprice.setBounds(31, 154, 54, 15);
		contentPane.add(vipprice);
		
		JButton btn_add = new JButton("添加");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] clothes = new String[]{textField1.getText(),textField2.getText(),textField3.getText()};
				boolean re = DBManager.executeUpdate("insert into [clothes] values(?,?,?)", clothes);
				if(re){
					JOptionPane.showMessageDialog(AddFrame.this, "添加成功！！","提示",JOptionPane.INFORMATION_MESSAGE);
					textField1.setText("");
					textField2.setText("");
					textField3.setText("");
				}else{
					JOptionPane.showMessageDialog(AddFrame.this, "添加失败！！","提示",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btn_add.setBounds(37, 207, 93, 23);
		contentPane.add(btn_add);
		
		textField1 = new JTextField();
		textField1.setBounds(82, 27, 168, 21);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(82, 83, 168, 21);
		contentPane.add(textField2);
		
		textField3 = new JTextField();
		textField3.setColumns(10);
		textField3.setBounds(82, 151, 168, 21);
		contentPane.add(textField3);
		
		JButton btn_cancle = new JButton("返回");
		btn_cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecordsFrame rd = new RecordsFrame();
				rd.setVisible(true);
				AddFrame.this.setVisible(false);
			}
		});
		btn_cancle.setBounds(197, 207, 93, 23);
		contentPane.add(btn_cancle);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
	}

}
