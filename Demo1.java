import java.util.*;
public class Demo1 {
    public static void main(String[] args){
        List<Integer> a=new ArrayList<>();
        List<Integer> b=new ArrayList<>();
        a.add(10);
        a.add(1,20);
        a.remove(1);
        a.addFirst(2);
        int r=a.get(1);

        a.remove(1);
        boolean r1=a.contains(10);
        System.out.println(a);
        System.out.println(r);
        System.out.println(r1);
        b.add(98);
        b.add(20);
        a.addAll(b);
        System.out.println(a);
        a.removeAll(b);
        System.out.println(a);
        Iterator i=a.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
        a.addLast(45);
        System.out.println(a);
        boolean b1=a.isEmpty();
        System.out.println(b1);
        int index=a.indexOf(45);
        System.out.println("index of 45 is "+index);
        System.out.println(a.size());

    }

}
