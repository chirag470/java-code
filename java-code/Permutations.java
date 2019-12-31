/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Permutations
{
	static int counter = 0;
	public static void main (String[] args) throws java.lang.Exception
	{
		char []a = {'a','b','c','d'};

		int [][]mat = new int[a.length][a.length];
for(int i=0;i<a.length;i++) {
	for(int j=0;j<a.length;j++) {
		mat[i][j] = 0;
	}}


		permut(a, 0, a.length, mat);
	System.out.println(counter);


	}

	static void print(char[]s) {
		for(int i=0;i<s.length;i++) {
			System.out.print(s[i]+ " ");

		}
		System.out.println();
		counter++;
	}

	static void swap(char[] s, int a , int b) {
		char temp = s[a];
		s[a]=s[b];
		s[b]=temp;
	}
	static void permut(char []s, int a, int b, int [][] mat){

		if(a==b) {
			print(s);
		} else {
			permut(s,a+1,b, mat);
			for(int i=a+1;i<=b;i++) {

				if(s[a]!=s[i]&& mat[a][i] ==0) {
					swap(s,a,i);
					permut(s,a+1,b, mat);
					swap(s,a,i);
					mat[a][i] = 1;
					mat[i][a] = 1;

				}

			}

		}

	}
}
