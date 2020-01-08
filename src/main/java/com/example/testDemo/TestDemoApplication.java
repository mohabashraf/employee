package com.example.testDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestDemoApplication.class, args);
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
