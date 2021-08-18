package bai1;

import java.util.Scanner;

// s = 1 + 1/2 + 1/3 + ... + 1/n
public class sum3 {
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
            sum += (float) 1 / i;
        }
        System.out.println("Result: " + sum);
    }
}
