/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CyclicLinkedList
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Node h = new Node(1);
		h.next = h;
		System.out.println(check(null));

	}
	public static boolean check(Node h){

	    Set<Node> s = new HashSet<>();

	    Node p = h, temp = null;
	    while(p !=null) {
	        if(s.contains(p)) {
	            temp.next = null;
	            return true;
	        }
	        s.add(p);
	        p = p.next;
	        temp = p;
	    }
	    return false;
	}
}

class Node {

    int val;
    Node next;
    Node(int v) {
        val =v;
        next = null;
    }
}
