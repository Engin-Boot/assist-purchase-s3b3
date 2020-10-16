package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.domain.Monitor;
import com.example.demo.services.MonitorService;

@SpringBootApplication
public class CrudSpringDataJpaWithSqLiteApplication implements CommandLineRunner {
	@Autowired
	private MonitorService monitorService;

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringDataJpaWithSqLiteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Demo1();
		
	}

	private void Demo1() {
		try {
			monitorService.deleteById(11);
			System.out.println("Yasss ");	
		}catch(Exception e){
			System.out.println("Noooo ");	
		}
  
	}
//	private void Demo2() {
//	   for(Product product : productService.search(5,10)) {
//		   System.out.println("id: "+ product.getId());
//		   System.out.println("name: "+ product.getName());
//		   System.out.println("=========== ");	   
//	   }
//	}
	
	private void Demo3() {
		   Monitor product= monitorService.findById(4); 
			   System.out.println("id: "+ product.getId());
			   System.out.println("name: "+ product.getName());
			   System.out.println("status:"+product.isWireless());	
			   System.out.println("status:"+product.getPrice());	
		   }
//	private void Demo5() {
//		  
//		 productService.
//			   System.out.println("status");	
//			   System.out.println("price");	
//		   }
}
//	private void Demo4() {
//		   Product product= new Product(); 
//			product.setName("IntelliVue MX100");   
//			product.setPrice(6.3);
//			product.setStatus(true);
//			product= productService.save(product);
//			  System.out.println("id: "+ product.getId());
//		   }






