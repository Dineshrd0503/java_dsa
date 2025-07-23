package logicwhileoops.polymorphismproject;

public class Dog extends Cat{
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }

    @Override
    public void eat() {
        System.out.println("Dog eats bones");
    }

    @Override
    public void sleep() {
        System.out.println("Dog sleeps in kennel");
    }
}
