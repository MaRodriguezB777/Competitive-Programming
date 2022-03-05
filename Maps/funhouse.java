import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String[] rc=br.readLine().split(" ");
String t=rc[0];
rc[0]=rc[1];
rc[1]=t;
int r= Integer.parseInt(rc[0]);
int c= Integer.parseInt(rc[1]);
int cases=1;
String line;
String[][] map;
while(!(rc[0]+rc[1]).equals("00")) {

map=new String[r][c];
Point pos=new Point(0,0);
int dir=0;
for(int i=0;i<r;i++) {
    line=br.readLine();
    for(int j=0;j<c;j++) {
        map[i][j]=line.substring(j,j+1);
        if(map[i][j].equals("*")) {
            pos=new Point(i,j);
            if(i==0) dir=3;
            else if(i==r-1) dir=1;
            else if(j==0) dir=0;
            else dir=2;
        }
    }
}
     while(!map[pos.x][pos.y].equals("x")) {
     pos=moveForward(dir, pos);
     if(map[pos.x][pos.y].equals("/")) { 
      dir=((dir==0 || dir==2) ? (dir+1)%4 : (dir-1)%4);
     } else if(map[pos.x][pos.y].equals("\\")) {
     dir=((dir==0 || dir==2) ? (dir+3)%4 : (dir+1)%4);
          }
          
     //System.out.println(pos);
     }
     map[pos.x][pos.y]="&";
     
     System.out.println("HOUSE "+cases++);
     for(int i=0;i<map.length;i++) {
        for(int j=0;j<map[0].length;j++) {
        System.out.print(map[i][j]);
         }
         System.out.println();
     }
     rc=br.readLine().split(" ");
     t=rc[0];
     rc[0]=rc[1];
     rc[1]=t;
     r= Integer.parseInt(rc[0]);
     c= Integer.parseInt(rc[1]);
     }
     br.close();
}
/*
Direction:
0=right
1=up
2=left
3=down
*/
public static Point moveForward(int dir, Point pos) {
     switch(dir) {
          case 0: {
               pos=new Point(pos.x, pos.y+1);
               break;
          }
          case 1: {
               pos=new Point(pos.x-1, pos.y);
               break;
          }
          case 2: {
               pos=new Point(pos.x, pos.y-1);
               break;
          }
          case 3: {
               pos=new Point(pos.x+1,pos.y);
               break;
          }
    }
    return pos;
}

public static class Point {
    int x,y;
    
    public Point(int x, int y) {
        this.x=x;
        this.y=y;
    }
    public String toString() {
        return "("+x+", "+y+")";
    }
}
}
