
import java.util.Scanner;

// s = 1 + 2 + 3 + ... + n
public class sum1 {
    public static void main(String args[]) {
        int n;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter n: ");
            n = sc.nextInt();
            sc.close();
        } while (n < 0);
        int s = 0;
        for (int i = 1; i <= n; i++) {
            s += i;
        }
        System.out.println("Result = " + s);
    }
}
