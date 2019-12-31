/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class findSumGreaterThanK
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int []a = {6,6,6,7 };
		int w = findSumGreaterThanK(a,6);


	}

	static int findSumGreaterThanK(int []a, int k){

		int w = a.length;
		int i=0,j=0,len = w;
		int sum = a[i];

		while(i<len&& j<len && i<=j) {
			if(sum==k) {
				w= j-i+1 ;
					System.out.println(i+ " "+ j);
				i++;
				j++;

				if(i<len&&j<len) {
					sum+=a[j];
					sum-=a[i-1];
				}



		} else if(sum < k) {
			j++;
			if(j<len) {
				sum+=a[j];
			}
		} else {
			if(i==j) {

				i++;
				j++;
				sum=a[i];
			}
			else {
				sum-=a[i];
				i++;

			}
		}
		}

		return w;



	}
}
