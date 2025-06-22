package employee;

import java.time.LocalDate;

public class Employee {

	private String name;
	private LocalDate hiredDate;
	
	public Employee(String name, LocalDate hiredDate) {
		this.name = name;
		this.hiredDate = hiredDate;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(LocalDate hiredDate) {
		this.hiredDate = hiredDate;
	}



	@Override
	public String toString() {
		return "Employee [name=" + name + ", hiredDate=" + hiredDate + "]";
	}
	
	
	
	
	
}
