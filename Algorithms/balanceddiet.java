import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class balanceddiet {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] line=br.readLine().split(" ");
        while(!line[0].equals("0")) {
            int[] foods=new int[Integer.parseInt(line[0])];
            int total=0;
            for(int i=0;i<foods.length;i++) {
                foods[i]=Integer.parseInt(line[i+1]);
                total+=foods[i];
            }
            int secondM=knapSack((total%2==0) ? total/2 : total/2, foods, foods, foods.length);
            System.out.println((total-secondM) + " " + secondM);
            line=br.readLine().split(" ");
        }
        br.close();
    }
    // A utility function that returns maximum of two integers 
    static int max(int a, int b) { return (a > b)? a : b; } 
       
   // Returns the maximum value that can be put in a knapsack of capacity W 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         int i, w; 
     int K[][] = new int[n+1][W+1]; 
       
     // Build table K[][] in bottom up manner 
     for (i = 0; i <= n; i++) 
     { 
         for (w = 0; w <= W; w++) 
         { 
             if (i==0 || w==0) 
                  K[i][w] = 0; 
             else if (wt[i-1] <= w) 
                   K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]); 
             else
                   K[i][w] = K[i-1][w]; 
         } 
      } 
       
      return K[n][W]; 
    }
}
