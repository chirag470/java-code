import java.util.*;


class  PrintTriangle{

public static void main (String[] args) {

        int n=0;

        int sp = n-1;

        for(int i=1;i<=n;i++) {

          for(int j=1;j<=sp;j++) {
            System.out.print(" ");
          }
          for(int j=1;j<=i;j++) {
            System.out.print("* ");

          }
          sp--;
            System.out.println();

        }

        printPlus("FEVER");

      }


      static void printPlus(String s) {


          int si = s.length();
          for (int i=0;i<si;i++) {


            if(i==si/2) {
                for (int j=0;j<si;j++) {
                    System.out.print(s.charAt(j)+ " ");
                }
            } else {
              for (int j=0;j<si;j++) {
                  if(j==si/2){
                    System.out.print(s.charAt(i)+ " ");
                  } else {
                    System.out.print( "X ");
                  }

              }
            }
            System.out.println();
          }


      }
}
