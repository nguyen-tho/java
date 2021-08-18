

import java.util.Scanner;

// T(x, n) = x^n;
public class sum10 {
    public static void main(String args[]) {
        int x, n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x: ");
        x = sc.nextInt();
        System.out.println();
        System.out.print("Enter n: ");
        n = sc.nextInt();
        System.out.println();
        sc.close();
        int t = 1;
        for (int i = 1; i <= n; i++) {
            t *= x;
        }
        System.out.println("Result: " + t);
    }
}
