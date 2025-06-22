package employee;

import java.time.LocalDate;

public class EmployeeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee employee = new Employee("Sen", LocalDate.now());
		System.out.println(employee);
		
		HourlyEmployee hourlyE = new HourlyEmployee("Pai", LocalDate.now(), 1, 20);
				System.out.print(hourlyE);
				hourlyE.displayPay();
				
		SalaryEmployee salaryE = new SalaryEmployee("Plea", LocalDate.now(), 12_000);
			System.out.print(salaryE);
			salaryE.displayPay();
	}

}
