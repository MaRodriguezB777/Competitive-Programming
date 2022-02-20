import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class classy {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int cases=Integer.parseInt(br.readLine());
        int t;
        String[] line;
        Person[] people;
        while(cases-->0) {
            t=Integer.parseInt(br.readLine());
            people=new Person[t];

            while(t-->0) {
                line=br.readLine().split(": ");
                people[t]=new Person(line[1].substring(0, line[1].indexOf(" ")).split("-"),line[0]);
            }
            Arrays.sort(people);
//            System.out.println("\n");
            if(people.length>0)
                for(int i=people.length-1;i>-1;i--)
                    System.out.println(people[i]);
            
            System.out.println("==============================");
        }
        br.close();
    }

    public static class Person implements Comparable<Person> {
        String[] Class;
        String name;

        // contains classes
        String temp, otemp;
        // temp-otemp
        int comp;

        public Person(String[] _Class, String name) {
            Class=_Class;
            this.name=name;
        }

        public int compareTo(Person o) {
            for(int i=1;i<=Math.max(Class.length, o.Class.length);i++) {
                if(i>Class.length) temp="middle";
                else temp=Class[Class.length-i];
                if(i>o.Class.length) otemp="middle";
                else otemp=o.Class[o.Class.length-i];
                comp=temp.substring(0,1).compareTo(otemp.substring(0,1));
//                System.out.println(temp+" "+otemp);
                if(comp!=0) return (comp);
            }
            return(o.name.compareTo(name));
        }

        public String toString() {
            return name;
        }
        
    }
}
