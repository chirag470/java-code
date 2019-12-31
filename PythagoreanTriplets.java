import java.util.*;
import java.util.function.*;
import java.util.concurrent.*;
import java.lang.*;
import java.io.*;



class PythagoreanTriplets {


    public static void main(String[] args) {

          int len;
          Scanner sc = new Scanner(System.in);
          len  = sc.nextInt();
          int []a = new int[len];
          int i=0;
          for (int val: a){
             a[i] = sc.nextInt();
             i++;
          }

          i=0;
          for (int val: a){
            a[i] = val * val;
            i++;
          }


          i=0;

          Arrays.sort(a);

        int total = 0;
          for (i=2;i<a.length;i++) {
            if(a[i] !=0) {
              total += findSumPair(a,a[i],0,i-1);
            }


          }
          System.out.println("total are  "+ total);



    }

     static int findSumPair(int []arr, int sum, int a, int b) {
        int i=a,j=b;
        int total = 0;
        while(i<j) {
          if(arr[i] + arr[j] > sum) {
            j--;
          } else if(arr[i] + arr[j] < sum) {
            i++;
          } else if(arr[i]==0){
            i++;

          } else {
            System.out.println((int)Math.sqrt(arr[i]) + " "+ (int)Math.sqrt(arr[j])+ " "+ (int)Math.sqrt(sum));
            total+=1;
            int f = arr[i];
            int s = arr[j];
            while(arr[i+1]==arr[i]) {
                i++;
              System.out.println((int)Math.sqrt(f) + " "+ (int)Math.sqrt(s)+ " "+ (int)Math.sqrt(sum));
              total+=1;

            }

            while(arr[j-1]==arr[j]) {
              System.out.println((int)Math.sqrt(f) + " "+ (int)Math.sqrt(s)+ " "+ (int)Math.sqrt(sum));
              total+=1;
              j--;
            }




            i++;
            j--;
          }
        }
        return total;

    }


}
