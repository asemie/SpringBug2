package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class newTestCase
 */
@WebServlet("/newTestCase")
public class newTestCase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newTestCase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String casename= request.getParameter("casename"); 
		String caseadd= request.getParameter("caseaddress"); 
		String casedescribe= request.getParameter("casedescription"); 
		String casetime= request.getParameter("casetime"); 
		String casepep= request.getParameter("caseuser");
		String caseparameter = request.getParameter("caseparameter");
		String casesResult = "未执行";
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interface_test_platform?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8", "root", "root");
			//插入sql语句
			String sql="INSERT into test_case (cname,cadd,cdescribe,ctime,cuser,cparameter,cresult) VALUE ('"+casename+"','"+caseadd+"','"+casedescribe+"','"+casetime+"','"+casepep+"','"+caseparameter+"','"+casesResult+"')";
			System.out.println(sql);
			
			//创建执行sql语句的对象
			Statement st = con.createStatement();
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
		request.getRequestDispatcher("newTestCase.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
