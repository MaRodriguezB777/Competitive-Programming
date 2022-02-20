import java.util.Scanner;

public class listgame {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int count=0;
        int num=scan.nextInt();
        int t=num;
        for(int i=2;i<=Math.sqrt(num)+1;i++) {
            while(t%i==0){
                count++;
                t/=i;
            }
        }
        if(count==0) System.out.println(1);
        else if(t!=1) {
            System.out.println(count+1);
        } else System.out.println(count);

        
        scan.close();
    }
}
