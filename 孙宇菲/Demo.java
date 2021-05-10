package demo.test.syf;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.alibaba.fastjson.JSONObject;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class Demo {	

	String baseUrl="http://127.0.0.1:8080";
	String url1 = "/SysApi/sysRole/Freeze/2";
	String url2 = "/SysApi/sysRole/create";
	String url3 = "/SysApi/sysRole";
	
	@Test
	public void quickFreeze() {
		//���ٶ���user1
		JSONObject user = new JSONObject();
		Response resp = given()
				.contentType("application/json")
				.body(user.toString())
				.post(baseUrl+url1);
		
		resp.print();
		Assert.assertEquals(resp.jsonPath().getString("rspMsg"), "�ɹ�");

	}	
	

	@Test
	public void addExistRoleName() {
		//�����Ѿ����ڵĽ�ɫ��
		JSONObject user = new JSONObject();
		user.put("available", false);
		user.put("cnname", "user1");
		user.put("role", "user1");
		Response resp = given()
				.contentType("application/json")
				.body(user.toString())
				.post(baseUrl+url2);
		resp.print();
		Assert.assertEquals(resp.jsonPath().getString("status"), "500");
	}
	
	@Test
	public void addExistRoleTag() {
		//�����Ѿ����ڵĽ�ɫ��־
		JSONObject user = new JSONObject();
		user.put("available", false);
		user.put("cnname", "user2");
		user.put("role", "role1");
		Response resp = given()
				.contentType("application/json")
				.body(user.toString())
				.post(baseUrl+url2);
		resp.print();
		Assert.assertEquals(resp.jsonPath().getString("status"), "500");
	}
	
	@Test
	public void addNoRoleTag() {
		//������ɫ ����д��ɫ��ʶ
		JSONObject user = new JSONObject();
		user.put("available", false);
		user.put("cnname", "user3");
		user.put("role", "");
		Response resp = given()
				.contentType("application/json")
				.body(user.toString())
				.post(baseUrl+url2);
		resp.print();
		Assert.assertEquals(resp.jsonPath().getString("status"), "500");
	}
	

	@Test
	public void searchNull() {
		//��ѯ ����������
		Response resp=given()
				.params("page",1,"limit",10)
				.contentType("application/json;charset=UTF-8")
				.get(baseUrl+url3);
		resp.print();
		Assert.assertEquals(resp.jsonPath().getString("rspMsg"), "�ɹ�");
	}		


}
