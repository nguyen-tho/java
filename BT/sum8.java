

import java.util.Scanner;

// s = 1/2 + 3/4 + 5/6 + ... + 2n+1/2n+2

public class sum8 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter n: ");
            n = sc.nextInt();
        } while (n < 0);
        sc.close();
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += (double) (2 * i + 1) / (2 * i + 2);
        }
        System.out.println("Result: " + sum);
    }
}
