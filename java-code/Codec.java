


import java.util.*;
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x;
      left=null;
    right = null; }
 }

public class Codec {

public static void main(String[] args) {


  Codec c = new Codec();




       /*create root*/
       TreeNode root = new TreeNode(1);

       /* following is the tree after above statement

             1
           /   \
         null  null     */

       root.left = new TreeNode(2);
      root.right =new TreeNode(3);

       /* 2 and 3 become left and right children of 1
              1
            /   \
           2      3
         /    \    /  \
       null null null null  */


     root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
           root.right.right = new TreeNode(6);
           root.left.left.right = new TreeNode(7);


//c.bfs(r);

}
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root == null) {return "null";}
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode nullNode = new TreeNode(-1);

        StringBuffer sb = new StringBuffer();
        q.add(root);
        int win=1;
        int w=win;
        boolean hasMore = true;
        while(q.size()>0 && hasMore==true) {
            hasMore = false;
            while(w>0) {

                w--;

                TreeNode n = q.remove();
                if(n==nullNode) {
                   sb.append("null");
                   sb.append(",");

                    //q.add(nullNode);
                  //q.add(nullNode);
                } else {
                     sb.append(n.val);
                     sb.append(",");
                    if(n.left==null) {
                        q.add(nullNode);
                    } else {
                         q.add(n.left);
                         hasMore = true;
                    }
                    if(n.right==null) {
                        q.add(nullNode);
                    }else {
                        q.add(n.right);
                         hasMore = true;
                    }

                }
            }

            win=win*2;
            w=win;

        }

        String s = sb.substring(0,sb.length()-1);

        return s;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("null".equals(data)) {
          return null;
        }
        String[] arr = data.split(",");

        Queue<TreeNode>q = new LinkedList<TreeNode>();
        TreeNode rt = new TreeNode(Integer.valueOf(arr[0]));
        q.add(rt);
        int i=1;

        while(q.size()>0&& i<arr.length) {

          TreeNode n= q.remove();
          String l = arr[i] ;i++;
          String r = arr[i];i++;

          if(l.equals("null")) {
            n.left = null;
          }else {
            n.left = new TreeNode(Integer.valueOf(l));
            q.add(n.left);
          }

          if(r.equals("null")) {
            n.right = null;
          }else {
            n.right = new TreeNode(Integer.valueOf(r));
            q.add(n.right);
          }

        }
        return rt;

    }

private void preorder(TreeNode node) {
  if(node == null){ return;}
  preorder(node.left);

  System.out.print(node.val+" ");

  preorder(node.right);
}


private void serializeToPreOrderWithN(TreeNode node, StringBuffer sb) {

       if(node==null) {
           sb.append("N");
            sb.append(",");
       } else {

           sb.append(node.val+"");
            sb.append(",");
             serializeToPreOrderWithN(node.left, sb);
           serializeToPreOrderWithN(node.right, sb);
       }
   }

    private int deserializeFromPreOrderWithN(String[] pre,TreeNode root, int cur, char dir) {

           if("N".equals(pre[cur])) {

               if(dir == 'l') {
                   root.left = null;
               } else if(dir=='r'){
                   root.right = null;
               }
               return 1;
           }


          TreeNode n = new TreeNode(Integer.valueOf(pre[cur]));
             if(dir == 'l') {
                   root.left = n;
               } else if(dir=='r'){
                   root.right = n;
               }


           int updated1 = deserializeFromPreOrderWithN(pre,n, cur+1,'l');
           int updated2 = deserializeFromPreOrderWithN(pre, n, cur+1+updated1, 'r');

           return 1+updated1+updated2;

       }
    public void bfs(TreeNode root) {
      if(root==null) {return;}
      Queue<TreeNode> q = new LinkedList<TreeNode>();

      q.add(root);
  System.out.println("bfs--");
      while(q.size()>0) {
        TreeNode n = q.remove();
          System.out.print(n.val+ " ");
          if(n.left!=null) {
            q.add(n.left);
          }
          if(n.right!=null) {
            q.add(n.right);
          }
      }
      System.out.println();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
