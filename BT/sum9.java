

import java.util.*;

// t(n) = 1 x 2 x 3 x ... x n
public class sum9 {
    public static void main(String args[]) {
        int n;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter n: ");
            n = sc.nextInt();
        } while (n < 0);
        sc.close();
        int t = 1;
        if (n == 0) {
            t = 0;
        } else {
            for (int i = 1; i <= n; i++) {
                t *= i;
            }
        }
        System.out.println("Result: " + t);
    }
}
