import java.util.*;
class DeepClone {

  public static void main(String [] args) {

    Map<Integer, Node> map = new HashMap<Integer,Node>();

    Node head = new Node(1);
    map.put(1,head);
    Node node = head;
    node.next = new Node(2);
    map.put(node.val,node);
    node = node.next;

    node.next = new Node(3);
    map.put(node.val,node);

    node = node.next;

    node.next = new Node(4);
    map.put(node.val,node);

    node = node.next;

    node.next = new Node(5);
    map.put(node.val,node);

    node = node.next;

    node = head;
    //while(node!=null) {
    node.random = map.get(4);
    node = node.next;

    node.random = map.get(3);
    node = node.next;

    node.random = map.get(1);
    node = node.next;

    node.random = null;
    node = node.next;
    node.random = map.get(1);
    node = node.next;


    node =cloneList(head);
    while(node!=null) {

        System.out.println(node.random!=null?node.random.val: "null");
    node = node.next;
    //}
    }



  }

  static Node cloneList(Node head) {
    if(head==null) {
      return head;
    }
    Map<Node,Node> map = new HashMap<Node,Node>();
    Node head2 = new Node(head.val);
    map.put(head,head2);
    Node node1 = head;
    Node node2 = head2;

    while(node1.next!=null) {
      node1=node1.next;
      Node n = new Node(node1.val);
      node2.next = n;
      node2=n;
      map.put(node1, node2);
    }
    node2=head2;

    node1=head;
    while(node1!=null) {
      Node ran = map.get(node1.random);
      node2.random = ran;
      node1=node1.next;
      node2=node2.next;

    }


    return head2;



  }
}
class Node{
  int val;
  Node  next;
  Node random;

Node (int v) {
  val = v;
  next = null;
  random = null;
}
}
