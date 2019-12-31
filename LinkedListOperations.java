/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class LinkedListOperations  ///Ideone
{


	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here

		LinkedListOperations llo = new LinkedListOperations();


		LL l1 = new LL();
		l1.add(1).add(2).add(3).add(4);//.add(5).add(6);


	    LL l2 = new LL();
		l2.add(7).add(8).add(9).add(10).add(11);

l2.tail.next = l1.tail;
l1.add(5).add(6);

l1.print();

l2.print();


Node n = llo.findIntersection(l1,l2);
	System.out.println(n!= null ? n.val+" ans" : "no intersection");


	}
	int length(LL l) {
		int len  =0;
		Node h = l.head;
		while(h!=null){
			len+=1;
			h = h.next;
		}
		return len;
	}

	Node findIntersection(LL l1, LL l2){

		Set<Node> set = new HashSet<Node>();
		Node head1= l1.head;
		while(head1!= null){
			set.add(head1);
			head1 = head1.next;
		}

		Node head2 = l2.head;
		while(head2!= null){
			if(set.contains(head2)) {
				return head2;
			}
			head2=head2.next;
		}
		return null;
	}

	Node findIntersection2(LL l1, LL l2){

		int len1 = length(l1);
		int len2= length(l2);

		Node h1 = l1.head;
		Node h2 = l2.head;
    Node lng,shrt;
    int diff = 0;
		if(len1> len2) {
			diff = len1-len2;
			lng = h1;
			shrt = h2;
		} else {
			diff = len2-len1;
			lng = h2;
			shrt=h1;
		}

		while(diff >0) {
			lng = lng.next;
			diff--;
		}

		while(lng!= shrt) {
			lng=lng.next;
			shrt=shrt.next;
		}
		return lng;


	}
	int addTwoListsInReverseHelper1(Node m, Node n) {
      if(m.next == null) {
				int sum = (m.val+ n.val)%10;
				int carry = (m.val+ n.val)/10;
					n.val= sum;
				return carry;
			} else {
				int carry = addTwoListsInReverseHelper1(m.next, n.next);
				int sum = (m.val+ n.val + carry)%10;
				carry = (m.val+ n.val + carry)/10;
				n.val= sum;
				return carry;
			}
	}
	int addTwoListsInReverseHelper2(int carry, Node start, Node end) {

		if(start.next==  end) {
			int sum= (start.val +carry)%10;
			int c = (start.val +carry)/10;
			start.val = sum;
			return c;
		} else {
			int c = addTwoListsInReverseHelper2(carry, start.next, end);
			int sum= (start.val +c)%10;
			 c = (start.val + c)/10;
			start.val = sum;
			return c;
		}
	}
  LL addTwoListsInReverse(LL l1, LL l2) {
		if(l1.head == null) {
			return l2;
		} else if(l2.head == null) {
			return l1;
		} else {
			Node a = l1.head;
			Node b = l2.head;
			int la = length(l1);
			int lb  =length(l2);

      int diff = 0;

			if(la > lb) {
				diff = la-lb;
				while(diff> 0) {
					a = a.next;
					diff--;
				}
				int carry = addTwoListsInReverseHelper1(b,a);
				carry = addTwoListsInReverseHelper2(carry, l1.head, a);
				if(carry > 0) {
					Node newHead = new Node(carry);
					newHead.next = l1.head;
					l1.head = newHead;
				}
				return l1;

			} else {
				diff = lb-la;
				while(diff> 0) {
					b= b.next;
					diff--;
				}
				int carry = addTwoListsInReverseHelper1(a,b);
				carry = addTwoListsInReverseHelper2(carry, l2.head, b);
				if(carry > 0) {
					Node newHead = new Node(carry);
					newHead.next = l2.head;
					l2.head = newHead;
				}
				return l2;
			}
		}
	}

	LL addTwoLists(LL l1,LL l2) {

		Node h1 = l1.head;
		Node h2 = l2.head;

		if(h1 == null) {
			return l2;
		} else if (h2 == null) {
			return l1;
		} else {

			LL res = new LL();

			int carry = 0;
			do {
				int sum  = h1.val + h2.val + carry;
				res.add(sum % 10);
				carry = sum /10;
				h1 = h1.next;
				h2 = h2.next;

			} while(h1 != null && h2 != null);

			Node h;
			if (h1==null && h2 ==null) {

					if( carry > 0) {
						res.add(1);
					}
					return res;


			} else if (h1 ==null){
				h = h2;
			} else {
				h= h1;
			}

			while(h.next != null) {
				int sum  = h.val + carry;
				res.add(sum % 10);
				carry = sum / 10;
				h = h.next;
			}
			int sum = h.val + carry;
			if (sum < 10) {
				res.add(sum);

			} else {
				res.add(sum % 10);
				res.add(1);
			}
			return res;
		}

	}
}

class LL {

	Node head;
	Node tail;
	LL add(int v){
		if(head==null) {
			head = new Node(v);
			tail = head;
			return this;
		} else {
		Node n = new Node(v);
		tail.next = n;
		tail= tail.next;
		return this;
		}
	}

	void print() {
		Node h = head;
		while(h !=null) {
			System.out.print(h.val+" ");
			h = h.next;
		}
			System.out.println();
	}


	void reverse() {

		if(head!=null && head.next !=null) {

			Node p = null;
			Node c = head;
			Node n = head.next;
			while(true) {
				c.next = p;
				p = c;
				c= n;
				if(n==null) break;
				n = n.next;
				//System.out.println(c.val + " "+ p.val);

			}
			head = p;
		}
	}

	}

	class Node {

		int val;
		Node next;

		Node (int v) {
			val = v;
		}
	}
