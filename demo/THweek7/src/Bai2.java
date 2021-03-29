package src;

import java.util.ArrayList;
import java.util.Random;

public class Bai2 {
    // cho mảng l1, l2 có các phần tử ngẫu nhiên
    // 
    public static void main(String[] args) {
        ArrayList<Integer> l1= new ArrayList<>();
        ArrayList<Integer> l2= new ArrayList<>();

        for (int i=0; i< 10; i++) {
            Random r= new Random(); 
            l1.add(r.nextInt(50)+1);

            l2.add(r.nextInt(100)+1);
        }

        System.out.print(l1);

        System.out.println("\n");

        System.out.print(l2);

        System.out.println("\n");

        ArrayList<Integer> l3 = new ArrayList<Integer>();

        l3 =(ArrayList<Integer>) l1.clone();

        l3.retainAll(l2);
        System.out.println("l1 giao l2 = " + l3);
    }
}
