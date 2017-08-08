package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.Operate;
import entity.Clothes;
import util.DBManager;

public class RecordsFrame extends JFrame{
	
	RecordsFrame(){
		setTitle("消费记录");
		setBounds(300, 200, 800, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		
		String[] cols = {"序号","消费项","单价","会员价"};
		DefaultTableModel mod = new DefaultTableModel(cols, 0);
		JTable table =new JTable(mod);
				
		for(Clothes clothes:Operate.getClothesList()){
			mod.addRow(new Object[]{clothes.getId(),clothes.getClothesType(),clothes.getPrice(),clothes.getVipPrice()});
		}
		
		JScrollPane jsp = new JScrollPane(table);
		this.getContentPane().add(jsp,BorderLayout.CENTER);
		JPanel jp = new JPanel();
		JButton bt1 = new JButton("增加");
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFrame rd = new AddFrame();
				rd.setVisible(true);
				RecordsFrame.this.setVisible(false);
			}
		});
		bt1.setFocusPainted(false);
		JButton bt2 = new JButton("修改");
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowNum = table.getSelectedRow();
				if(rowNum>=0){
					
//					System.out.println(mod.getValueAt(rowNum,1).toString()+mod.getValueAt(rowNum,2).toString()+mod.getValueAt(rowNum,3).toString());
//					String name = mod.getValueAt(rowNum,1).toString();
//					String price = mod.getValueAt(rowNum,2).toString();
//					String vipprice = mod.getValueAt(rowNum,3).toString();
					UpdateFrame.selectId=(int) mod.getValueAt(rowNum,0);
					
					
					UpdateFrame rd = new UpdateFrame();
					rd.setVisible(true);
					RecordsFrame.this.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(RecordsFrame.this, "请选择一行进行修改!","提示",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		bt2.setFocusPainted(false);
		JButton bt3 = new JButton("删除");
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean re = false;
				int rowNum = table.getSelectedRow();
				int[] rowNums = table.getSelectedRows();
				/*if(rowNum>=0){		
					if(JOptionPane.showConfirmDialog(RecordsFrame.this, "确实要删除吗？", "消息询问", JOptionPane.YES_NO_OPTION)==0){
						boolean re = DBManager.executeUpdate("delete from clothes where clothes_Id=?",new Object[]{(int) mod.getValueAt(rowNum,0)});
						if(re){
							JOptionPane.showMessageDialog(RecordsFrame.this, "删除成功!","提示",JOptionPane.INFORMATION_MESSAGE);
							RecordsFrame.this.dispose();
							new RecordsFrame().setVisible(true);
							
						}
					}else{
						JOptionPane.showMessageDialog(RecordsFrame.this, "删除失败,你没有选择任何行!","提示",JOptionPane.INFORMATION_MESSAGE);
					}
				}*/
					
				if(rowNums.length>0){
					if(JOptionPane.showConfirmDialog(RecordsFrame.this, "确实要删除吗？", "消息询问", JOptionPane.YES_NO_OPTION)==0){
						for(int i=0;i<rowNums.length;i++){
							re = DBManager.executeUpdate("delete from clothes where clothes_Id=?",new Object[]{(int) mod.getValueAt(rowNums[i],0)});
						}
					}
					if(re){
						JOptionPane.showMessageDialog(RecordsFrame.this, "删除成功!","提示",JOptionPane.INFORMATION_MESSAGE);
						RecordsFrame.this.dispose();
						new RecordsFrame().setVisible(true);
					}else{
						JOptionPane.showMessageDialog(RecordsFrame.this, "删除失败!","提示",JOptionPane.INFORMATION_MESSAGE);
					}
					
				}else{
					JOptionPane.showMessageDialog(RecordsFrame.this, "删除失败,你没有选择任何行!","提示",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		bt3.setFocusPainted(false);
		jp.add(bt1);
		jp.add(bt2);
		jp.add(bt3);
		
		this.add(jp,BorderLayout.NORTH);
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		new RecordsFrame().setVisible(true);
	}
	
	

}
