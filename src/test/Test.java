package test;

import util.DBManager;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if(DBManager.getConnection()!=null){
			System.out.println("ok");
		}
		
	}

}
