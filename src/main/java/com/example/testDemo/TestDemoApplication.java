package com.example.testDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class TestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestDemoApplication.class, args);
	}

	@Configuration
	public class Myconfig{

		@Bean
		EmployeeFetcher employeeFetcher(){
			return  new EmployeeFetcher();
		}

		@Bean
		EmployeePrinter employeePrinter(){
			return new EmployeePrinter();
		}

	}

	class EmployeePrinter{

		@Autowired
		private EmployeeFetcher employeeFetcher;

		String print(){
			return employeeFetcher.fetchEmployees().
					stream().map(employee -> employee.name).
					collect(Collectors.joining("/n"));
		}
	}

	class EmployeeFetcher{
		List<Employee> fetchEmployees(){
			return Arrays.asList(
					new Employee("Mohab", "Team_Lead"),
					new Employee("Nazmy", "Front_end"));
		}

	}

	@Data
	@AllArgsConstructor
	class Employee {
		private String name;
		private String position;
	}
}
