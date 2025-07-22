package logicwhileoops;

public class MethodOverloading {
    public static void main(String[] args) {
        System.out.println(add(10,2));
        System.out.println(add(10.1,2.3,3.8));
    }
    public static int add(int a, int b) {
        return a + b;
    }
    public static double add(double a, double b, double c) {
        return a + b + c;
    }
}
