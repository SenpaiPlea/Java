package registrationDemo;

class Faculty extends Person {
	private String department;
	private String office;

	public Faculty(String name, int age, String email, String department, String office) {
		super(name, age, email);
		this.department = department;
		this.office = office;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Faculty))
			return false;
		Faculty other = (Faculty) obj;
		return super.equals(obj) && department.equals(other.department) && office.equals(other.office);
	}

	@Override
	public String toString() {
		return "Faculty: " + getName() + ", Age: " + getAge() + ", Email: " + getEmail() + ", Department: " + department
				+ ", Office: " + office;
	}
}