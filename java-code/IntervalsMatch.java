import java.util.*;
import java.io.*;
class IntervalsMatch {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here

          Scanner s = new Scanner(new FileInputStream("input.txt"));
        String name = s.nextLine();
        int n;

        n= Integer.parseInt(name);
        //String [] sa;
        int a,b;
        Node [] ar = new Node[n];
        for(int i=1;i<=n;i++) {
            name =      s.nextLine();
            String[] sa= name.split(" ");
            //ar[i] = new Node(Integer.parseInt(sa[0]),Integer.parseInt(sa[1]));
             a = Integer.parseInt(sa[0]);
            b = Integer.parseInt(sa[1]);
            ar[i-1] = new Node(a,b);


        }
        Arrays.sort(ar);


        name = s.nextLine();
        int q = Integer.parseInt(name);
        //int a,b;
        int count=0;
        for( int j=1;j<=q;j++) {

            name = s.nextLine();
             String[] sa= name.split(" ");
            a = Integer.parseInt(sa[0]);
            b = Integer.parseInt(sa[1]);
            count=0;



            int p1= bin(ar, 0, ar.length-1, a);
            int p2 = bin(ar, 0, ar.length-1, b);

            if(p1 > ar.length-1) {
              System.out.println(0);
              continue;
            }
            if(ar[p1].e != a) {
              p1=p1+1;
            }
            System.out.println(p2-p1+1);



            //System.out.print(p1 + " "+p2);
        }








    }


    static int bin(Node[] ar,int a, int b,   int t) {

        if(a==b && ar[a].e > t) {
          return a-1;
        } else if(a==b && t> ar[a].e) {
          return a;
        }

        if(a>b)return b;
        int p = (a+b)/2;
        if(ar[p].e==t) return p;
        else if(ar[p].e<t) return bin(ar, p+1, b, t);
        else return bin(ar, a, p-1, t);

    }


}
class Node implements Comparable<Node> {
        int s,e;
        Node(int a, int b) {
            s=a;
            e=b;
        }
        @Override
        public int compareTo(Node n) {
            if(this.e<n.e) {
                return -1;
            } else if(this.e==n.e) {
                return 0;
            } else {
                return 1;
            }
        }
    }
