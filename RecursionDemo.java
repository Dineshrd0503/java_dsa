public class RecursionDemo {
    public static void main(String[] args) {
        int i=1;
        print(i);
    }
    public static void print(int i) {
        if(i<=10) {
            System.out.print(i + " ");
            print(++i);
        }
    }


    
}
