import java.util.*;


class  WierdPattern{

public static void main (String[] args) {

        int n=3;
        int level=n;
        int counts=1,counte=n*n+n;
        int start;
        while(level>0) {


          int temp=level;
          while(temp-->0) {
            System.out.print(counts+" ");
            counts++;
          }

          temp=level;
          start = counte;
          while(temp>0) {
            System.out.print(start-temp+1);
            System.out.print(" ");
            temp--;
            counte--;

          }
          level--;
          System.out.println();

        }



    }
}
