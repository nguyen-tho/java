

import java.util.*;

// s = 1/2 + 1/4 + ... + 1/2n
public class sum4 {
    public static void main(String args[]) {
        int n;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter n: ");
            n = sc.nextInt();
        } while (n < 0);
        sc.close();
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (double) 1 / (2*i);
        }
        System.out.println("Result: " + sum);
    }
}
