package sql;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;
import org.apache.tools.ant.types.EnumeratedAttribute;


public class Demo2 {
	/**
	 * ִ��sql�ű��ļ�
	 * @param username ���ݿ��û�����
	 * @param password ���ݿ��û�����
	 * @param url ���ݿ�url
	 * @param driverClassName ���ݿ�����
	 * @param filepath �ű��ļ�·��
	 */

	static String driverClassName="com.mysql.jdbc.Driver";
	public static void exeSqlFile(String username, String password, String url,String filepath){
		try {
			String filepathName = filepath.substring(0,filepath.lastIndexOf("."));
			String outputPath = filepathName+".out";
			SQLExec sqlExec = new SQLExec();
			//�������ݿ����   
			sqlExec.setDriver(driverClassName);   
			sqlExec.setUrl(url);  
			sqlExec.setUserid(username);
			sqlExec.setPassword(password); 
			//�����ַ�����
			sqlExec.setEncoding("GBK");
			//Ҫִ�еĽű�   
			sqlExec.setSrc(new File(filepath));
			//�г����������δ���   
			sqlExec.setOnerror((SQLExec.OnError)(EnumeratedAttribute.getInstance(   
			SQLExec.OnError.class, "abort")));  
			sqlExec.setPrint(true); //�����Ƿ����  
			//������ļ� sql.out �У������ø����ԣ�Ĭ�����������̨
			sqlExec.setOutput(new File(outputPath));   
			sqlExec.setProject(new Project()); // Ҫָ��������ԣ���Ȼ�����   
			sqlExec.execute();
			System.out.println("ִ��sql�ű��ļ��ɹ�");
		} catch (Exception e) {
			System.err.println("ִ��sql�ű��ļ�ʧ��");
		}
	}
	public static void show(String url,String username,String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			 Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("��ȡ������ʧ��");
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("���ݿ�����ʧ��");
			e.printStackTrace();
		}
		String sql = "select * from demo";
		try {
			preparedStatement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			resultSet = preparedStatement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			ResultSetMetaData data = resultSet.getMetaData();
			String[] col = null;
			while (resultSet.next()) {
//				int id = resultSet.getInt("id");
//				String name = resultSet.getString("testcase");
//				System.out.println("id:"+id+" name:"+name);
				for (int i = 1; i <= data.getColumnCount(); i++) {
					String columnName = data.getColumnName(i);
					String columnTypeName = data.getColumnTypeName(i);
					if (columnTypeName.equals("VARCHAR")) {
						String name = resultSet.getString(columnName);
						System.out.print(columnName+"��"+name+"   ");
					}else if (columnTypeName.equals("INT")) {
						int name = resultSet.getInt(columnName);
						System.out.print(columnName+"��"+name+"   ");
					}	
				}
				System.out.println();
//				int id = resultSet.getInt("id");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//�ر������ӿڵĶ���
		if (resultSet!=null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if (preparedStatement!=null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if (connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		String username = "root";
		String password = "123456";
		String host = "127.0.0.1";
		String port="3306";
		String dbName="demo";
		String url="jdbc:mysql://"+host+":"+port+"/"+dbName;
		String filepath = "F:\\demo.sql";
//		exeSqlFile(username, password, url, filepath);
		show(url,username,password);
	}
}
