package logicwhileoops.polymorphismproject;

public class Main {
    public static void main(String[] args) {
        // Create instances of the classes
        System.out.println("first calling Cta class methods");
        Cat c=new Cat();
        c.eat();
        c.sleep();
        c.sound();
        System.out.println("now perfoeming dynamic method dsipatch");
        Animal animal=new Dog();
         animal.sleep();
        animal.eat();
        animal.sound();

    }
}
