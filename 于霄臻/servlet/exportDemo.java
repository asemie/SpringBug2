package servlet;

import java.io.IOException;

public class exportDemo {

	// ʵ�����ݿ�ĵ���������1��
	public static void function1() {
		Runtime runtime = Runtime.getRuntime();
		String command = getExportCommand();
		// ������ʵ�����������ִ�е� command ������
		try {
			Process exec = runtime.exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// �õ��������ݵ����������
	private static String getExportCommand() {
		StringBuffer command = new StringBuffer();
		String username = "root";// �û���
		String password = "123456";// ����
		String host = "localhost";// �����Ŀ�����ݿ����ڵ�����
		String port = "3306";// ʹ�õĶ˿ں�
		String exportDatabaseName = "interface_test_platform";// �����Ŀ�����ݿ������
		String exportPath = "D:/demo/trainingProject/InterfacePlatform/demo/demo.sql";// �����Ŀ���ļ����ڵ�λ��
		String MysqlPath = "D:/upupw32/MySQL/bin/"; // ·����mysql��
		// ע����Щ�ط�Ҫ�ո���Щ��Ҫ�ո�
		command.append(MysqlPath).append("mysqldump -u").append(username).append(" -p").append(password)// �������õ�Сp�����˿����õĴ�P��
				.append(" -h").append(host).append(" -P").append(port).append(" ").append(exportDatabaseName)
				.append(" -r ").append(exportPath);
		return command.toString();
	}

//	public static void main(String[] args) {
//		function1();
//	}

}
