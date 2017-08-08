package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

	
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://localhost:1433;DataBaseName=Clothing_Store";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "123456";
	
	
	/**
	 * 数据库的连接
	 * @return
	 */
	public static Connection getConnection(){
		Connection connection=null;
		try {
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	
	/**
	 * 数据库的增删改封装
	 * @param sql
	 * @param objs
	 * @return
	 */
	public static boolean executeUpdate(String sql,Object[] objs){
		boolean result=false;
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			if(objs!=null){
				for(int i=0;i<objs.length;i++){
					preparedStatement.setObject(i+1, objs[i]);
				}
			}
			int num = preparedStatement.executeUpdate();
			if(num>0){
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(preparedStatement,connection);
		}
		
		return result;
	}
	
	/**
	 * 关闭连接
	 * @param st
	 * @param conn
	 */
	public static void closeAll(Statement st,Connection conn){
		try {
			if(st!=null){
				st.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
