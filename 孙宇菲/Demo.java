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
		//快速冻结user1
		JSONObject user = new JSONObject();
		Response resp = given()
				.contentType("application/json")
				.body(user.toString())
				.post(baseUrl+url1);
		
		resp.print();
		Assert.assertEquals(resp.jsonPath().getString("rspMsg"), "成功");

	}	
	

	@Test
	public void addExistRoleName() {
		//新增已经存在的角色名
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
		//新增已经存在的角色标志
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
		//新增角色 不填写角色标识
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
		//查询 不输入条件
		Response resp=given()
				.params("page",1,"limit",10)
				.contentType("application/json;charset=UTF-8")
				.get(baseUrl+url3);
		resp.print();
		Assert.assertEquals(resp.jsonPath().getString("rspMsg"), "成功");
	}		


}
