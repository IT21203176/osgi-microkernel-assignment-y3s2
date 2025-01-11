package testcenterservicepublisher;

public interface testCenterService {

	public void displayTestReport ();
	public void selectTestReportType (String ServiceTestType);
	public void printTestReport (String customerName, String vehicleType, String vehicleNumber, String technicianName, String techName);
	public void testReportHistory (String customerName);
	public void viewServiceTestReport (String customerName, String vehicleType, String vehicleNumber, String technicianName, String techName);
	public void viewServiceTestReportHistory();
	public void importToCSV (String path);
	public void clearData();
	
}
