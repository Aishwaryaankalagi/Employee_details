package repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import model.Employee;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private TestEmployeeManager entityManager;

	@BeforeEach
	void setup() {
		Employee employeeEntity = new Employee( "aishwarya","ankalagi", "aishwarya@gmai.com");
		entityManager.persist(Employee);
	}

	@Test
	public void findByEmployeeId() {
		Employee employee = EmployeeRepository.findAll(1).get();
		assertEquals("aishwarya",Employee.getFirstName());
	}

}