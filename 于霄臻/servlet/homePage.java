package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import entity.TestCases;

/**
 * Servlet implementation class homePage
 */
@WebServlet("/homePage")
public class homePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<TestCases> list = new ArrayList<TestCases>();
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interface_test_platform?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8", "root", "root");
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
			//关闭sql对象
			st.close();
			//关闭连接
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("HomePage.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
