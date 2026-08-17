public class Main {
    public static void main(String[] args) {
        Student s = new Student("67FN", "Finn", 20, 3.0);
        Student b = new Student("69LB", "Ha", 20, 3.6);

        StudentManager manager = new StudentManager();
        manager.addStudent(s);
        manager.addStudent(b);

        System.out.println("Student Information");
        System.out.println("====================");
        System.out.println("ID: " + s.getId());
        System.out.println("Name: " + s.getName());
        System.out.println("Age: " + s.getAge());
        System.out.println("GPA: " + s.getGpa());
        s.setGpa(3.8);

        System.out.println();
        System.out.println("After update: ");
        System.out.println("GPA: " + s.getGpa());

        System.out.println("       ||AND||      ");
        System.out.println("ID: " + b.getId());
        System.out.println("Name: " + b.getName());
        System.out.println("Age: " + b.getAge());
        System.out.println("GPA: " + b.getGpa());

        System.out.println();
        manager.displayStudents();
    }
}
