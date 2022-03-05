import java.util.Scanner;

public class triangle {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases=0;
        while(scan.hasNext()){
            cases++;
            int iterations=scan.nextInt();
            String str=findDigits(iterations);
            System.out.println("Case "+cases+": "+str.substring(0,str.indexOf(".")));
        }
        scan.close();
    }
    
    public static String findDigits(int power) {
        return String.valueOf((((power+1)*Math.log10(3))-((power)*Math.log10(2)))+1);
    }
    /*
    public static double findDigits(int power) {
        BigInteger threepow = new BigInteger("3");
        BigInteger twopow = new BigInteger("2");
        for(int i=2;i<power+2;i++){
            threepow=threepow.multiply(threepow);
            if(i!=power+1) twopow=twopow.multiply(twopow);
        }
        System.out.println(threepow +" "+twopow);
        return logBigInteger(threepow.divide(twopow));
    }
    */
}
