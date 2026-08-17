import java.util.Scanner;

public class student_Management_System {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        System.out.println("===========================================");
        System.out.println("   Welcome to Student Management System!   ");
        System.out.println("===========================================");
        System.out.println();

        while (true) {
            System.out.println();
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Exit");
            System.out.println();
            System.out.println("Choose an option: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Student ID: ");
                    String id = input.nextLine();

                    System.out.println("Enter student name: ");
                    String name = input.nextLine();

                    System.out.println("Enter student age: ");
                    int age = input.nextInt();

                    System.out.println("Enter student GPA: ");
                    double gpa = input.nextDouble();
                    input.nextLine();

                    Student student = new Student(id, name, age, gpa);
                    manager.addStudent(student);

                    break;

                case 2:
                    manager.displayStudents();
                    break;

                case 3:
                    System.out.println("Enter Student ID to search: ");
                    String searchId = input.nextLine();

                    Student found = manager.findStudentById(searchId);

                    if (found != null) {
                        System.out.println();
                        System.out.println("Student found!");
                        System.out.println();
                        System.out.println("ID: " + found.getId());
                        System.out.println("Name: " + found.getName());
                        System.out.println("Age: " + found.getAge());
                        System.out.println("GPA: " + found.getGpa());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}
