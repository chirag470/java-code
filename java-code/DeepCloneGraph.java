import java.util.*;

class DeepCloneGraph {
  public static void main(String []arga){

      //  System.out.print(n.val+ " " );
      Node one = new Node(1);
      Node two  = new Node(2);
      Node three=new Node(3);
      Node four = new Node(4);
      Node five = new Node(5);

Node head= one;
      one.nb.add(two);
      one.nb.add(three);

      two.nb.add(one);
      two.nb.add(three);
      two.nb.add(four);

      three.nb.add(one);
      three.nb.add(two);

      four.nb.add(two);
      four.nb.add(five);

      five.nb.add(four);

      bfs(head);
      Node h2 = cloneGraph(head);
  bfs(h2);
  }

  static Node cloneGraph(Node head1){

    Map<Node,Node> map =new HashMap<Node,Node>();
    Set<Node> set = new HashSet<Node>();
    set.add(head1);
    Node head2= new Node(head1.val);
    map.put(head1,head2);

    cloneDfsHelper(head1,head2,map, set);
    return head2;
  }
   static void cloneDfsHelper(Node n1,Node n2,Map<Node,Node> map, Set<Node> set) {
      set.add(n1);
      map.put(n1,n2);
      for(Node n:n1.nb) {
        if(!set.contains(n)) {
          if(set.contains(n)) {
            Node t= map.get(n);
            n2.nb.add(t);
            t.nb.add(n2);
          } else {
            Node t= new Node(n.val);
            n2.nb.add(t);
            t.nb.add(n2);
            cloneDfsHelper(n,t,map,set);
          }
        }

      }
   }

   static void bfs(Node n) {
     Queue<Node> q = new LinkedList<>();
     Set<Node> set = new HashSet<>();
     q.add(n);
     set.add(n);

     while(q.size()>0) {
       Node t = q.remove();
       System.out.print(t.val+ " " );
       for(Node neig: t.nb) {
         if(!set.contains(neig)) {
           q.add(neig);
           set.add(neig);

         }
       }
     }
     System.out.println();
   }

}


class Node{

  int val;
  List<Node>nb;
  Node(int v){
    val  =v;
    nb=new ArrayList<Node>();
  }
}
