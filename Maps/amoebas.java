import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class amoebas {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] rc=br.readLine().split(" ");
        int r=Integer.parseInt(rc[0]);
        int c=Integer.parseInt(rc[1]);
        String line="";
        String[][] map=new String[r][c];
        for(int i=0;i<r;i++) {
            line=br.readLine();
            for(int j=0;j<c;j++) {
                map[i][j]=line.substring(j,j+1);
            }
        }
        ArrayList<Point> queue=new ArrayList<>();
        Point curr=new Point(0,0);
        Point lastS=new Point(0,0);
        int count=0;
        while(!lastS.equals(new Point(r,0))) {
        if(map[lastS.x][lastS.y].equals("#")) {
            queue.add(lastS);
            count++;
            while(!queue.isEmpty()) {
                curr=queue.remove(0);
                map[curr.x][curr.y]=".";
                if(curr.x+1<map.length) {
                    if(map[curr.x+1][curr.y].equals("#")) {
                        queue.add(new Point(curr.x+1, curr.y));
                    }
                    if(curr.y+1<map[0].length&&map[curr.x+1][curr.y+1].equals("#")) {
                        queue.add(new Point(curr.x+1, curr.y+1));
                    }
                    if(curr.y-1>-1&&map[curr.x+1][curr.y-1].equals("#")) {
                        queue.add(new Point(curr.x+1, curr.y-1));
                    }
                }
                if(curr.x-1>-1) {
                    if(map[curr.x-1][curr.y].equals("#")) {
                        queue.add(new Point(curr.x-1, curr.y));
                    }
                    if(curr.y+1<map[0].length&&map[curr.x-1][curr.y+1].equals("#")) {
                        queue.add(new Point(curr.x-1, curr.y+1));
                    }
                    if(curr.y-1>-1&&map[curr.x-1][curr.y-1].equals("#")) {
                        queue.add(new Point(curr.x-1, curr.y-1));
                    }
                }
                if(curr.y+1<map[0].length) {
                    if(map[curr.x][curr.y+1].equals("#")) {
                        queue.add(new Point(curr.x,curr.y+1));
                        //System.out.print(curr+"ligma ");
                    }
                }
                if(curr.y-1>-1) {
                    if(map[curr.x][curr.y-1].equals("#")) {
                        queue.add(new Point(curr.x,curr.y-1));
                    }
                }
        }
        }
        //System.out.println(lastS+" "+count);
        if(lastS.y==c-1) lastS=new Point(lastS.x+1,0);
        else lastS=new Point(lastS.x,lastS.y+1);
        }
        System.out.print(count);
        
        br.close();
    }
    public static class Point {
        int x,y;
        public Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
        
        public boolean equals(Point o) {
            return(o.x==x&&o.y==y);
        }
        public String toString() {
            return "("+x+", "+y+")";
        }
    }
}
