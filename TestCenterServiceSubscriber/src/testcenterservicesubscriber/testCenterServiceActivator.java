package testcenterservicesubscriber;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import testcenterservicepublisher.testCenterService;

public class testCenterServiceActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		testCenterServiceActivator.context = bundleContext;
		ServiceReference<testCenterService>serviceReference = context.getServiceReference(testCenterService.class);
		testCenterService service = (testCenterService) context.getService(serviceReference);
		
		LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String formattedDateTime = now.format(formatter);
	    
	    String techName, password, customerName, technicianName, vehicleNumber, vehicleType, path;
		int serviceType = 0, command = 0, printCommand, continueCommand;
		
		Scanner myScanner = new Scanner(System.in);
		System.out.println("\n");
		System.out.println("==================== Welcome to AutoBuddy Vehicle Services ====================");
		System.out.println("\n");
		System.out.println("Please SignIn to the System.");
		System.out.println("\n");
		System.out.println("Generated Date & Time: " + formattedDateTime);
		System.out.println("\n");
		
		int correct;
		
		do {
			System.out.println("Enter Username: ");
			techName = myScanner.next();
			
			System.out.println("Enter Password: ");
			password = myScanner.next();
			
			if(techName.equals("Tech123") && password.equals("t123")) {
				System.out.println("\n");
				System.out.println("Login Successfull...");
				System.out.println("\n");
				correct = 1;
				
			}else {
				System.out.println("Please Submit the Correct Credentials. Thank You.");
				System.out.println("\n");
				correct = 0;
			}
			
		}while(correct != 1);
		
			System.out.println("Enter your Name: ");
			techName = myScanner.next();
			
			System.out.println("==================== Mr./Ms." + techName + " , Welcome to AutoBuddy ====================");
			
			do {
				System.out.println("\n");
				System.out.println(" Give the relevant value for the service you expect from us ");
				System.out.println("------------------------------------------------------------");
				System.out.println("\n");
				System.out.println("      1 - Vehicle Test. ");
				System.out.println("      2 - View Test Checklist. ");
				System.out.println("      3 - View Customer's Report History. ");
				System.out.println("      4 - Export to a CSV File. ");
				System.out.println("\n");
				System.out.println("Enter a Value: ");
				serviceType = myScanner.nextInt();
				
				if(serviceType == 1) {
					System.out.print("Enter the Name of the Customer: ");
					customerName = myScanner.next();
					
					System.out.print("Enter the Vehicle Type: ");
					vehicleType = myScanner.next();
					
					System.out.print("Enter the Registration Number: ");
					vehicleNumber = myScanner.next();
					
					System.out.print("Enter Technician Name: ");
					technicianName = myScanner.next();
					
					System.out.println("\n");
					
					service.testReportHistory(customerName);
				
					System.out.println("=========================== Welcome to AutoBuddy Service Center ===========================");
					System.out.println("");
				
					service.displayTestReport();
				
					do {
						System.out.println("Enter Test Type: ");
						int testtype = myScanner.nextInt();
						
							if(testtype == 1){
					
								service.selectTestReportType("Battery check");
								
							}else if(testtype == 2) {
								
								service.selectTestReportType("Check foot brakes");
							}else if(testtype == 3) {
								
								service.selectTestReportType("Replace oil filter");
							}else if(testtype == 4){
								
								service.selectTestReportType("Breaks");
							}else if(testtype == 5) {
							
								service.selectTestReportType("Check air conditioner");
							}else if(testtype == 6) {
								
								service.selectTestReportType("Check other important fluids");
							}else if (testtype == 7) {
							
								service.selectTestReportType("Lights");
							}else if (testtype == 8) {
								
								service.selectTestReportType("Suspension");
							}else if (testtype == 9) {
							
								service.selectTestReportType("Air filter");
							}else if(testtype == 10){
							
								service.selectTestReportType("Check windscreen wipers");
							}else if(testtype == 11) {
								
								service.selectTestReportType("Tyre tread checks");
							}else if(testtype == 12) {
								
								service.selectTestReportType("Durability testing");
							}else if(testtype == 13){
								
								service.selectTestReportType("Oil testing");
							}else if(testtype == 14) {
							
								service.selectTestReportType("Check coolant level");
							}else if(testtype == 15) {
							
								service.selectTestReportType("Brake fluid exchange");
							}else if (testtype == 16) {
								
								service.selectTestReportType("Changing spark plugs");
							}else if (testtype == 17) {
								
								service.selectTestReportType("Integration testing");
							}else if (testtype == 18) {
							
								service.selectTestReportType("Car suspension");
							}else if(testtype == 19){
								
								service.selectTestReportType("Wheel Performance");
							}else if(testtype == 20){
								
								service.selectTestReportType("Car battery");
							}
							else{
								
								System.out.println(" Please Contact our Support Service Agents for any Test Report");
							}
					
							System.out.println("\n");
							System.out.println(" Do  you want to try another Test Service..? ");
							System.out.println("   Press 1 to continue");
							System.out.println("   Press 0 to exit from AutoBuddy ServiceCenter System.");
							command = myScanner.nextInt();
					
					
					}
					while(command == 1);
					
					System.out.println("\n");
					System.out.println(" Do you want to View the Test Report? ");
					System.out.println("   1 - Yes");
					System.out.println("   0 - No");
					int ViewCommand = myScanner.nextInt();
					
					if(ViewCommand == 1) {
					
						service.viewServiceTestReport( customerName, vehicleType, vehicleNumber, technicianName, techName);
					
					}
					
					System.out.println("\n");
					System.out.println(" Do you want to print the Test Report? ");
					System.out.println("   1 - Yes");
					System.out.println("   0 - No");
					printCommand = myScanner.nextInt();
					
					if(printCommand== 1) {
						service.printTestReport(customerName, vehicleType, vehicleNumber, technicianName, techName);
						
					}
					
					service.clearData();
					
				}else if(serviceType == 2) {
					System.out.println("\n");
					System.out.println("=========================== AutoBuddy CheckList ===========================");
					System.out.println("\n");
					service.displayTestReport();
					
						
					
				}else if(serviceType == 3) {
					System.out.println("=========================== Test Report Summary ===========================");
					System.out.println("");
					service.viewServiceTestReportHistory();
					
				}else if(serviceType == 4) {
					System.out.println("\n");
					System.out.println("EXPORT -->");
					System.out.println("Enter the File Path: ");
					System.out.println("\n");
					path = myScanner.next();
					service.importToCSV(path);
					
				}
				
				else {
					System.out.println(" Provide a Valid Value to continue. ");
				}
				System.out.println("\n");
				
				System.out.println(" Do you want to continue service?");
				System.out.println("   Press 1 to continue");
				System.out.println("   Press 0 to exit from AutoBuddy ServiceCenter System.");
				continueCommand = myScanner.nextInt();
				
			
			}while(continueCommand == 1);
		
		
		myScanner.close();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		testCenterServiceActivator.context = null;
		System.out.println("");
		System.out.println("=========================== System Stopped ===========================");
		System.out.println("                             Thank You !!!                            ");
	}

}
