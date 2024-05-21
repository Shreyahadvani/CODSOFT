import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.*;
import java.io.Serializable;
class Student implements Serializable
{
	private String name;
	private int rollNumber;
	private String grade;

	public Student(String name,int rollNumber,String grade)
	{
		this.name=name;
		this.rollNumber=rollNumber;
		this.grade=grade;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public int getRollNumber()
	{
		return rollNumber;
	}
	public void setRollNumber(int rollNumber)
	{
		this.rollNumber=rollNumber;
	}
	public String getGrade()
	{
		return grade;
	}
	public void setGrade(String grade)
	{
		this.grade=grade;
	}
	public String toString()
	{
		return "Student's name: "+ name + ", Student's rollNumber: " + rollNumber + ", Student's grade: " + grade; 
	}
}
class StudentManagementSystem
{
	private List<Student> students;
    
	public StudentManagementSystem()
	{
		this.students = new ArrayList<>();
    }

	public void addStudent(Student student)
	{
		students.add(student);
	}

	public void removeStudent(int rollNumber)
	{
		for(Student student : students)
		{
			if(student.getRollNumber() == rollNumber)
			{
				students.remove(student);
				break;
			}
		}
	}
	public Student searchStudent(int rollNumber)
	{
		for(Student student : students)
		{
			if(student.getRollNumber()==rollNumber)
			{
				return student;
			}
		}
	    return null;
	}
	public void displayAllStudents()
	{
		for(Student student : students)
		{
			System.out.println(student);
		}
	}	
	public void saveStudentsToFile(String fileName)
	{
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName)))
		{
			os.writeObject(students);
			System.out.println("Saved Done...");
		}
		catch(IOException e)
		{
			System.err.println("Error save students:" + e.getMessage());
		}
	}
	public void loadStudentsFromFile(String fileName)
	{
		try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName)))
		{
			students=(List<Student>)is.readObject();
			System.out.println("Loaded Done...");
		}
		catch(IOException|ClassNotFoundException e)
		{
			System.err.println("Error loading students: "+e.getMessage());
		}
	}
}
public class task3
{
	public static void main(String[] args) 
	{
		StudentManagementSystem sms = new StudentManagementSystem();
		Scanner scanner = new Scanner(System.in);

		while(true)
		{
			System.out.println("\n 1. Add a new Student");
			System.out.println("2. Remove a Student");
			System.out.println("3. Search a Student");
			System.out.println("4.Display All the Students");
			System.out.println("5.Save students into file");
			System.out.println("6.Load students from file");
			System.out.println("7.Exit");
			System.out.print("Enter your choice:  ");

			int choice = scanner.nextInt();
			scanner.nextLine();

            switch(choice)
            {
			  case 1:
				System.out.print("Enter student name:");
				String name = scanner.nextLine();
				System.out.print("Enter student roll number: ");
				int rollNumber = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter student grade: ");
				String grade = scanner.nextLine();
				sms.addStudent(new Student(name, rollNumber, grade));
				break;

			  case 2:
			     System.out.print("Enter roll number of student to remove it: ");
			     int rollToRemove=scanner.nextInt();
			     sms.removeStudent(rollToRemove);
			     System.out.println("Remove sucessfully..");
			     break;

			  case 3:
			     System.out.println("Enter roll number of student to Search it: ");
			     int rollToSearch=scanner.nextInt();
			     scanner.nextLine();
			     Student foundStudent=sms.searchStudent(rollToSearch);

			     if(foundStudent != null)
			     {
			     	System.out.println("student found:" + foundStudent);
			     }
			     else
			     {
			     	System.out.println("student not found.");
			     }
			     break;

			  case 4:
			     sms.displayAllStudents();
			     break;

			  case 5:
			      System.out.print("Enter file name to save students: ");
			      String saveFileName=scanner.nextLine();
			      sms.saveStudentsToFile(saveFileName);
			      break;

			  case 6:
			      System.out.println("Enter file name to load students: ");
			      String loadFileName=scanner.nextLine();
			      sms.loadStudentsFromFile(loadFileName);
			      break;

			  case 7:
			      System.out.println("Exiting...");
			      System.exit(0);

			  default:
			      System.out.println("Invalid choice.");                 	
			}
		}
	}
}			