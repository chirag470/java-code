import java.util.*;


class  PrintZigZag{

public static void main (String[] args) {

        int n=17;

      
        int count=1,level = 1, fin,dir = 1;

        while(count<=n) {
            fin = count+level-1;
            if(fin > n) {
              fin = n;
            }
            if(dir == 1) {
              for(int i=count;i<=fin;i++) {
                System.out.print(i + " ");
                count++;
              }
            } else {
              int cur =count;
              for(int i=fin;i>=cur;i--) {
                System.out.print(i + " ");
                count++;
              }
            }
            level++;
            dir = dir * (-1);
            System.out.println();
        }
    }



}
