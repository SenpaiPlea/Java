package employee;

import java.time.LocalDate;

public class HourlyEmployee extends Employee {

	private int hoursWorked;
	private int hourlyRate;
	
	public HourlyEmployee(String name, LocalDate hiredDate,
			int hoursWorked, int hourlyRate) {
		super(name, hiredDate);
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
		
	}
	
	
	public String toString() {
		return super.toString() + "Hours worked: " + hoursWorked + " Hourly rate: " + hourlyRate + " ";
	}
	
	
	
	public int getHoursWorked() {
		return hoursWorked;
	}
	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}


	public int getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}


	void displayPay() {
		System.out.println("Total pay: " + hourlyRate * hoursWorked);
	}
	
	
	
	
}
