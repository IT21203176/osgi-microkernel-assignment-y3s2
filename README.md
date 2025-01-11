# AutoBuddy: Vehicle Services Management System 🚗🔧  
**Microkernel Architecture – SOFTWARE ARCHITECTURE (SE3030)**  

## System Flowchart
![Picture1](https://github.com/user-attachments/assets/92ea0eaf-116a-4063-b0ca-d1f05098f3e5)

## Project Description  
**AutoBuddy** is a vehicle service management platform built around the **OSGi framework**, following the microkernel architecture pattern. The system integrates four distinct producer-consumer scenarios:  

1. **Administrative Service**:  
   - Customer registration and technician hiring.  
   - Transactional calculations for service management.  

2. **Test Center Service**:  
   - Conducts vehicle tests as requested by customers.  
   - Compiles detailed reports and maintains test histories.  

3. **Inventory Service**:  
   - Enhances vehicle functionality by adding spare parts.  

4. **Mechanical Service**:  
   - Oversees vehicle repairs and maintenance, tailored to customer needs.  

After the service process, customers can complete payments and receive detailed, printable receipts.  

---

## Individual Contribution: Test Center Service  
This component is implemented using the **OSGi framework** to enable a service-oriented architecture. It is divided into two main components:  

### 1. **TestCenterServicePublisher**  
![Picture2](https://github.com/user-attachments/assets/e453e34b-74af-40d4-add9-c7950bc6e816)

- **Purpose**: Publishes services for vehicle testing.  
- **Features**:  
  - Displaying and selecting test reports.  
  - Managing report history.  
  - Printing test reports and exporting data to CSV.  
- **Implementation**:  
  - `testCenterServiceImpl`: Handles core functionalities using `ArrayLists`.  
  - `testCenterServiceActivator`: Initializes the bundle context and registers services.  

### 2. **TestCenterServiceSubscriber**  
![Picture3](https://github.com/user-attachments/assets/43f1af29-50ff-4265-8f34-fc66ef47ca12)

- **Purpose**: Acts as the client-side interface to access published services.  
- **Features**:  
  - Vehicle testing and checklist viewing.  
  - Retrieving report history.  
  - Exporting data in CSV format.  
- **Implementation**:  
  - `testCenterServiceActivator`: Establishes communication with the publisher to access services.  

---

## Manifest Implementation  
### Components:  
- **TestCenterServicePublisher**  
- **TestCenterServiceSubscriber**  

These components are deployed and executed in the **OSGi framework** using bundle commands.  
![Picture4](https://github.com/user-attachments/assets/7bc82da6-bab7-40c4-9799-84d21d33f4e2)
![Picture5](https://github.com/user-attachments/assets/0a7d0312-2248-4175-8b4a-7d05870c9dc9)

**Sample screenshots of its behavior & outputs**
![Picture6](https://github.com/user-attachments/assets/c12f0330-a9ec-4b50-a7e0-a43931d7cde4)

![Picture7](https://github.com/user-attachments/assets/afa86db7-70d0-4597-8846-84d59155013d)

![Picture8](https://github.com/user-attachments/assets/e42b8a4c-9bcb-4cd9-b84e-7d580e617d5f)

![Picture9](https://github.com/user-attachments/assets/b8629ba2-b839-46b8-a8cf-0fbdfa8fee97)

![Picture10](https://github.com/user-attachments/assets/feb444ad-df8d-42a4-bb4c-aaf86561c950)

![Picture11](https://github.com/user-attachments/assets/838af33d-93c1-49df-9da1-ae2c91644d6d)

---

## Commands for Bundle Installation & Execution  
1. **Install Publisher Bundle**:  
   ```bash
   install file:/path/to/TestCenterServicePublisher.jar

2. **Install Subscriber Bundle**:
   ```bash
   install file:/path/to/TestCenterServiceSubscriber.jar

3. **Start Bundles**:
   ```bash
   start [bundle_id]

## Key Features
- OSGi Framework Integration: Enables modular and dynamic service deployment.
- Microkernel Architecture: Provides a scalable and extensible structure for producer-consumer scenarios.
- Service-Oriented Design: Facilitates seamless communication between publisher and subscriber components.
