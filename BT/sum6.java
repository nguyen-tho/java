

import java.util.Scanner;
// s = 1/(1x2) + 1/(2x3) + ... + 1/[n x (n + 1)]
public class sum6 {
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
            sum += (double) 1 / (i * (i + 1));
        }
        System.out.println("Result: " + sum);
    }
}
