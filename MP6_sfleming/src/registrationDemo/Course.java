package registrationDemo;

class Course {
	private String department;
	private String courseName;
	private int maxClassSize;
	private int currentEnrollment;
	private Student[] roster;
	private Faculty instructor;

	public Course(String department, String courseName, int maxClassSize) {
		this.department = department;
		this.courseName = courseName;
		this.maxClassSize = maxClassSize;
		this.currentEnrollment = 0;
		this.roster = new Student[maxClassSize];
	}

	public String getDepartment() {
		return department;
	}

	public String getCourseName() {
		return courseName;
	}

	public int getMaxClassSize() {
		return maxClassSize;
	}

	public int getCurrentEnrollment() {
		return currentEnrollment;
	}

	public Faculty getInstructor() {
		return instructor;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Course))
			return false;
		Course other = (Course) obj;
		return department.equals(other.department) && courseName.equals(other.courseName)
				&& maxClassSize == other.maxClassSize;
	}

	@Override
	public String toString() {
		String instructorInfo = instructor != null ? instructor.getName() : "Not assigned";
		return "Course: " + courseName + ", Department: " + department + ", Max Size: " + maxClassSize
				+ ", Current Enrollment: " + currentEnrollment + ", Instructor: " + instructorInfo;
	}

	public void displayRoster() {
		System.out.println("Roster for " + courseName + ":");
		for (int i = 0; i < currentEnrollment; i++) {
			System.out.println(roster[i].toString());
		}
	}

	public void addStudent(Student student) {
		if (currentEnrollment >= maxClassSize) {
			System.out.println("Registration failed: Course is at maximum capacity.");
			return;
		}
		for (int i = 0; i < currentEnrollment; i++) {
			if (roster[i].equals(student)) {
				System.out.println("Registration failed: Student is already enrolled.");
				return;
			}
		}
		roster[currentEnrollment++] = student;
		System.out.println("Student " + student.getName() + " successfully registered for " + courseName);
	}

	public void assignInstructor(Faculty faculty) {
		if (!faculty.getDepartment().equals(department)) {
			System.out.println("Assignment failed: Faculty must be from the same department as the course.");
			return;
		}
		this.instructor = faculty;
		System.out.println("Instructor " + faculty.getName() + " assigned to " + courseName);
	}
}