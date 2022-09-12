package controller;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.PageAttributes.MediaType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import model.Employee;
import service.EmployeeService;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
	

		@Autowired
		private MockMvc mockMvc;

		@MockBean
		private EmployeeService employeeService;

		private Employee employee;

		@BeforeEach
		void setup() {
			employee = new Employee("aishwarya","ankalagi","aishwarya@gmail.com");
		}

		@Test
		void testSaveEmployeet() throws Exception {
			Employee Employee = new Employee("aishwarya","ankalagi","aishwarya@gmail.com");
			Mockito.when(employeeService.saveEmployee(Employee)).thenReturn(employee);
			mockMvc.perform(MockMvcRequestBuilders.post("/employee/")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\r\n" + 
							"  \"id\": 1,\r\n" + 
							"  \"firstname\": \"aishwarya\",\r\n" + 
							"  \"firstname\": \"ankalagi\",\r\n" + 
							"  \"email\": \"aishwarya@gmai.com\"\r\n" + 
							"}"))
					.andExpect(MockMvcResultMatchers.status().isOk());
		}

	}