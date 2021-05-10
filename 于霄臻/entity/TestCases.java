package entity;

public class TestCases {
	private int casesId;
	private String casesName;
	private String casesAddress;
	private String casesDescription;
	private String casesTime;
	private String casesUser;
	private String casesParameter;
	private String casesResult;
	public TestCases() {}
	public TestCases(int casesId, String casesName, String casesAddress, String casesDescription, String casesTime,
			String casesUser,String casesParameter,String casesResult) {
		super();
		this.casesId = casesId;
		this.casesName = casesName;
		this.casesAddress = casesAddress;
		this.casesDescription = casesDescription;
		this.casesTime = casesTime;
		this.casesUser = casesUser;
		this.casesParameter = casesParameter;
		this.casesResult = casesResult;
	}
	public int getCasesId() {
		return casesId;
	}
	public void setCasesId(int casesId) {
		this.casesId = casesId;
	}
	public String getCasesName() {
		return casesName;
	}
	public void setCasesName(String casesName) {
		this.casesName = casesName;
	}
	public String getCasesAddress() {
		return casesAddress;
	}
	public void setCasesAddress(String casesAddress) {
		this.casesAddress = casesAddress;
	}
	public String getCasesDescription() {
		return casesDescription;
	}
	public void setCasesDescription(String casesDescription) {
		this.casesDescription = casesDescription;
	}
	public String getCasesTime() {
		return casesTime;
	}
	public void setCasesTime(String casesTime) {
		this.casesTime = casesTime;
	}
	public String getCasesUser() {
		return casesUser;
	}
	public void setCasesUser(String casesUser) {
		this.casesUser = casesUser;
	}	
	public String getCasesParameter() {
		return casesParameter;
	}
	public void setCasesParameter(String casesParameter) {
		this.casesParameter=casesParameter;
	}
	public String getCasesResult() {
		return casesResult;
	}
	public void setCasesResult(String casesResult) {
		this.casesResult = casesResult;
	}
}
