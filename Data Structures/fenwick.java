import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class fenwick {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] line=br.readLine().split(" ");
        BenwickBee arr=new BenwickBee(Integer.parseInt(line[0]));
        int opps=Integer.parseInt(line[1]);
       
        while(opps --> 0) {
            line=br.readLine().split(" ");
            if(line[0].equals("+"))
                arr.add(Integer.parseInt(line[1])+1, Integer.parseInt(line[2]));
            else
                bw.write(arr.sum(Integer.parseInt(line[1]))+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static class BenwickBee {
        long[] fen;
        int size;
        
        public BenwickBee(int size) {
            this.size=size+2;
            fen=new long[size+2];
        }
        
        public void add(int index, int delta) {
            while(index<size) {
            fen[index]+=delta;
            index+=Integer.lowestOneBit(index);
            }
//            System.out.print("              "+fen[index]);
        }
        
        public long sum(int index) {
            long sum=0;
            while(index>0) {
                sum+=fen[index];
                index-=Integer.lowestOneBit(index);
            }
            return sum;
        }
    }
}
