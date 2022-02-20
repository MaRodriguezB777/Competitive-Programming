import java.util.Scanner;
// import java.util
public class boundingrobots {
    public static void main(String args[]) {
        Scanner scan=new Scanner(System.in);
        String[] line=scan.nextLine().split(" ");
        int r, c, t;
        int pr, pc;
        int Repr, Repc;
        int temp;
        while(!(line[0].equals("0")&&line[1].equals("0"))) {
            
            c=Integer.parseInt(line[0]);
            r=Integer.parseInt(line[1]);
            pr=0;
            pc=0;
            Repr=pr;
            Repc=pc;
            t=scan.nextInt();
            scan.nextLine();
            while(t-->0) {
                line=scan.nextLine().split(" ");
                temp=Integer.parseInt(line[1]);
                
                switch(line[0]) {
                    case "u": {
                        pr+=temp;
                        if(Repr+temp<r) Repr+=temp;
                        else Repr=r-1;
                        break;
                    }
                    case "d": {
                        pr-=temp;
                        if(Repr-temp>-1) Repr-=temp;
                        else Repr=0;
                        break;
                    }
                    case "l": {
                        pc-=temp;
                        if(Repc-temp>-1) Repc-=temp;
                        else Repc=0;
                        break;
                    }
                    case "r": {
                        pc+=temp;
                        if(Repc+temp<c) Repc+=temp;
                        else Repc=c-1;
                        break;
                    }
                }
            }
            System.out.println("Robot thinks "+pc+" "+pr);
            System.out.println("Actually at "+Repc+" "+Repr+"\n");
            line=scan.nextLine().split(" ");
        }
        scan.close();
    }
}
