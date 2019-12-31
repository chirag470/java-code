
import java.util.*;
class NoOfSteps {
    public static void main(String[] args) {


        String s;


        //Scanner sc = new Scanner(System.in);

          //s  = sc.nextLine();
          int[] steps = {1, 2, 3};


            System.out.println(noOfSteps(10,steps));

    }


    static int noOfSteps(int N, int [] steps) {


      int [] stairs  = new int [N+1];

      for(int i=0;i<stairs.length;i++) {
        stairs[i]=0;
      }
      int tot=0;
      for(int i=1;i<=N;i++) {
          tot=0;
          for(int j=0;j<steps.length;j++) {
                if(i-steps[j] ==0) {
                  tot+=1;
                } else if(i-steps[j] >0&& stairs[i-steps[j]]>0){
                  tot +=stairs[i-steps[j]];

                }

          }
          stairs[i] = tot;
      }

      return stairs[N];
}
}
