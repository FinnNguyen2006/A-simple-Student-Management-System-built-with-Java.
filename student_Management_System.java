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
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println();
            System.out.println("Choose an option: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Student ID: ");
                    String id = input.nextLine();

                    Student existing = manager.findStudentById(id);
                    if (existing != null) {
                        System.out.println("Student ID already exists!");
                        break;
                    }
                    System.out.println("Enter student name: ");
                    String name = input.nextLine();

                    System.out.println("Enter student age: ");
                    int age = input.nextInt();
                    while (age <= 0) {
                        System.out.println("Invalid age! Please enter again: ");
                        age = input.nextInt();
                    }
                    System.out.println("Enter student GPA: ");
                    double gpa = input.nextDouble();

                    while (gpa < 0 || gpa > 4.0) {
                        System.out.println("Invalid GPA! Please enter again: ");
                        gpa = input.nextDouble();
                    }
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
                    System.out.println("Enter Student ID to update: ");
                    String updateId = input.nextLine();

                    Student foundStudent = manager.findStudentById(updateId);

                    if (foundStudent != null) {
                        System.out.println("Enter new name: ");
                        String newName = input.nextLine();
                        foundStudent.setName(newName);
                        System.out.println("Enter new age: ");
                        int newAge = input.nextInt();
                        foundStudent.setAge(newAge);
                        System.out.println("Enter new GPA: ");
                        double newGpa = input.nextDouble();
                        input.nextLine();
                        foundStudent.setGpa(newGpa);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 5:
                    System.out.println("Enter Student ID to delete: ");
                    String deleteId = input.nextLine();
                    boolean deleted = manager.deleteStudentById(deleteId);
                    if (deleted) {
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}
