package com.cassandra.logisticSystem.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import com.cassandra.logisticSystem.data.model.Employee;
import com.cassandra.logisticSystem.data.repository.EmployeeRepository;
import com.cassandra.logisticSystem.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void testManageEmployees() {

        Employee testEmployee = new Employee();
        testEmployee.setName("JohnPaul Frankenstein");
        testEmployee.setRole("Manager");
        testEmployee.setContactInformation("08123456789");

        when(employeeRepository.save(any(Employee.class))).thenReturn(testEmployee);
        when(employeeRepository.findById(anyLong())).thenReturn(Optional.of(testEmployee));

        Employee savedEmployee = employeeService.saveOrUpdateEmployee(testEmployee);

        assertNotNull(savedEmployee);
            assertEquals("JohnPaul Frankenstein", savedEmployee.getName());
        assertEquals("Manager", savedEmployee.getRole());
        assertEquals("08123456789", savedEmployee.getContactInformation());

    }
}
