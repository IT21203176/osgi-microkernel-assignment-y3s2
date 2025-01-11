package testcenterservicepublisher;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class testCenterServiceImpl implements testCenterService {

	ArrayList<testCenter> checkDescription = new ArrayList<testCenter>();
	ArrayList<Double> checkListResult = new ArrayList<Double>();
	ArrayList<String> checkListHistory = new ArrayList<String>();
	ArrayList<String> checkListTestHistory = new ArrayList<String>();
	
	@Override
	public void displayTestReport() {
		
		System.out.println("==========Service Checklist==========");
		System.out.println(" \n");
		System.out.println(" \n");
		System.out.println(" --01. Battery check");
		System.out.println(" --02. Check foot brakes");
		System.out.println(" --03. Replace oil filter");
		System.out.println(" --04. Brakes");
		System.out.println(" --05. Check air conditioner");
		System.out.println(" --06. Check other important fluids");
		System.out.println(" --07. Light");
		System.out.println(" --08. Suspension");
		System.out.println(" --09. Air filter");
		System.out.println(" --10. Check windscreen wipers");
		System.out.println(" --11. Tyre tread checks");
		System.out.println(" --12. Durability testing");
		System.out.println(" --13. Oil testing");
		System.out.println(" --14. Check coolant level");
		System.out.println(" --15. Brake fluid exchange");
		System.out.println(" --16. Changing spark plugs");
		System.out.println(" --17. Integration testing");
		System.out.println(" --18. Car suspension");
		System.out.println(" --19. Wheel Performance");
		System.out.println(" --20. Car battery");
		System.out.println("");
		
	}
	
	@Override
	public void selectTestReportType(String ServiceTestType) {
		
		checkDescription.add(new testCenter(ServiceTestType));
		checkListTestHistory.add(ServiceTestType);
		
		double max = 10;
		double min = 1;
		double range = max - min + 1;
		
		// Generate random numbers within 1 to 10
		for (int i = 0; i < 10; i++) {
			
			double testResult = (Math.random() * range) + min;
			double percentageResult = testResult * 10;
			checkListResult.add(percentageResult);
		}
		
	}
	
	@Override
	public void printTestReport(String customerName, String vehicleType, String vehicleNumber, String technicianName,
			String techName) {
		
		try {
			File file = new File("D:\\ServiceTest.txt");
			
			FileWriter fileWriter = new FileWriter("D:\\ServiceTest.txt");
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			printWriter.println("============================================================ TEST SUMMARY ============================================================");
			printWriter.println("\n");
			printWriter.println(" 			Test Performed by: Mr."+technicianName);
			printWriter.println("");
			printWriter.println("							Customer Name: " + customerName);
			printWriter.println("							Type of the Vehicle: " + vehicleType);
			printWriter.println("							Vehicle Registration No.: " + vehicleNumber);
			printWriter.println("\n");
			printWriter.println("Test Checkings ");
			printWriter.println("---------------");
			printWriter.println("\n");
			for(int i = 0; i <= checkDescription.size() - 1; i++) {
				printWriter.println(checkDescription.get(i).getTestType() + "	-	Test Value: " + checkListResult.get(i));
			}
			printWriter.println("\n");
			printWriter.println("=======================================================================================================================================");
			System.out.println("Printed Successfully.");
			printWriter.close();
		}
		catch (IOException e) {
			System.out.println("An Error Occured while Printing the File.");
			System.out.println("Try Again. Thank You.");
		}
		
	}
	
	@Override
	public void testReportHistory(String customerName) {
		
		if(!checkListHistory.isEmpty()) {
			int last = checkListHistory.size() - 1;
			String previous = checkListHistory.get(last);
			
			if(!previous.equals(customerName)) {
				checkListHistory.add(customerName);
			}
		}
		else {
			checkListHistory.add(customerName);
		}
		
	}
	
	@Override
	public void viewServiceTestReport(String customerName, String vehicleType, String vehicleNumber,
			String technicianName, String techName) {
		
		System.out.println("============================================================ TEST SUMMARY ============================================================");
		System.out.println("\n");
		System.out.println(" 			Test Performed by: Mr."+technicianName);
		System.out.println("\n");
		System.out.println("							Customer Name: " + customerName);
		System.out.println("							Type of the Vehicle: " + vehicleType);
		System.out.println("							Vehicle Registration No.: " + vehicleNumber);
		System.out.println("\n");
		System.out.println("Test Checkings. ");
		System.out.println("----------------");
		System.out.println("\n");
		for(int i = 0; i <= checkDescription.size() - 1; i++) {
			System.out.println(checkDescription.get(i).getTestType() + "	-	Test Value: " + checkListResult.get(i));
		}
		System.out.println("\n");
		System.out.println("=======================================================================================================================================");
		
	}
	
	@Override
	public void viewServiceTestReportHistory() {
		
int numberOfServices = 0, totalNoOfServices = 0;
		
		System.out.println("============================================================ VIEW CHECKLIST TEST REPORT SUMMARY ============================================================");
		System.out.println("Customers' Names: ");
		
		for(int i = 0; i <= (checkListHistory.size() - 1); i++) {
			System.out.println(i+1 + "." + checkListHistory.get(i));
			
			numberOfServices = checkListHistory.size();
			totalNoOfServices = checkListTestHistory.size();
			
		}
		for(int x = 0; x <= (checkListTestHistory.size() - 1); x++) {
			System.out.println("					- " + checkListTestHistory.get(x));
		}
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("");
		System.out.println("Total No. of Test Services: " + totalNoOfServices);
		System.out.println("");
		System.out.println("=======================================================================================================================================");
		System.out.println("");
		
	}
	
	@Override
	public void importToCSV(String path) {
		
		try {
	        FileWriter csvWriter = new FileWriter(path);
	        
	        // Write header
	        csvWriter.append("Test Type,");
	        csvWriter.append("Test Result\n");
	        
	        // Write data
	        for (int i = 0; i < checkDescription.size(); i++) {
	            csvWriter.append(checkDescription.get(i).getTestType() + ",");
	            csvWriter.append(String.valueOf(checkListResult.get(i)) + "\n");
	        }
	        
	        csvWriter.flush();
	        csvWriter.close();
	        
	        System.out.println("Data exported to CSV successfully.");
	    } catch (IOException e) {
	        System.out.println("An error occurred while exporting data to CSV: " + e.getMessage());
	    }
		
	}
	
	@Override
	public void clearData() {
		
		checkListResult.clear();
		checkDescription.clear();
		
	}
	
	
}
