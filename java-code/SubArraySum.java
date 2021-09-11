/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class SubArraySum
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here

		int [] a = {1,2,3,4,5,1,6,7,8,9};
		findSum(a,7);

	}

	public static void findSum(int [] a,int  sum) {
	   int start=0;
	   int s = 0;
	   int n = a.length;
	   int j;
	   for(int i=0;i<n;i++) {

	       s = s+ a[i];
	       while(j<=i && s >=sum) {
	           if(s ==sum) {
	               System.out.println(j+ ", "+i);
	           }
	           s = s - a[j];
	           j++;

	       }

	   }
	}
}
