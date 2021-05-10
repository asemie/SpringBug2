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
	 * 执行sql脚本文件
	 * @param username 数据库用户名称
	 * @param password 数据库用户密码
	 * @param url 数据库url
	 * @param driverClassName 数据库驱动
	 * @param filepath 脚本文件路径
	 */

	static String driverClassName="com.mysql.jdbc.Driver";
	public static void exeSqlFile(String username, String password, String url,String filepath){
		try {
			String filepathName = filepath.substring(0,filepath.lastIndexOf("."));
			String outputPath = filepathName+".out";
			SQLExec sqlExec = new SQLExec();
			//设置数据库参数   
			sqlExec.setDriver(driverClassName);   
			sqlExec.setUrl(url);  
			sqlExec.setUserid(username);
			sqlExec.setPassword(password); 
			//设置字符编码
			sqlExec.setEncoding("GBK");
			//要执行的脚本   
			sqlExec.setSrc(new File(filepath));
			//有出错的语句该如何处理   
			sqlExec.setOnerror((SQLExec.OnError)(EnumeratedAttribute.getInstance(   
			SQLExec.OnError.class, "abort")));  
			sqlExec.setPrint(true); //设置是否输出  
			//输出到文件 sql.out 中；不设置该属性，默认输出到控制台
			sqlExec.setOutput(new File(outputPath));   
			sqlExec.setProject(new Project()); // 要指定这个属性，不然会出错   
			sqlExec.execute();
			System.out.println("执行sql脚本文件成功");
		} catch (Exception e) {
			System.err.println("执行sql脚本文件失败");
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
			System.out.println("获取驱动类失败");
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("数据库连接失败");
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
						System.out.print(columnName+"："+name+"   ");
					}else if (columnTypeName.equals("INT")) {
						int name = resultSet.getInt(columnName);
						System.out.print(columnName+"："+name+"   ");
					}	
				}
				System.out.println();
//				int id = resultSet.getInt("id");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//关闭三个接口的对象
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
