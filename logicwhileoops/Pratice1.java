package logicwhileoops;

public class Pratice1 {
    static class Student {
        String name;
        int rollNo;
        int age;

        Student() {
            this.name = "Unknown";
            this.rollNo = 0;
            this.age = 0;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + this.name + '\'' +
                    ", rollNo=" + rollNo +
                    ", age=" + age +
                    '}';
        }

        public static void greet() {
            System.out.println("Hello, welcome to the Student class!");
        }

        public static void main(String[] args) {
            Student student = new Student();
            student.name = "Ard";
            student.rollNo = 1;
            student.age = 20;


            System.out.println(student);
            greet();
        }
    }
}
