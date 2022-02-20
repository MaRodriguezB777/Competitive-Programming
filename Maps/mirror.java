import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class mirror {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int cases=Integer.parseInt(br.readLine()),r,c;
        char[] temp,map[];
        String[] line;
        int n=1;
        while(cases-->0) {
            line=br.readLine().split(" ");
            r=Integer.parseInt(line[0]);
            c=Integer.parseInt(line[1]);
            map=new char[r][c];
            for(int i=0;i<r;i++){
                temp=br.readLine().toCharArray();
                for(int j=0;j<c;j++){
                    map[r-i-1][c-j-1]=temp[j];
                }
            }
            
            System.out.println("Test "+n++);
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
        
        br.close();
    }
}
