import java.util.*;


class Code {

public static void main(String[] args) {


			int [] a = {1,2,3};
			int target=3;
			find(a,target);
	}


	static int find(int[] a, int target) {

/*			for ( int i=0;i<2;i++) {


				for(int j=0;j<a.length;j++) {
					System.out.print(mat[i][j]+ " ");

				}
					System.out.println();
			}
*/
			int count = 0;
			List<List<Integer>> list1 = new ArrayList<List<Integer>>();
			List<List<Integer>> list2 = new ArrayList<List<Integer>>();



					List<Integer> l1 =new ArrayList<Integer>();
						List<Integer> l2 =new ArrayList<Integer>();
					l1.add(a[0]);
					l2.add(a[0]*(-1));

					list1.add(l1);
					list2.add(l2);

					for (int i=1;i<a.length;i++) {

						  l2 = list2.get(i-1);
							int sum;
							List l1new = new ArrayList<Integer>();
							for(int num: l2){

								sum = a[i]+num;
								l1new.add(sum);
								if(sum==target && i==a.length-1) {
									count++;
								}
							}
							list1.add(l1new);

						   l1 = list1.get(i-1);
							 List l2new = new ArrayList<Integer>();
							for(int num: l1){

								sum = (a[i]*(-1))+num;
								l2new.add(sum);
								if(sum==target && i==a.length-1) {
									count++;
								}
							}
							list2.add(l2new);

					}





		return count;


	}
}
