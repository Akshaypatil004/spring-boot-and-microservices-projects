package com.akshay;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.akshay.controller.PayrollOperationController;
import com.akshay.model.Employee;

@SpringBootApplication
public class BootApp02LayaredApplication {

	public static void main(String[] args) {
		// get the IOC container obj ref
		ConfigurableApplicationContext ctx = SpringApplication.run(BootApp02LayaredApplication.class, args);
		
		try(ctx;){
			
			// get the controller class object
			PayrollOperationController controller = ctx.getBean("payroll",PayrollOperationController.class);
			
			// invoked the b.method
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
