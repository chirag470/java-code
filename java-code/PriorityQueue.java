import java.util.*;

class PriorityQueue<T> {

  private T[] array;
  private comparator<T> comp;

  public PriorityQueue(T [] a, comparator<T> c) {
    array =a;
    comp = c;
  }
  public  T[] getHeap() {
    return array;
  }
  public void buildHeap() {

     int s = array.length;
    for( int i=s-1;i>=0;i--) {
      heapify(i);
    }
  }

  private  int getLeft( int ind) {
    return (ind*2+1)<array.length ? (ind*2+1) : -1;
  }
  private  int getRight( int ind) {
    return (ind*2+2)<array.length ? (ind*2+2) : -1;
  }


  private void heapify( int ind){

     int s = array.length;
    if(getRight(ind) !=-1) {
       int l = getLeft(ind);
       int r = getRight(ind);

      if(comp.compare(array[ind] , array[l]) && comp.compare(array[ind] , array[r])) {
         int min =r;
        if(comp.compare(array[r] , array[l])) {
          min = l;
        }
        swap(ind, min);
        heapify(min);
      } else if(comp.compare(array[ind] ,array[l])) {
        swap(ind,l);
        heapify(l);
      } else if(comp.compare(array[ind] ,array[r])){
        swap(ind,r);
        heapify(r);
      }


    } else if(getLeft(ind) !=-1 && comp.compare(array[ind], array[getLeft(ind)])) {
        swap(getLeft(ind), ind);
        heapify(getLeft(ind));
    }
  }

  private  void swap( int a,  int b) {
     T temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
  public void print() {

    for ( int i=0;i<array.length;i++){

       System.out.println(array[i]+ " ");
    }
  }
  public static void main(String [] args) {


     Integer[] a = { 16, 8,14, 3, 6, 8, 5, 1, 34};

    PriorityQueue<Integer> pq = new PriorityQueue(a, new comparator<Integer>() {

      public boolean compare ( Integer a ,  Integer b) {
        if(a>b){
          return true;
        }
        return false;
      }
    });

    pq.buildHeap();
    a = pq.getHeap();
    pq.print();
  }

}

 interface comparator<T> {
  boolean compare ( T a ,  T b) ;

}
