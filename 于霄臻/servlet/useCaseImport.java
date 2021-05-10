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
//			//�������ݿ����   
//			sqlExec.setDriver(driverClassName);   
//			sqlExec.setUrl(url);  
//			sqlExec.setUserid(username);
//			sqlExec.setPassword(password); 
//			//�����ַ�����
//			sqlExec.setEncoding("GBK");
//			//Ҫִ�еĽű�   
//			sqlExec.setSrc(new File(filepath));
//			//�г����������δ���   
//			sqlExec.setOnerror((SQLExec.OnError)(EnumeratedAttribute.getInstance(   
//			SQLExec.OnError.class, "abort")));  
//			sqlExec.setPrint(true); //�����Ƿ����  
//			//������ļ� sql.out �У������ø����ԣ�Ĭ�����������̨
//			sqlExec.setOutput(new File(outputPath));   
//			sqlExec.setProject(new Project()); // Ҫָ��������ԣ���Ȼ�����   
//			sqlExec.execute();
//			System.out.println("ִ��sql�ű��ļ��ɹ�");
//		} catch (Exception e) {
//			System.err.println("ִ��sql�ű��ļ�ʧ��");
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
		response.setContentType("text/html;charset=utf-8");//������Ӧ�ַ���ʹ�õı��룬���ܸ�֪�������ʲô���������ʾ
		
		//��request�л�ȡ�ı���������Ϣ
		InputStream fileSourceStream = request.getInputStream();
		String tempFileName = "D:/demo/trainingProject/InterfacePlatform/tempFile";
 
		//������ʱ�ļ���������ϴ����ı�������
		File tempFile = new File(tempFileName);
		
		//outputStram�ļ������ָ�����tempFile
		FileOutputStream outputStream = new FileOutputStream(tempFile);
		
		//��ȡ�ļ���
		byte temp[] = new byte[1024];
		int n;
		while(( n = fileSourceStream.read(temp)) != -1){
			outputStream.write(temp, 0, n);
		}
		outputStream.close();
		fileSourceStream.close();
		
		//��ȡ�ϴ��ļ������� 
		RandomAccessFile randomFile = new RandomAccessFile(tempFile,"r");
		randomFile.readLine();  
		String str = randomFile.readLine();
		int start = str.lastIndexOf("=") + 2;
		int end = str.lastIndexOf("\"");
		String filename = str.substring(start, end);
		
		//��λ�ļ�ָ�뵽�ļ�ͷ
		randomFile.seek(0);
		long startIndex = 0;
		int i = 1;
		//��ȡ�ļ����ݵĿ�ʼλ��
		while(( n = randomFile.readByte()) != -1 && i <=4){
			if(n == '\n'){
				startIndex = randomFile.getFilePointer();
				i ++;
			}
		}
		//ǰ������һ��
		startIndex = startIndex -1; 
		//��ȡ�ļ����ݽ���λ��
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
		
		//���ñ����ϴ��ļ���·��
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
			System.out.println("1");
			System.out.println("ִ��sql�ű��ļ��ɹ�");
		} catch (Exception e) {
			System.err.println("ִ��sql�ű��ļ�ʧ��");
		}
//		request.getRequestDispatcher("useCaseImport.jsp").forward(request,response);
		
		
		
		File saveFile = new File(realPath,filename);
		RandomAccessFile randomAccessFile = new RandomAccessFile(saveFile,"rw");
		//������ֹλ�ô���ʱ�ļ��ж�ȡ�ļ�����
		randomFile.seek(startIndex);
		while(startIndex < endIndex){
			randomAccessFile.write(randomFile.readByte());
			startIndex = randomFile.getFilePointer();
		}
		//�ر������������ ɾ����ʱ�ļ�
		randomFile.close();
		tempFile.delete();
		
		request.setAttribute("result", "�ļ��ϴ��ɹ�");
		RequestDispatcher dispatcher = request.getRequestDispatcher("useCaseImport.jsp");
		dispatcher.forward(request, response);
	}

}
