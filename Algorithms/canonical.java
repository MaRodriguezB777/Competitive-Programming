import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class canonical {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] coins=new int[Integer.parseInt(br.readLine())];
        String[] line=br.readLine().split(" ");
        for(int i=0;i<coins.length;i++) {
            coins[i]=Integer.parseInt(line[i]);
        }
        Arrays.sort(coins);
        int[] table=new int[coins[coins.length-1]+coins[coins.length-2]];
        table[0]=0;
        int l=table.length;
        for(int i=1;i<l;i++) {
            table[i]=Integer.MAX_VALUE;
        }
        int total, coinCount=0;
        boolean isCannonical=true;
        for(int i=1;i<l;i++) {
            for(int j=0;j< coins.length;j++) {
                if(coins[j]<=i) {
                    int sub_res=table[i-coins[j]];
                    if(sub_res != Integer.MAX_VALUE && sub_res+1 < table[i]) {
                        table[i]=sub_res+1;
                    }
                } else break;
            }
            total=i;
            coinCount=0;
            int temp;
            for(int j=coins.length-1;j>-1;j--) {
                if(total==0) break;
                if(coins[j]<=total) {
                temp=total;
                total%=coins[j];                            
                coinCount+=temp/coins[j];
                }
            }
            if(table[i]!=coinCount) {
                isCannonical=false;
                break;
            }
        }
        if(isCannonical)
        System.out.println("canonical");
        else System.out.println("non-canonical");
        
        
        
    /*  for(int i=0;i<l;i++) {
            System.out.println(table[i]+" "+table1[i]);
        }
    */  br.close();
    }
}
