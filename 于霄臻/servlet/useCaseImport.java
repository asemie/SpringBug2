package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;
import org.apache.tools.ant.types.EnumeratedAttribute;

/**
 * Servlet implementation class useCaseImport
 */
@WebServlet("/useCaseImport")
public class useCaseImport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public useCaseImport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String driverClassName="com.mysql.jdbc.Driver";
//		String username = "root";
//		String password = "123456";
//		String url="jdbc:mysql://localhost:3306/interface_test_platform?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8";
//		String filepath = "D:/the Third Grade/test01.sql";
//		System.out.println(filepath);
//		try {
//			String filepathName = filepath.substring(0,filepath.lastIndexOf("."));
//			String outputPath = filepathName+".out";
//			SQLExec sqlExec = new SQLExec();
//			//设置数据库参数   
//			sqlExec.setDriver(driverClassName);   
//			sqlExec.setUrl(url);  
//			sqlExec.setUserid(username);
//			sqlExec.setPassword(password); 
//			//设置字符编码
//			sqlExec.setEncoding("GBK");
//			//要执行的脚本   
//			sqlExec.setSrc(new File(filepath));
//			//有出错的语句该如何处理   
//			sqlExec.setOnerror((SQLExec.OnError)(EnumeratedAttribute.getInstance(   
//			SQLExec.OnError.class, "abort")));  
//			sqlExec.setPrint(true); //设置是否输出  
//			//输出到文件 sql.out 中；不设置该属性，默认输出到控制台
//			sqlExec.setOutput(new File(outputPath));   
//			sqlExec.setProject(new Project()); // 要指定这个属性，不然会出错   
//			sqlExec.execute();
//			System.out.println("执行sql脚本文件成功");
//		} catch (Exception e) {
//			System.err.println("执行sql脚本文件失败");
//		}
//		request.getRequestDispatcher("useCaseImport.jsp").forward(request,response);
		doPost(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");//更改响应字符流使用的编码，还能告知浏览器用什么编码进行显示
		
		//从request中获取文本输入流信息
		InputStream fileSourceStream = request.getInputStream();
		String tempFileName = "D:/demo/trainingProject/InterfacePlatform/tempFile";
 
		//设置临时文件，保存待上传的文本输入流
		File tempFile = new File(tempFileName);
		
		//outputStram文件输出流指向这个tempFile
		FileOutputStream outputStream = new FileOutputStream(tempFile);
		
		//读取文件流
		byte temp[] = new byte[1024];
		int n;
		while(( n = fileSourceStream.read(temp)) != -1){
			outputStream.write(temp, 0, n);
		}
		outputStream.close();
		fileSourceStream.close();
		
		//获取上传文件的名称 
		RandomAccessFile randomFile = new RandomAccessFile(tempFile,"r");
		randomFile.readLine();  
		String str = randomFile.readLine();
		int start = str.lastIndexOf("=") + 2;
		int end = str.lastIndexOf("\"");
		String filename = str.substring(start, end);
		
		//定位文件指针到文件头
		randomFile.seek(0);
		long startIndex = 0;
		int i = 1;
		//获取文件内容的开始位置
		while(( n = randomFile.readByte()) != -1 && i <=4){
			if(n == '\n'){
				startIndex = randomFile.getFilePointer();
				i ++;
			}
		}
		//前面多读了一个
		startIndex = startIndex -1; 
		//获取文件内容结束位置
		randomFile.seek(randomFile.length());
		long endIndex = randomFile.getFilePointer();
		int j = 1;
		while(endIndex >=0 && j<=2){
			endIndex--;
			randomFile.seek(endIndex);
			if(randomFile.readByte() == '\n'){
				j++;
			}
		}
		
		//设置保存上传文件的路径
		String realPath =  "D:/demo/trainingProject/InterfacePlatform/file";
		File fileupload = new File(realPath);
		if(!fileupload.exists()){
			fileupload.mkdir();
		}
		System.out.println(filename);
		String driverClassName="com.mysql.jdbc.Driver";
		String username = "root";
		String password = "root";
		String url="jdbc:mysql://localhost:3306/interface_test_platform?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8";
		String filepath = realPath+"/"+filename;
		System.out.println(filepath);
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
			System.out.println("1");
			System.out.println("执行sql脚本文件成功");
		} catch (Exception e) {
			System.err.println("执行sql脚本文件失败");
		}
//		request.getRequestDispatcher("useCaseImport.jsp").forward(request,response);
		
		
		
		File saveFile = new File(realPath,filename);
		RandomAccessFile randomAccessFile = new RandomAccessFile(saveFile,"rw");
		//根据起止位置从临时文件中读取文件内容
		randomFile.seek(startIndex);
		while(startIndex < endIndex){
			randomAccessFile.write(randomFile.readByte());
			startIndex = randomFile.getFilePointer();
		}
		//关闭输入输出流并 删除临时文件
		randomFile.close();
		tempFile.delete();
		
		request.setAttribute("result", "文件上传成功");
		RequestDispatcher dispatcher = request.getRequestDispatcher("useCaseImport.jsp");
		dispatcher.forward(request, response);
	}

}
