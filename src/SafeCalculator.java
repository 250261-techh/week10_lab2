import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class SafeCalculator{
    public static void main(String[] args){
        int a,b;
        String a1,b1;

        while (true){
            System.out.print("Enter the first number(or exit): ");
            Scanner in1 = new Scanner(System.in);
            a1=in1.next();
            if (Objects.equals(a1, "exit")){
                break;
            }
            a= Integer.parseInt(a1);

            System.out.print("Enter the second number(or exit): ");
            Scanner in2 = new Scanner(System.in);
            b1=in2.next();
            if (Objects.equals(b1, "exit")){
                break;
            }
            b= Integer.parseInt(b1);


            try{
                int r=a/b;
                System.out.println(r);
            } catch (ArithmeticException e){
                System.out.println("You cannot divide by zero");
            } catch (NumberFormatException e){
                System.out.println("Try again with integers");
            }


        }


    }



}