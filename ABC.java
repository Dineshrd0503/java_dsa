public interface  ABC {
    abstract void show();
    abstract void display();
    abstract void print();


}

class A implements ABC {
    public void show(){
        System.out.println("in shoq mthos");
    }

    @Override
    public void display() {
        System.out.println("in display method");
    }

    @Override
    public void print() {
        System.out.println("in print method");

    }

    public static void main(String[] args) {
        A a = new A();
        a.show();
        a.display();
        a.print();

    }


}

