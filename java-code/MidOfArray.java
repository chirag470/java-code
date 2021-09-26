/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class MidOfArray
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int a[] = {100,101,5,6,7};
		int a2[] = {6,7,8,9,10,11,1,2};

		System.out.println(a[findMid(a)]);
}

public static int findMid(int[] a) {

if(a.length==1) {
return a[0];
}

	return findMidHelper(a, 0, a.length-1);
}


public static int findMidHelper(int []a, int start, int end) {

	if(start == end) {
		return start;
	}else {
		int p = start + end;
		p = p/2;
		System.out.println("p is " + p);
		if(p==start)
			return start;

		if(a[p]<a[p+1] && a[p] < a[p-1]) {
			return p;
		}else if(a[end] > a[p]){
			  return findMidHelper(a, start, p-1);
		} else {
			return findMidHelper(a, p+1, end);
		}
	}
}


}
