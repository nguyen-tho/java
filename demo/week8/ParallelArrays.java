import java.util.Scanner;

public class ParallelArrays
{
    private static void  getPayData(int[] hours, double[] payRates)
    {
        Scanner keyboard = new Scanner(System.in);

        for(int i = 0; i < hours.length; i++)
        {
            System.out.printf("Enter the hours worked by employee #%d ", (i+1));

            hours[i] = keyboard.nextInt();

            System.out.printf("Enter the hourly pay rate for employee #%d ", (i+1));

            payRates[i] = keyboard.nextDouble();
        }
    }

    private static void displayGrossPay (int[] hours, double[] payRates)
    {
         double grossPay;
         
         for (int i = 0; i < hours.length; i++)
         {
             grossPay =hours[i] *payRates[i];

             System.out.printf("The gross pay for employee #%d $,.2f.", (i+1), grossPay); 
         }
    }
    public static void main(String[] args)
    {
        final int NUM_EMPLOYEES = 3;
        int[] hours = new int[NUM_EMPLOYEES];
        double[] payRates = new double[NUM_EMPLOYEES];

        getPayData(hours, payRates);

        displayGrossPay(hours, payRates);
    }
}