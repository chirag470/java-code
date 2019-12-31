/* package whatever; // don't place package name! */

import java.util.*;
import java.util.function.*;
import java.util.concurrent.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class BuildTree
{


	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here


	//	System.out.println(result);

	Node n = new Node(4);
  n.left = new Node(1);
  Node r = n.right = new Node(2);
  Node l = n.left ;
  l.left = new Node(5);
  Node lm = l.left.right = new Node(3);
  l.right = new Node (6);

  Node rl = r.left= new Node(7);
  rl.left = new Node(9);
	BuildTree bt = new BuildTree();
	//bt.inorder(n);

  Node root = new Node (1);
	Node temp  = root.left = new Node(2);


  Node fin = 	bt.removeHalf(root);
	System.out.println("done");
	if(fin == null) {
  	bt.inorder(root);
	} else {
		bt.inorder(fin);
	}
  }


  void inorder(Node n) {
		if(n != null) {
			inorder(n.left);
				System.out.println(n.val);
			inorder(n.right);
		}
	}

  Node removeHalf(Node n) {
		if (n != null){

			if(n.left==null && n.right ==null) {
				return null;

			} else if(n.right == null) {
				Node l = removeHalf(n.left);
				if(l != null) {
					n.left = l;
				}
				return n.left;

			} else if (n.left == null ) {
				Node r = removeHalf(n.right);
				if(r != null) {
					n.right = r;
				}
				return n.right;
			} else {
				Node l = removeHalf(n.left);
				Node r = removeHalf(n.right);
				if(l != null) {
					n.left = l;
				}
				if(r != null) {
					n.right = r;
				}
			}
		}
		return null;
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
