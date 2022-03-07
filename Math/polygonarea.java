import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class polygonarea {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t;
        boolean ccw=false;
        String[] line=new String[2];
        ArrayList<Point> polygon;
        while((t=Integer.parseInt(br.readLine()))!=0) {
            ccw=false;
            polygon=new ArrayList<>();
            for(int i=t;i>0;i--) {
                line=br.readLine().split(" ");
                polygon.add(new Point(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
            }
            polygon.add(polygon.get(0));
            double area=area(polygon);
            if(area<0) ccw=true;
            if(!ccw) System.out.print("CCW ");
            else System.out.print("CW ");
            area=Math.abs(area);
            System.out.printf("%.1f\n",area);
        }
        br.close();
    }
    public static double area(ArrayList<Point> polygon) {
        double area=0;
        for(int i=0;i<polygon.size()-1;i++) {
            area+=(polygon.get(i).x)*(polygon.get(i+1).y)-((polygon.get(i).y)*(polygon.get(i+1).x));
        }
        
        return area/2;
    }
}
class Point {
    int x,y;
    public Point(int x,int y) {
        this.x=x;
        this.y=y;
    }
}
