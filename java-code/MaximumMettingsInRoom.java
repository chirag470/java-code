// Java program to demonstrate
// working of toLowerCase() method
import java.util.*;
class MaximumMettingsInRoom {
	public static void main(String args[])
	{
		String s = "Welcome! to Geeksforgeeks Planet.";

		// converting string s to lowercase letter
		String gfg1 = s.toLowerCase();
		System.out.println(gfg1);

		List<node> list = new ArrayList<node>();

		int []f = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924};
		int []g = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252 };
		int t = f.length;

		while(t--> 0){

		    node n=new node();
		    n.s = f[t];
		    n.e = g[t];
		    list.add(n);
		}





		Collections.sort(list, new Comparator<node> () {

		    public int compare(node a, node b) {
		        return a.e-b.e;
		    }
		});



		int []ans = new int[list.size()];
		ans[0]=1;
		 for (int i=1;i<list.size();i++){

		     int fin = 1;
		     int j=i-1;
		     while(j>=0 && list.get(j).e>list.get(i).s) {
		         j--;
		     }

		     if(j>=0) {
		         fin = ans[j]+fin;
		     }

		     if(fin > ans[i-1]) {
		         ans[i]=fin;
		     } else {
		         ans[i]=ans[i-1];
		     }
		 }


		   System.out.println(ans[list.size()-1]);





	}
}

class node{
    int s,e;
}
