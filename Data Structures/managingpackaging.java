import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;


public class managingpackaging {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        String[] line;
        ArrayList<Node> packages;
        String finalS;
        String[] temp;
        PriorityQueue<Node> ds;
        boolean ordered=true;
        while(t!=0) {
            line=new String[t];
            while(t-->0) {
                line[t]=br.readLine();
            }
            packages=new ArrayList<>();
            finalS="";
            for(int i=0;i<line.length;i++) {
            temp=line[i].split(" ");
            packages.add(new Node(temp[0]));
            if(temp.length>1) {
                for(int j=1;j<temp.length;j++) {
                    packages.get(i).addD(new Node(temp[j]));
                }
            }
            }
            while(!packages.isEmpty()){
                ds=new PriorityQueue<>();
                for(Node n: packages) {
                    if(n.dependencies.isEmpty()){
                            ds.add(n);
                    }
                }
                finalS+=ds.peek()+"\n";
                if(ds.size()!=0){
                    for(Node n: packages) {
                        n.dependencies.remove(ds.peek().toString());
                    }
                packages.remove(ds.poll());
                } else {
                    System.out.print("cannot be ordered");
                    ordered=false;
                    break;
                }
            }
            if(ordered) System.out.print(finalS.substring(0,finalS.length()-1));
            t=Integer.parseInt(br.readLine());
            if(t!=0){
                System.out.println("\n");
            } else break;
            ordered=true;
        }
        br.close();
    }
    
    public static void print(ArrayList<Node> packages) {
        for(Node n: packages) {
            System.out.println(n.toString());
        }
    }
    
    public static class Node implements Comparable<Node> {
        String node;
        HashSet<String> dependencies;

        public Node(String node){
            this.node=node;
            dependencies=new HashSet<>();
        }
        
        public void addD(Node otherNode) {
            dependencies.add(otherNode.toString());
        }
        
        public String toString() {
            return node;
        }

        @Override
        public int compareTo(Node arg0) {
            return node.compareTo(arg0.node);
        }
        
        public boolean equals(Object o) {
            if(o instanceof Node) {
                return node.compareTo(((Node)(o)).node)==0;
            }
            return false;
        }
    }
}
