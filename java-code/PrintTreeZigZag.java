import java.util.*;


class PrintTreeZigZag {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.left.right = new Node(7);

        print(root);
    }


    static void print(Node root){
        if(root == null){
          return;
        }

        Queue<Node>q = new LinkedList<Node>();
        q.add(root);
        Stack<Integer> s = new Stack<Integer>();
        int dir = 1;
        int size=1;
        while(q.size()>0){
            size = q.size();
            while(size-->0) {
              Node n = q.remove();
              if(n.left !=null) {
                q.add(n.left);

              }
              if(n.right !=null) {
                q.add(n.right);

              }


            if(dir==1) {


                  System.out.print(n.val+ " ");


            } else {

                s.add(n.val);
                //System.out.print(n.val+ " ");
            }
          }


            if(dir == -1) {
                while(s.size()>0) {
                int v = s.pop();
                System.out.print(v+ " ");

              }
            }
            System.out.println();

            dir = dir * (-1);
        }


    }

}


class Node {

  int val;
  Node left,right;

  Node(int v) {

    val = v;
    left=null;
    right = null;
  }
}
