

import java.util.*;

// s = 1/2 + 2/3 + 3/4 + ... + n/n+1
public class sum7 {
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
            sum += (double) i / (i + 1);
        }
        System.out.println("Result: " + sum);
    }
}
