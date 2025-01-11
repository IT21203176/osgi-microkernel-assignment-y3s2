package testcenterservicepublisher;

public class testCenter {

	public String testType, customerName, serviceCheckType;
	public double testResult;
	
	public testCenter(String testType) {
		
		this.testType = testType;
		
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}
	
}
