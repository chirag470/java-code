/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class MaxSumSubarray {
	public static void main (String[] args) {
		//cod

		String[] sarr;
		long[] arr;
Scanner sc = new Scanner(System.in);

int tot = Integer.parseInt(sc.nextLine());
while(tot>0) {
    tot--;
    sc.nextLine();
 sarr = sc.nextLine().split(" ");

 arr = new long[sarr.length+1];
arr[0]=0;
for(int i = 0;i<sarr.length;i++) {
arr[i+1] = Long.parseLong(sarr[i]);
}


boolean allneg = true;
long max = arr[1];
for(int i = 1;i<arr.length;i++) {
  if(arr[i]>max){ max = arr[i];}
   if(arr[i] > 0) {
     allneg = false;
   }
}
if(allneg == true) {

  System.out.println(max);
continue;
}

for(int i = 1;i<arr.length;i++) {

arr[i] = arr[i-1]+arr[i];
}


long ans = 0;
long min = arr[0];
for(int i = 1;i<arr.length;i++) {

if(arr[i] < min ) {
min = arr[i];
} else if(arr[i]-min > ans){
ans = arr[i] -min;
}

}
  System.out.println(ans);
}
	}
}
