import java.util.Scanner;

public class character {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int a=scan.nextInt();
        System.out.println((int)(Math.pow(2, a)-(a+1)));
        scan.close();
    }
  
}
