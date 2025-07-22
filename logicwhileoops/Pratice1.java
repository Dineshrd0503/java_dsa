package logicwhileoops;

public class Pratice1 {
    static class Student{
        String name;
        int rollNo;
        int age;
    Student() {
        this.name = "aravind"
        ;
        rollNo = 0;
        age = 0;
    }
        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", rollNo=" + rollNo +
                    ", age=" + age +
                    '}';
        }
    }
    public static void main(String[] args) {
        Student student = new Student();
        student.name = "Ard";
        student.rollNo = 1;
        student.age = 20;


        System.out.println(student);
    }
}
