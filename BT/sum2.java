

import java.util.Scanner;

// s = 1^2 + 2^2 + 3^2 + ... + n^2
public class sum2 {
    public static void main(String args[]) {
        int sum = 0;
        int n;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter n: ");
            n = sc.nextInt();
        } while (n < 0);
        sc.close();
        for (int i = 0; i <= n; i++) {
            sum += i*i;
        }
        System.out.println("Result = " + sum);
    }
}
