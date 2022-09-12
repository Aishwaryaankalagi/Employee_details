package serviceimpl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import model.Employee;
import repository.EmployeeRepository;
import service.EmployeeService;

@SpringBootTest
class EmployeeServiceImplTest {

	@Autowired
	EmployeeService employeeService;
	
	@MockBean
	private EmployeeRepository mployeeRepository;
	
	@BeforeEach
	void setup() {
		Optional<Employee> employee = Optional.of(new Employee( "abc", "ais", "dlh"));
		Mockito.when(EmployeeRepository.findById(1)).thenReturn(Employee);
	}

	@Test
	public void testGetStudentById() {
		String student_name = "abc";
		Employee student = EmployeeService.getEmployeeById(1);
		assertEquals(Employee_firstname, Employee.getName());
	}

}