/* package whatever; // don't place package name! */

import java.util.*;
import java.util.function.*;
import java.util.concurrent.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Test
{


	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here


	//	System.out.println(result);

		char[] in = {'D' ,'B' ,'E' ,'A', 'F', 'C'};
		char[] pre = {  'A', 'B', 'D' ,'E', 'C', 'F'};

		Test t = new Test();
		t.cons(pre, in, 0, 5);
	}

  int find(char[] in, int start , int end, char root) {

		for (int i=start; i<=end; i++) {
			if(in[i] == root) {
				return i;
			}
		}
		return -1;
	}


	Node cons(char[] pre, char[] in, int a, int b) throws RuntimeException{
		char root = pre[a];
    int pivot = find(in, a,b, root);
		if (pivot ==-1) {
			throw new RuntimeException("Mismatch");
		}
    Node curr = new Node(root);
		if(pivot==a && pivot!=b) {

			curr.left= null;
			curr.right = cons(pre, in, pivot+1, b);


		} else if(pivot==b) {

			curr.right=null;
			curr.left= cons(pre, in, a, pivot-1);
		} else {

			curr.left = cons(pre, in, a, pivot -1);
			curr.right = cons(pre, in, pivot +1, b);
		}

		return curr;
	}


}

class Node{
	int val;
	Node left,right;

	Node(int v) {
		val=v;
		left=null;
		right=null;
	}
}
