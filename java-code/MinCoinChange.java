import java.util.*;

class MinCoinChange {



public static void main (String[] args) {

int amount = 4, coins[] = {5};

System.out.println(coinChange(coins, amount));
}
    public static int coinChange(int[] coins, int amount) {

         Arrays.sort(coins);
        int [] ch = new int[amount+1];
        int min= Integer.MAX_VALUE;
        int localMin=min,temp=min;
        ch[0]=0;
        for (int i=1;i<ch.length;i++) {
            ch[i] =0;
            localMin=Integer.MAX_VALUE ;
            temp=Integer.MAX_VALUE;
            for (int j=0;j<coins.length;j++) {

                if(i-coins[j] >=0 && ch[i-coins[j]] !=-1) {
                    temp = 1+ch[i-coins[j]];
                }
                if(temp < localMin) {
                     localMin =temp;
                }
            }
            ch[i] = localMin;
            if(localMin == Integer.MAX_VALUE) {
                ch[i] = -1;
            }

        }

        for (int i=1;i<ch.length;i++) {

                 if(ch[i]!=-1&&ch[i] < Integer.MAX_VALUE){
                     min = ch[i];
                 }
        }


        if(min==Integer.MAX_VALUE) {
          return -1;
        }

        return min;
    }
}
