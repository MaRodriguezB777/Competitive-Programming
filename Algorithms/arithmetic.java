import java.util.Scanner;
import java.math.BigInteger;

public class arithmetic {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        
        System.out.println(new BigInteger(scan.nextLine(), 8).toString(16).toUpperCase());
        scan.close();
    }
}
