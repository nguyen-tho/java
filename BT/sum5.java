

import java.util.*;

// s = 1 + 1/3 + 1/5 + ... + 1/(2n + 1)

public class sum5 {
    public static void main(String args[]) {
        int n;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter n: ");
            n = sc.nextInt();
        } while (n < 0);
        sc.close();
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += (double) 1 / (2*i + 1);
        }
        System.out.println("Result: " + sum);
    }
}
