package comparableInterface;

public class Student implements Comparable<Student> {
	private static int nextID = 1;
	private int studentID;
	private String name;
	private double gpa;
	

	public Student(String name, double gpa) {
		this.studentID = nextID++;
		this.name = name;
		this.gpa = gpa;
	}
	
	
	public int getStudentID() {
		return studentID;
	}


	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getGpa() {
		return gpa;
	}


	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
    public String toString() {
        return "ID: " + studentID + ", Name: " + name + ", GPA: " + gpa;
	}
	
	/*Sorting by ID*/
//    @Override
//    public int compareTo(Student other) {
//    	// 
//    	return Integer.compare(this.studentID, other.studentID);
//    	}
	
	/*Sorting by name*/
	@Override
	public int compareTo(Student other) {
	    return this.name.compareTo(other.name);
	}
        
	public static void main(String[] args) {
		// 
		 Student[] students = {
		            new Student("JAlice", 3.5),
		            new Student("Bob", 3.8),
		            new Student("Charlie", 2.9),
		            new Student("Diana", 3.7)
		        };

		        System.out.println("Before sorting:");
		        for (Student s : students) {
		            System.out.println(s);
		        }

		        MySelectionSort.sort(students);

		        System.out.println("\nAfter sorting (by studentID):");
		        for (Student s : students) {
		            System.out.println(s);
		        }
		    }
		}





