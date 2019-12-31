import java.util.*;
class ReverseLinkedList {


  public static void main (String[] args) {


    Node node = new Node(1);
    Node head = node;
    node.next= new Node(2);
  node = node.next;
    node.next= new Node(3);
    node = node.next;
      node.next= new Node(4);
      node = node.next;
        node.next= new Node(5);
        node = node.next;
          node.next= new Node(6);





ReverseLinkedList r = new ReverseLinkedList();
r.print(head);
Scanner sc = new Scanner(System.in);
/*int k = sc.nextInt();
Node newHead = r.rotateByK(head, k);
r.print(newHead);
*/
int k = sc.nextInt();

Node newHead = r.reverseByK(node, k);

r.print(newHead);

  }



  Node reverse(Node node) {

      if(node == null) {
        return node;
      }  else {

         Node prev = null;
         Node curr = node;
         Node next = node.next;

         while(next!=null) {
           curr.next = prev;
           prev = curr;
           curr = next;
           if(next!=null) {
             next = next.next;
           }

         }
         curr.next = prev;
         return curr;
      }

  }


  void print(Node node) {
    Node n=node;
    while(n!= null) {
      System.out.println(n.val+ " lul");
      n = n.next;
    }
  }


  int length(Node node) {
    int len = 0;
    while(node != null){
      node = node.next;
      len++;
    }
    return len;
  }

  Node rotateByK(Node node, int k) {
      int len = length(node);
      if(len==0|| len==1) {

        return node;
      }

      if(k%len == 0) {
        return node;
      }

      int temp = len - k%len ;
      Node n = node;
      System.out.println(temp+ " temp");

      print(node);
      while(temp>1) {
        n= n.next;
        temp--;
      }

      Node h = n.next;
      n.next = null;

      Node p = h;
      while(p.next!=null) {
        p = p.next;
      }
      p.next = node;

      return h;

  }



  Node reverseByK(Node node, int k) {
  Node mainHead =null;
      if(k> length(node)){
      return node;}


    Node prev = null;
    Node curr = node;
    Node next = node.next;

    while(next!= null) {

        int c = k;
        Node h = curr;
        Node t = prev;

        while(c-->1&& next!= null) {

            curr.next = prev;
            prev = curr;
            curr = next;
            if(next.next!=null) {
              next = next.next;
            }
        }

        curr.next = prev;

        if(t!=null) {
          t.next = curr;
        } else {
             mainHead  = curr;
        }
        h.next = next;

        prev = h;
        curr = next;
        if(next!=null) {
          next = next.next;
        }

        t= prev;
        h = curr;

    }
    return mainHead;


  }
}

class Node{
  int val;
  Node  next;

Node (int v) {
  val = v;
  next = null;
}



}
