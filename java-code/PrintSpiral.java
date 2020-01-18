/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class PrintSpiral
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here

		int n=5;
		int[][] a = new int [4][4];
		int count = 1;
		for(int i=a.length;i>0;i-=2){
			count = spir(a,i,count);
		}

			for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {

			  System.out.print(a[i][j]+" ");
			}
			  System.out.println();


			}



	}
	static int spir(int [][] a, int s,int count) {


		int diff = (a.length-s)/2;
	 System.out.println(diff);
  	int y1 = diff;
		int y2 = a.length-diff-1;

		int x1 = diff;
		int x2 = a.length-diff-1;

		for(int j=y1;j<=y2;j++) {
			a[x1][j] = count;
			count++;
		}
		for(int i=x1+1;i<=x2;i++) {
			a[i][y2] = count;
			count++;
		}

		for(int j=y2-1;j>=y1;j--) {
			a[x2][j] = count;
			count++;
		}

		for(int i=x2-1;i>x1;i--) {
			a[i][y1] = count;
			count++;
		}
		return count;

	}
}
