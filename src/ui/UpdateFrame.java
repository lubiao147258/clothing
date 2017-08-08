package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.Operate;
import util.DBManager;

public class UpdateFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	public static int selectId;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateFrame frame = new UpdateFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public UpdateFrame(String name,String price,String vipprice){
		if(name!=null&&price!=null&&vipprice!=null){
			System.out.println(name+price+vipprice);
			textField1.setText(name);
			textField2.setText(price);
			textField3.setText(vipprice);
		}
		
	}

	/**
	 * Create the frame.
	 */
	public UpdateFrame() {
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
		
		JButton btn_add = new JButton("修改");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(selectId);
				String[] aa = new String[]{textField1.getText(),textField2.getText(),textField3.getText(),String.valueOf(selectId)};
				if(DBManager.executeUpdate("update clothes set clothes_type=?,price=?,vip_price=? where clothes_Id=?", aa)){
					JOptionPane.showMessageDialog(UpdateFrame.this, "修改成功!","提示",JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(UpdateFrame.this, "修改失败!","提示",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btn_add.setBounds(37, 207, 93, 23);
		contentPane.add(btn_add);
		
		textField1 = new JTextField();
		textField1.setBounds(82, 27, 168, 21);
		textField1.setText(String.valueOf(Operate.getClothes(selectId).getClothesType().trim()));
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(82, 83, 168, 21);
		textField2.setText(String.valueOf(Operate.getClothes(selectId).getPrice()));
		contentPane.add(textField2);
		
		textField3 = new JTextField();
		textField3.setColumns(10);
		textField3.setBounds(82, 151, 168, 21);
		textField3.setText(String.valueOf(Operate.getClothes(selectId).getVipPrice()));
		contentPane.add(textField3);
		
		JButton btn_cancle = new JButton("返回");
		btn_cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecordsFrame rd = new RecordsFrame();
				rd.setVisible(true);
				UpdateFrame.this.setVisible(false);
			}
		});
		btn_cancle.setBounds(197, 207, 93, 23);
		contentPane.add(btn_cancle);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
	}

}
