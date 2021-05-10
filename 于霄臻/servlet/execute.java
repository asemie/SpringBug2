package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import entity.TestCases;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

/**
 * Servlet implementation class execute
 */
@WebServlet("/execute")
public class execute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public execute() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String result = "";
		int id = Integer.parseInt(request.getParameter("id"));
		List<TestCases> list = new ArrayList<TestCases>();
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interface_test_platform?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			String sql="select * from test_case";
			//创建执行sql语句的对象
			Statement st = con.createStatement();
			//执行sql语句
			ResultSet rs =st.executeQuery(sql);
			while(rs.next()) {
				int casesId = rs.getInt(1);
				String casesName = rs.getString(2);
				String casesAddress = rs.getString(3);
				String casesDescription = rs.getString(4);
				String casesTime = rs.getString(5);
				String casesUser = rs.getString(6);
				String casesParameter = rs.getString(7);
				String casesResult = rs.getString(8);
				TestCases testCases = new TestCases(casesId, casesName, casesAddress, casesDescription, casesTime, casesUser,casesParameter,casesResult);
				list.add(testCases);
			}
			int index = id-1;
			
			if(list.get(index).getCasesDescription().equals("get")) {
				System.out.println(list.get(index).getCasesAddress());
				result = Get(list.get(index).getCasesAddress());
				System.out.println(result);
			}
			else if(list.get(index).getCasesDescription().equals("post")) {
				result = Post(list.get(index).getCasesAddress(), request,list.get(index).getCasesParameter());
			}
			else {
				result = "已执行";
			} 
			
			
			sql = "update test_case set cresult = '"+result+"' where id="+id;
			
			System.out.println(sql);
			
			//创建执行sql语句的对象
			st = con.createStatement();
			//执行sql语句
			int temp =st.executeUpdate(sql);
			
			//关闭sql对象
			st.close();
			//关闭连接
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String site = "localhost:8080/InterfaceTest2/homePage" ;
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", site);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String Get(String url) {
		// TODO Auto-generated method stub
		String result = "";
		Response resp=given()
				.contentType("application/json;charset=UTF-8")
				.get(url);
	  	resp.print();
	  	if(resp.getStatusCode()==200) {
	  		return result = "已执行：成功";
	  	}
	  	else {
	  		return result = "已执行：失败";
	  	}
	}
	
	private String Post(String url,HttpServletRequest request,String parameter) {
		String Result = "";
		Response resp = given()
				.contentType("application/json")
				.body(parameter)
				.post(url);
		resp.print();
		if(resp.getStatusCode()==200) {
			return Result = "已执行：成功";
		}
		else {
			return Result = "已执行：失败";
		}
	}
}
