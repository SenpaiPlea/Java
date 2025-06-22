package employee;

import java.time.LocalDate;

public class SalaryEmployee extends Employee {

	private double salary;
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	
	public SalaryEmployee(String name, LocalDate hiredDate,
			int salary) {
		super(name, hiredDate);
		this.salary = salary;
		
	}
	
	public SalaryEmployee(String name, int salary) {
		this(name, LocalDate.now(), salary);
	}
	
	public String toString() {
		return super.toString() + " Salary: " + salary;
		
	}

	void displayPay() {
		System.out.println(" Total: " + salary / 12);
	}
	
	
	
	
}
