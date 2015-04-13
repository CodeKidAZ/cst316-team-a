package test;

import static org.junit.Assert.*;
import javafx.beans.property.StringProperty;

import org.junit.Assert;
import org.junit.Test;

import cst316.Employee;

public class EmployeeTest {

	Employee emp1 = new Employee();
	Employee emp = new Employee("Sumit",55);
	
	@Test
	public void testEmployeeStringInt() {
		
	}

	@Test
	public void testGetName() {
		assertEquals(emp.getName(),"Sumit");
		
	}

	@Test
	public void testSetName() {
		emp.setName("Samuel");
		assertEquals(emp.getName(), "Samuel");
	}

	@Test
	public void testGetNameProperty() {
		assertEquals(emp.getNameProperty().getValue(), "Sumit");
	}

	@Test
	public void testGetWage() {
		assertEquals(emp.getWage(),55);
	}

	@Test
	public void testSetWage() {
		emp.setWage(111);
		assertEquals(emp.getWage(),111);
	}

	@Test
	public void testGetWageProperty() {
		assertEquals(emp.getWageProperty().getValue().toString(),"55");
	}

}
