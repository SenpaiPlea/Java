package registrationDemo;

class Student extends Person {
	private String major;
	private double gpa;

	public Student(String name, int age, String email, String major, double gpa) {
		super(name, age, email);
		this.major = major;
		this.gpa = gpa;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		return super.equals(obj) && major.equals(other.major) && gpa == other.gpa;
	}

	@Override
	public String toString() {
		return "Student: " + getName() + ", Age: " + getAge() + ", Email: " + getEmail() + ", Major: " + major
				+ ", GPA: " + gpa;
	}

	public void registerForCourse(Course course) {
		course.addStudent(this);
	}
}