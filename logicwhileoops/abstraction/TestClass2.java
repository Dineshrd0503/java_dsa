package logicwhileoops.abstraction;

public abstract class TestClass2 extends TestClass1 {
    // Abstract method
    @Override
    public void display(){
        System.out.println("This is an abstract method in TestClass2");
    }

    // Concrete method
    public abstract void show();
}
