class SeperateAll {
static void swap(int[] a, int m, int n) {
  int t  = a[m];
  a[m]  =a[n];
  a[n] = t;
}
  public static void main(String [] s) {
      int []a = {0,0,0,2,0,0,2};

      int i=0,j=0,k=a.length-1;

      while(j<k){

     if (a[j]==0) {
          swap(a,i,j);
          i++;
          j++;
        }

else        if(a[j] ==1) {
          j++;
        } else if (a[j]==2) {
          swap(a,j,k);
          k--;
        }      }

      i=0;
      while(i<a.length){
        System.out.print(a[i]+ " ");
        i++;
        }
        System.out.println();


        int[] array = {4,6,2,3,9,7,1};
        quickSort(array,0,array.length-1);
    System.out.println("printing");
          for( i=0;i<array.length;i++) {
              System.out.print(array[i]+ " ");
          }
  }




  static void quickSort(int[] a, int m, int n){
      if(m<n) {
        int p = partition (a,m,n);
        quickSort(a,m,p-1);
        quickSort(a,p+ 1,n);

      }

  }
  static int partition(int []a, int m, int n) {

      int p = n;
      int j = p-1;

      for(int i=m;i<=j;i++) {

        if(a[i] >= a[p]) {
          swap(a,i,j);
          j--;
        }
      }

      j++;

      swap(a,j,p);

      System.out.println(m+" "+n+ " "+ j);
      return j;
  }
}
