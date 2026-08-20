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

            int choice;
            while (true) {
                if (input.hasNextInt()) {
                    choice = input.nextInt();
                    if (choice >= 1 && choice <= 6) {
                        break;
                    } else {
                        System.out.println("Please choose between 1 and 6");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a number.");
                    input.nextLine();
                }
            }
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
                    int age;
                    while (true) {
                        if (input.hasNextInt()) {
                            age = input.nextInt();
                            if (age > 0) {
                                break;
                            } else {
                                System.out.println("Age must be greater than 0!");
                            }
                        } else {
                            System.out.println("Invalid input! Please enter a number.");
                            input.nextLine();
                        }
                    }

                    System.out.println("Enter student GPA: ");
                    double gpa;
                    while (true) {
                        if (input.hasNextDouble()) {
                            gpa = input.nextDouble();
                            if (gpa >= 0 && gpa <= 4.0) {
                                break;
                            } else {
                                System.out.println("GPA must be between 0 and 4.0");
                            }
                        } else {
                            System.out.println("Invalid input! Please enter a number.");
                            input.nextLine();
                        }
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
                        int newAge;
                        while (true) {
                            if (input.hasNextInt()) {
                                newAge = input.nextInt();
                                if (newAge > 0) {
                                    break;
                                } else {
                                    System.out.println("Age must be greater than 0!");
                                }
                            } else {
                                System.out.println("Invalid input! Please enter a number.");
                                input.nextLine();
                            }
                        }
                        foundStudent.setAge(newAge);

                        System.out.println("Enter new GPA: ");
                        double newGpa;
                        while (true) {
                            if (input.hasNextDouble()) {
                                newGpa = input.nextDouble();
                                if (newGpa >= 0 && newGpa <= 4.0) {
                                    break;
                                } else {
                                    System.out.println("GPA must be between 0 and 4.0");
                                }
                            } else {
                                System.out.println("Invalid input! Please enter a number.");
                                input.nextLine();
                            }
                        }
                        input.nextLine();
                        foundStudent.setGpa(newGpa);
                        System.out.println("Student updated successfully.");

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
