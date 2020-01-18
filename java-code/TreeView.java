/* package whatever; // don't place package name! */

import java.util.*;
import java.util.function.*;
import java.util.concurrent.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class TreeView
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



  TreeView t= new TreeView();
  //t.inorder(n);
  t.topView(n);
  }
  void inorder(Node n) {
		if(n != null) {
			inorder(n.left);
				System.out.println(n.val);
			inorder(n.right);
		}
	}


  void leftView(Node root) {

      LinkedList<Node> q = new LinkedList<>();
      q.add(root);
      int count=1,temp=0;
      while(q.size() > 0) {
          Node n = q.peek();
          System.out.println(n.val);
          temp=0;
          while(count>0) {
            n = q.remove();
            count--;
            if(n.left!=null) {
              q.add(n.left);
              temp++;
            }
            if(n.right!=null) {
              q.add(n.right);
              temp++;
            }
          }
          count = temp;
        }
    }

    void topView(Node root) {

      TreeMap<Integer,Integer> map =new TreeMap<>();
      LinkedList<NodeLevel> q = new LinkedList<>();
      NodeLevel nl = new NodeLevel(root, 0);
      q.add(nl);
      map.put(0,root.val);

      while(q.size() >0) {
          NodeLevel n = q.remove();
          Node innode=n.node;
          if(map.get(n.level)==null) {

            map.put(n.level, innode.val);
          }

          if(innode.left!=null) {
            q.add(new NodeLevel(innode.left, n.level-1));
          }
          if(n.node.right!=null) {
            q.add(new NodeLevel(innode.right, n.level+1));
          }
      }


      while(map.size()>0) {
        int k = map.firstKey();
        System.out.println(map.get(k));
        map.remove(k);
      }
    }

    class NodeLevel {
      Node node;
      int level;
      NodeLevel(Node n, int l) {
        node=n;
        level=l;
      }
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
