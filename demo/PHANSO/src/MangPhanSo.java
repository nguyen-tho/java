package src;

import java.util.*;
public class MangPhanSo {
   public static void main(String [] agrs){
       List<PhanSo>  ps = new ArrayList<PhanSo>();
       
       Scanner sc = new Scanner(System.in);

       int x, y, n;

       System.out.println("Nhập số lượng phần tử: ");
       n = sc.nextInt();

       for(int i = 0; i < n ; i++)
       {
           x = sc.nextInt();
           y = sc.nextInt();
           PhanSo temp = new PhanSo(x, y);

           ps.add(i, temp);
       }
       for(PhanSo i: ps)
        System.out.print(i.toString() + " ");

       System.out.println();
    
       Comparator<? super PhanSo> c = PhanSo :: compare;

       ps.sort(c);
       for(PhanSo i: ps)
        System.out.print(i.toString() + " ");

       PhanSo target = new PhanSo(1, 3);
       int index = Collections.binarySearch(ps, target,c);
       System.out.println("Found at : " + index);

       PhanSo ps1 = new PhanSo(1, 3);
       ps.add(0, ps1);

       PhanSo ps2 = new PhanSo(1, 5);
       ps.add(ps.size(), ps2);

       PhanSo ps3 = new PhanSo(1, 6);
       ps.add(ps.size()/2, ps3);

   } 
} 