package com.akshay;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.akshay.controller.PayrollOperationController;
import com.akshay.model.Employee;

@SpringBootApplication
@ImportResource("com/akshay/cfg/applicationContext.xml")
public class BootApp02LayaredApplication {

	public static void main(String[] args) {
		// get the IOC container obj ref
		ConfigurableApplicationContext ctx = SpringApplication.run(BootApp02LayaredApplication.class, args);
		
		try(ctx;){
			
			// get the controller class object
			PayrollOperationController controller = ctx.getBean("payroll",PayrollOperationController.class);
			
			// invoked the b.method
			
//			Employee e1 = new Employee("John",30000.0,"CLERK",10);
//			Employee e2 = new Employee("Max",30000.0,"MANAGER",20);
//			Employee e3 = new Employee("Alex",30000.0,"SALESMAN",30);
//			
//			boolean e1Result = controller.addEmployeeRecord(e1);
//			boolean e2Result = controller.addEmployeeRecord(e2);
//			boolean e3Result = controller.addEmployeeRecord(e3);
//			
//			if(e1Result && e2Result && e3Result) {
//				System.out.println("Employee record is added sucessfully");
//			}
//			else {
//				System.out.println("Employee record failed to add!!");
//			}
//			System.out.println("===================================");
			List<Employee> listEmp = controller.showAllEmployeeByDesg("clerk", "manager", "salesman");
			
			// process the result
			listEmp.forEach(System.out::println);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("something prolem has occured please again after some time!!");
		}
		
	}

}
