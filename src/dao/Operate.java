package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Clothes;
import util.DBManager;


public class Operate {
	
	//tcfgynimo,lp.[;/'yjhngbdsfghjkl;
	private int i=0;
	
	
	
		
		private static Statement statement = null;
		private static ResultSet resultSet = null;
		private static PreparedStatement preparedStatement = null;
		private static Connection connection=DBManager.getConnection();

		public static Integer getLogin(String name, String password) {
			// TODO Auto-generated method stub
			if(connection==null){
				return null;
			}
			Integer count = null;
			try {
				String sql = "select count(1) from [user] where name =? and password=?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, password);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()){
					count=resultSet.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
					try {
						if(preparedStatement!=null){
							preparedStatement.close();
						}
						if(resultSet!=null){
							resultSet.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			return count;
		}
		
		public static List<Clothes> getClothesList(){
			List<Clothes> list = new ArrayList<>();
			if(connection==null){
				return null;
			}
			try {
				String sql = "select * from clothes";
				preparedStatement = connection.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
					Clothes cl = new Clothes();
					cl.setId(resultSet.getInt(1));
					cl.setClothesType(resultSet.getString(2));
					cl.setPrice(resultSet.getFloat(3));
					cl.setVipPrice(resultSet.getFloat(4));
					list.add(cl);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
			
			return list;
			
		}
		
		/////
		public static Clothes getClothes(int num){
			
			if(connection==null){
				return null;
			}
			Clothes cl = new Clothes();
			try {
				String sql = "select * from clothes where clothes_Id=?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, num);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
					cl.setId(resultSet.getInt(1));
					cl.setClothesType(resultSet.getString(2));
					cl.setPrice(resultSet.getFloat(3));
					cl.setVipPrice(resultSet.getFloat(4));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
			
			return cl;
			
		}
		
		//测试
		public static void main(String[] args) {
			System.out.println(getClothes( 32).getClothesType());
		}

}
