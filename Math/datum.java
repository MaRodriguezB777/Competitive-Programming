import java.util.Scanner;

public class datum {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        final String[] weekDay={"Wednesday","Thursday","Friday","Saturday","Sunday","Monday","Tuesday"};
        final int[] pastDay={0,31,59,90,120,151,181,212,243,273,304,334};
        System.out.println(weekDay[(scan.nextInt()+pastDay[scan.nextInt()-1])%7]);
        scan.close();
    }
}
