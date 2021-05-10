package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.TestCases;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user= request.getParameter("userName"); 
		String pwd= request.getParameter("password");
		System.out.println(user+pwd);
		try {
			//��������
			Class.forName("com.mysql.cj.jdbc.Driver");
			//�������ݿ�
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interface_test_platform?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			String sql="select * from login";
			//����ִ��sql���Ķ���
			Statement st = con.createStatement();
			//ִ��sql���
			ResultSet rs =st.executeQuery(sql);
			while(rs.next()) {
				String username = rs.getString(1);
				String password = rs.getString(2);
				System.out.println(username+password);
				request.getRequestDispatcher("/InterfaceTest/homePage").forward(request,response);
				if(user==username) {
					if(pwd==password) {
						request.getRequestDispatcher("homePage.java").forward(request,response);
					}
					else{
						request.getRequestDispatcher("login.jsp").forward(request,response);
					}
				}				
			}
			//�ر�sql����
			st.close();
			//�ر�����
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
